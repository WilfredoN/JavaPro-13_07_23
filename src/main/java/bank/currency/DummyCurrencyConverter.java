package bank.currency;

import lombok.extern.slf4j.Slf4j;

import java.util.Currency;

@Slf4j
public class DummyCurrencyConverter implements CurrencyConverter {
    @Override
    public double convert(Currency from, Currency to, double amount) {
        return amount;
    }
}
