package bank.person;

import bank.currency.CurrencyConverter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Currency;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonOperationsService {
    private final CurrencyConverter currencyConverter;
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);

    public CompletableFuture<Double> convert(Currency from, Currency to, double amount) {
        return CompletableFuture.supplyAsync(() -> {
            log.info("Converting {} {} to {}", amount, from, to);
            currencyConverter.convert(from, to, amount);
            log.info("Converted {} {} to {}", amount, from, to);
            return amount;
        }, executorService);
    }
}