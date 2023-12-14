package bank.card;

import bank.account.Account;
import bank.account.AccountRepository;
import bank.person.Person;
import bank.person.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.time.LocalDate;
import java.util.UUID;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class CardControllerIntegrationTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private PersonRepository personRepository;

    @Test
    void openCard() throws Exception {
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
        var response = cardRepository.save(Card.builder()
                .uid("1")
                .account(account)
                .cvv("123")
                .expirationDate(LocalDate.parse("2025-12-12"))
                .pan("1234567890")
                .pin("1234")
                .person(person)
                .build());

        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/cards")
                        .param("accountId", account.getUid())
        ).andExpect(status().isOk());
    }

    @Test
    void openCardWithPathVariable() throws Exception {
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

        mockMvc.perform(
                MockMvcRequestBuilders.post("/api/persons/" + person.getUid() + "/accounts/" + account.getUid() + "/cards")
        ).andExpect(status().isOk());
    }
}