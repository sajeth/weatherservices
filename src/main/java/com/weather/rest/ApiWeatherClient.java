package com.weather.rest;

import com.weather.domain.response.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.text.MessageFormat;

@Component
public class ApiWeatherClient {
    @Autowired
    WebClient weatherClient;

    @Value("${weather.forecast}")
    private String url;

    public Flux<Weather> getWeatherForecast(Double lattitude,Double longitude) {
        return weatherClient.get().uri(MessageFormat.format(url,lattitude,longitude))
                .retrieve()
                .bodyToFlux(Weather.class);
                //.bodyToMono(Weather.class);

    }
}
