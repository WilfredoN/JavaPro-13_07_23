package bank.currency;

import java.util.Currency;

public class DummyCurrencyConverter implements CurrencyConverter {
    @Override
    public double convert(Currency from, Currency to, double amount) {
        return amount;
    }
}
