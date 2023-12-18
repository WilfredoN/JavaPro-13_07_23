package bank.transaction;

import bank.account.Account;
import bank.account.AccountRepository;
import bank.card.Card;
import bank.card.CardRepository;
import bank.currency.WireMockConfig;
import bank.person.Person;
import bank.person.PersonRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class TransactionServiceIntegrationTest {
    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    protected WireMockServer wireMockServer;
    @Autowired
    private CardRepository cardRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private PersonRepository personRepository;

    @DynamicPropertySource
    public static void registerWiremockBaseUrl(DynamicPropertyRegistry registry) {

        registry.add("wiremock.baseurl", WireMockConfig.wireMockServer::baseUrl);
    }

    @Test
    void shouldTransferMoney() throws Exception {
        var personFrom = personRepository.save(Person.builder()
                .uid(UUID.randomUUID().toString())
                .name("Test")
                .email("test@gmail.com")
                .build());
        var accountFrom = accountRepository.save(Account.builder()
                .uid(UUID.randomUUID().toString())
                .person(personFrom)
                .balance(1000)
                .iban("UA01INHO0000000001")
                .build());
        var personTo = personRepository.save(Person.builder()
                .uid(UUID.randomUUID().toString())
                .name("Test1")
                .email("test1@gmail.com").build());
        var accountTo = accountRepository.save(Account.builder()
                .uid(UUID.randomUUID().toString())
                .person(personTo)
                .balance(1000)
                .iban("UA01INHO0000000002")
                .build());
        var cardFrom = cardRepository.save(Card.builder()
                .uid(UUID.randomUUID().toString())
                .account(accountFrom)
                .person(personFrom)
                .pin("1234")
                .build());
        var cardTo = cardRepository.save(Card.builder()
                .uid(UUID.randomUUID().toString())
                .account(accountTo)
                .person(personTo)
                .pin("1234")
                .build());
        mockMvc.perform(MockMvcRequestBuilders.post("/api/transactions")
                        .param("from", cardFrom.getUid())
                        .param("to", cardTo.getUid())
                        .param("amount", "100"))
                .andExpect(status().isOk())
                .andExpect(result -> {
                    var from = cardRepository.findByUid(cardFrom.getUid()).orElse(new Card());
                    var to = cardRepository.findByUid(cardTo.getUid()).orElse(new Card());
                    assertEquals(900, from.getAccount().getBalance());
                    assertEquals(1100, to.getAccount().getBalance());
                });
    }
}