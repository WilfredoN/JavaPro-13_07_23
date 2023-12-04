package bank.account;

import bank.person.Person;
import bank.person.PersonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("testing")
class AccountControllerIntegrationTest {

    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    protected PersonRepository personRepository;
    @Autowired
    protected AccountRepository accountRepository;
    @Autowired
    protected ObjectMapper objectMapper;

    @Test
    public void shouldGetAccounts() throws Exception {
        var request = get("/api/accounts");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void shouldCreateAccount() throws Exception {
        var person = personRepository.save(Person.builder()
                .uid(UUID.randomUUID().toString())
                .name("Test")
                .email("test@gmail.com")
                .build());
        System.out.println("Person:\n" + person);
        var account = accountRepository.save(Account.builder()
                .uid(UUID.randomUUID().toString())
                .person(person)
                .balance(1000)
                .iban("UA01INHO0000000001")
                .build());
        System.out.println("Account:\n" + account);
        var request = post("/api/person/" + person.getUid() + "/accounts")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(AccountDTO.builder()
                        .id(account.getUid())
                        .iban(account.getIban())
                        .balance(account.getBalance())
                        .personId(person.getUid())
                        .build()));

        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }

    @Test
    public void shouldGetPersonAccounts() throws Exception {
        var person = personRepository.save(Person.builder()
                .uid(UUID.randomUUID().toString())
                .name("Test")
                .email("test@gmail.com")
                .build());
        var account = accountRepository.save(Account.builder()
                .uid(UUID.randomUUID().toString())
                .person(person)
                .balance(1000)
                .iban("UA01INHO0000000001")
                .build());
        var request = get("/api/person/" + person.getUid() + "/accounts");
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(new AccountDTO[]{AccountDTO.builder()
                        .id(account.getUid())
                        .iban(account.getIban())
                        .balance(account.getBalance())
                        .personId(person.getUid())
                        .build()})));
    }

    @Test
    public void shouldUpdateAccount() throws Exception {
        var person = personRepository.save(Person.builder()
                .uid(UUID.randomUUID().toString())
                .name("Test")
                .email("test@gmail.com")
                .build());
        var account = accountRepository.save(Account.builder()
                .uid(UUID.randomUUID().toString())
                .person(person)
                .balance(1000)
                .iban("UA01INHO0000000001")
                .build());
        var request = put("/api/person/" + person.getUid() + "/accounts/" + account.getUid())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsBytes(AccountDTO.builder()
                        .id(account.getUid())
                        .iban(account.getIban())
                        .balance(1005)
                        .personId(person.getUid())
                        .build()));
        mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json(objectMapper.writeValueAsString(AccountDTO.builder()
                        .id(account.getUid())
                        .iban(account.getIban())
                        .balance(1005)
                        .personId(person.getUid())
                        .build())));
    }

    @Test
    public void shouldDeleteAccount() throws Exception {
        var person = personRepository.save(Person.builder()
                .uid(UUID.randomUUID().toString())
                .name("Test")
                .email("test@gmail.com")
                .build());
        var account = accountRepository.save(Account.builder()
                .uid(UUID.randomUUID().toString())
                .person(person)
                .balance(1000)
                .iban("UA01INHO0000000001")
                .build());
        var check = get("/api/person/" + person.getUid() + "/accounts");
        mockMvc.perform(check)
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
        var request = delete("/api/" + account.getUid());
        mockMvc.perform(request)
                .andExpect(status().isOk());

    }
}