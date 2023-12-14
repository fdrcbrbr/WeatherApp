package com.example.weatherApp.Controllers;


import com.example.weatherApp.Models.WeatherInput;
import com.example.weatherApp.Models.WeatherOutputModel;
import com.example.weatherApp.Services.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/current")
    public WeatherOutputModel currentWeather(@RequestParam("city") String city) {
        WeatherInput weatherInput = weatherService.getWeatherForCity(city);
        WeatherOutputModel weatherOutputModel = new WeatherOutputModel(city, weatherInput.getMain().getTemp(), weatherInput.getMain().getFeelsLike());
        return weatherOutputModel;
    }
}