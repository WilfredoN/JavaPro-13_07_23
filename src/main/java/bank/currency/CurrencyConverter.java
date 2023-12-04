package bank.currency;

import java.util.Currency;

public interface CurrencyConverter {
    double convert(Currency from, Currency to, double amount);
}
