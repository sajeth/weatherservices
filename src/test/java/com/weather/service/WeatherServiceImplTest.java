package com.weather.service;

import com.weather.domain.response.Geometry;
import com.weather.domain.response.Props;
import com.weather.domain.response.Weather;
import com.weather.domain.RestResponse;
import com.weather.rest.ApiWeatherClient;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyDouble;
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
        final Flux<Weather> weatherMono = Flux.just(weather);
        when(mockApiWeatherClient.getWeatherForecast(anyDouble(),anyDouble())).thenReturn(weatherMono);

        // Run the test
        final RestResponse<Object> result = weatherServiceImplUnderTest.getWeatherForecast(33d,70d);

        // Verify the results
    }

    @Test
    void testGetWeatherForecast_ApiWeatherClientReturnsNoItem() {
        // Setup
        when(mockApiWeatherClient.getWeatherForecast(anyDouble(),anyDouble())).thenReturn(Flux.empty());

        // Run the test
        final RestResponse<Object> result = weatherServiceImplUnderTest.getWeatherForecast(33d,70d);

        // Verify the results
    }

    @Test
    void testGetWeatherForecast_ApiWeatherClientReturnsError() {
        // Setup
        // Configure ApiWeatherClient.getWeatherForecast(...).
        final Flux<Weather> weatherMono = Flux.error(new Exception("message"));
        when(mockApiWeatherClient.getWeatherForecast(anyDouble(),anyDouble())).thenReturn(weatherMono);

        // Run the test
        assertThrows(Exception.class,()->weatherServiceImplUnderTest.getWeatherForecast(33d,70d));

        // Verify the results
    }
}
