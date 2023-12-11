package bank.person;

import bank.currency.CurrencyConverter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Currency;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
class PersonOperationsServiceTest {
    @Test
    void shouldConvert() {
        var mockConvertor = Mockito.mock(CurrencyConverter.class);
        Mockito.when(mockConvertor.convert(Currency.getInstance("EUR"), Currency.getInstance("USD"),
                15)).thenReturn(15.0);
        PersonOperationsService person = new PersonOperationsService(mockConvertor);
        CompletableFuture<Double> result = person.convert(Currency.getInstance("EUR"),
                Currency.getInstance("USD"), 15);
        result.thenAccept((amount) -> log.info("Converted amount: {}", amount));
        assertEquals(15.0, result.join());
    }
}