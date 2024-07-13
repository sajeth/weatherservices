package com.weather.service;

import com.weather.pojo.Geometry;
import com.weather.pojo.Props;
import com.weather.pojo.Weather;
import com.weather.pojo.response.RestResponse;
import com.weather.rest.ApiWeatherClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class WeatherServiceImplTest {

    @Mock
    private ApiWeatherClient mockApiWeatherClient;

    private WeatherServiceImpl weatherServiceImplUnderTest;

    @BeforeEach
    void setUp() {
        weatherServiceImplUnderTest = new WeatherServiceImpl();
        weatherServiceImplUnderTest.apiWeatherClient = mockApiWeatherClient;
    }

    @Test
    void testGetWeatherForecast() {
        // Setup
        // Configure ApiWeatherClient.getWeatherForecast(...).
        final Weather weather = new Weather();
        weather.setType("type");
        final Geometry geometry = new Geometry();
        geometry.setType("type");
        geometry.setCoordinates(new ArrayList<>(List.of(new ArrayList<>(List.of(new ArrayList<>(List.of(0.0)))))));
        weather.setGeometry(geometry);
        final Props properties = new Props();
        weather.setProperties(properties);
        final Mono<Weather> weatherMono = Mono.just(weather);
        when(mockApiWeatherClient.getWeatherForecast()).thenReturn(weatherMono);

        // Run the test
        final RestResponse<Object> result = weatherServiceImplUnderTest.getWeatherForecast();

        // Verify the results
    }

    @Test
    void testGetWeatherForecast_ApiWeatherClientReturnsNoItem() {
        // Setup
        when(mockApiWeatherClient.getWeatherForecast()).thenReturn(Mono.empty());

        // Run the test
        final RestResponse<Object> result = weatherServiceImplUnderTest.getWeatherForecast();

        // Verify the results
    }

    @Test
    void testGetWeatherForecast_ApiWeatherClientReturnsError() {
        // Setup
        // Configure ApiWeatherClient.getWeatherForecast(...).
        final Mono<Weather> weatherMono = Mono.error(new Exception("message"));
        when(mockApiWeatherClient.getWeatherForecast()).thenReturn(weatherMono);

        // Run the test
        assertThrows(Exception.class,()->weatherServiceImplUnderTest.getWeatherForecast());

        // Verify the results
    }
}
