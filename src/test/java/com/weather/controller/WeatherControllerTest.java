package com.weather.controller;

import com.weather.domain.response.Weather;
import com.weather.domain.RestResponse;
import com.weather.service.IWeather;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(WeatherController.class)
class WeatherControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IWeather mockIWeather;

    @Test
    void testGetWeather() throws Exception {
        Weather weather=new Weather();
        weather.setType("Type");
        // Setup
        when(mockIWeather.getWeatherForecast(anyDouble(),anyDouble())).thenReturn(RestResponse.builder()
                        .status("SUCCESS")
                        .response(weather)
                .code(200).build());

        // Run the test and verify the results
        mockMvc.perform(get("/weather/latest")
                        .param("lattitude", String.valueOf(33d))
                        .param("longitude",String.valueOf(70d))
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
           //     .andExpect(jsonPath("$.*", hasSize(1))).
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(MockMvcResultMatchers.jsonPath("$.code", CoreMatchers.is(200)))
        ;
    }
}
