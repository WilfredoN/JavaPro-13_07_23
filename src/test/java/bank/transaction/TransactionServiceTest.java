package bank.transaction;

import bank.account.Account;
import bank.account.AccountRepository;
import bank.card.Card;
import bank.card.CardRepository;
import bank.person.Person;
import bank.person.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class TransactionServiceTest {
    @Mock
    CardRepository cardRepository;
    @Mock
    AccountRepository accountRepository;
    @Mock
    PersonRepository personRepository;
    @InjectMocks
    TransactionService transactionService;
    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this).close();
    }
    @Test
    void shouldToTransferMoney() {
        when(cardRepository.save(any(Card.class))).thenAnswer(invocation -> invocation.getArgument(0));
        when(accountRepository.save(any(Account.class))).thenAnswer(invocation -> invocation.getArgument(0));
        when(personRepository.save(any(Person.class))).thenAnswer(invocation -> invocation.getArgument(0));

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

        when(cardRepository.findByUid(cardFrom.getUid())).thenReturn(Optional.of(cardFrom));
        when(cardRepository.findByUid(cardTo.getUid())).thenReturn(Optional.of(cardTo));

        transactionService.transferMoney(cardFrom.getUid(), cardTo.getUid(), 50);
        assertEquals(950, accountFrom.getBalance());
        assertEquals(1050, accountTo.getBalance());
    }

}