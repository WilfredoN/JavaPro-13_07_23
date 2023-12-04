package bank.currency;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Map;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("testing")
class CurrencyConverterIntegrationTest {
    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    protected WireMockServer wireMockServer;

    @DynamicPropertySource
    public static void registerWiremockBaseUrl(DynamicPropertyRegistry registry) {

        registry.add("wiremock.baseurl", WireMockConfig.wireMockServer::baseUrl);
    }

    @Test
    void shouldConvert() throws Exception {
        /*var bodyUSD = CurrencyApiData.builder()
                .code("USD")
                .value(2.0)
                .build();
        var bodyEUR = CurrencyApiData.builder()
                .code("EUR")
                .value(1.0)
                .build();
        Map<String, CurrencyApiData> dataMap = new HashMap<>();
        dataMap.put("USD", bodyUSD);
        dataMap.put("EUR", bodyEUR);*/

        var response = CurrencyApiResponse.builder()
                .data(Map.of("EUR", CurrencyApiData.builder()
                        .code("EUR")
                        .value(0.25)
                        .build()))
                .build();
        wireMockServer.stubFor(WireMock.get(WireMock.urlPathEqualTo("/currencyAPI"))
                .withQueryParam("apikey", WireMock.equalTo("123"))
                .withQueryParam("base_currency", WireMock.equalTo("USD"))
                .withQueryParam("currencies", WireMock.equalTo("EUR"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withHeader("Content-Type", "application/json")
                        .withBody(objectMapper.writeValueAsString(response))));
        var mockResponse = mockMvc.perform(get("/currencies/convert")
                        .param("from", "USD")
                        .param("to", "EUR")
                        .param("amount", "10.0"))
                .andExpect(status().isOk())
                .andReturn().getResponse().getContentAsString();
        var body = Double.parseDouble(mockResponse);
        assertEquals(2.5, body);
    }
}