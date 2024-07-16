package com.weather.rest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.web.reactive.function.client.WebClient;

@ExtendWith(MockitoExtension.class)
class ApiWeatherClientTest {

    @Mock
    private WebClient mockWeatherClient;

    @BeforeEach
    void setUp() {
        ApiWeatherClient apiWeatherClientUnderTest = new ApiWeatherClient();
        ReflectionTestUtils.setField(apiWeatherClientUnderTest, "url", "url");
        apiWeatherClientUnderTest.weatherClient = mockWeatherClient;
    }

    @Test
    void testGetWeatherForecast() {
//        Weather weather = new Weather();
//        weather.setType("TYPE");
//        // Configure WebClient.get(...).
//        final WebClient.RequestHeadersUriSpec<?> mockRequestHeadersUriSpec = mock(
//                WebClient.RequestHeadersUriSpec.class);
//
//        WebClient.UriSpec<?> uriSpec = mock(
//                WebClient.UriSpec.class);
//     //   WebClient.ResponseSpec responseSpec = new WebClient.ResponseSpec().bodyToMono(weather);
//        doReturn(mockRequestHeadersUriSpec).when(mockWeatherClient.get());
//      //  doReturn(uriSpec).when(mockRequestHeadersUriSpec.uri(anyString()));
//        when(mockRequestHeadersUriSpec.uri(anyString()).retrieve().bodyToMono(Weather.class).thenReturn(Mono.just(weather)));
//
//        // Run the test
//        final Mono<Weather> result = apiWeatherClientUnderTest.getWeatherForecast();
//        Assertions.assertNotNull(result);
        // Verify the results
    }
}
