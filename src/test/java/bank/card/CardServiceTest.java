package bank.card;

import bank.account.Account;
import bank.person.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

class CardServiceTest {

    @Mock
    CardRepository cardRepository;

    @InjectMocks
    CardService cardService;

    @BeforeEach
    void setUp() throws Exception {
        MockitoAnnotations.openMocks(this).close();
    }

    @Test
    void testGetCards() {
        Person person = new Person("1", "Test Person", "test@test.com");
        Account account = new Account("1", "1", 1000, person);
        Card card = new Card("1", "1234", account, LocalDate.parse("2026-12-12"), "1234", "123", CardStatus.ACTIVE, person);
        Pageable pageable = PageRequest.of(0, 10);
        when(cardRepository.findAll(pageable)).thenReturn(new PageImpl<>(List.of(card)));
        List<CardDTO> result = cardService.getCards(pageable);
        assertNotNull(result);
        assertEquals(1, result.size());
    }
}