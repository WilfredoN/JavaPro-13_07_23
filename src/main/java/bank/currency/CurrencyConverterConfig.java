package bank.currency;

import lombok.Data;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class CurrencyConverterConfig {
    @Configuration
    @ConditionalOnProperty(name = "currency-converter.provider", havingValue = "currencyapi")
    public static class ApiCurrencyConverterConfig {
        @Bean
        public CurrencyConverter currencyApiCurrencyConverter(CurrencyConverterProperties config) {
            return new ApiCurrencyConverter(config);
        }
    }

    @Configuration
    @ConditionalOnProperty(name = "currency-converter.provider", havingValue = "dummy")
    public static class DummyCurrencyConverterConfig {
        @Bean
        public CurrencyConverter dummyCurrencyConverter() {
            return new DummyCurrencyConverter();
        }
    }

}
