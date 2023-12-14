package com.example.weatherApp.Services;


import com.example.weatherApp.Models.WeatherInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private final RestTemplate restTemplate;

    @Value(value = "${weather.api.key}")
    private String apiKey;

    @Autowired
    public WeatherService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public WeatherInput getWeatherForCity(String city) {
        final String url = "https://api.openweathermap.org/data/2.5/weather?q=" + city + "&units=metric&appid=" + apiKey;
        WeatherInput weatherInputFromWeatherApi = this.restTemplate.getForObject(url, WeatherInput.class);
        return weatherInputFromWeatherApi;
    }
}