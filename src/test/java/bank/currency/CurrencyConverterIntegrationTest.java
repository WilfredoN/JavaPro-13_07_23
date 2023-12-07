package bank.currency;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class CurrencyConverterIntegrationTest {
    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;
    @Test
    void shouldConvert() throws Exception {
        var mockResponse = mockMvc.perform(get("/currencies/convert")
                        .param("from", "USD")
                        .param("to", "EUR")
                        .param("amount", "10.0"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        var body = Double.parseDouble(mockResponse);
        assertEquals(10.0, body);
    }
}