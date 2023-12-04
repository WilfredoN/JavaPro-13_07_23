package bank.currency;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Currency;

@RestController
@RequestMapping("/currencies")
@RequiredArgsConstructor
public class CurrencyController {

    private final CurrencyConverter converter;

    @GetMapping("/convert")
    public double getCurrencyConverter(
            @RequestParam("from") Currency fromCurrency,
            @RequestParam("to") Currency toCurrency,
            @RequestParam("amount") double amount) {
        return converter.convert(fromCurrency, toCurrency, amount);
    }
}
