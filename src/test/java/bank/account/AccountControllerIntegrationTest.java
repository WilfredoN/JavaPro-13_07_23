package bank.account;

import bank.person.Person;
import bank.person.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class AccountControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private PersonRepository personRepository;

    @Test
    public void shouldCreateAccount() throws Exception {
        String personUid = UUID.randomUUID().toString();
        String accountUid = UUID.randomUUID().toString();
        var person = personRepository.save(Person.builder()
                .uid(personUid)
                .name("Name Test")
                .email("testing@test.com")
                .build());
        var account = accountRepository.save(Account.builder()
                .iban("UA1234567890123456789012")
                .uid(accountUid)
                .balance(512)
                .person(person)
                .build());
        mockMvc.perform(get("/api/person/" + personUid + "/accounts"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }


    @Test
    public void shouldReturnAccounts() throws Exception {
        mockMvc.perform(get("/api/accounts"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
}