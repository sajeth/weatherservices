package com.weather.rest;

import com.weather.pojo.Weather;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class ApiWeatherClient {
    @Autowired
    WebClient weatherClient;

    @Value("${weather.forecast}")
    private String url;

    public Mono<Weather> getWeatherForecast() {
        return weatherClient.get().uri(url)
                .retrieve()
                .bodyToMono(Weather.class);

    }
}
