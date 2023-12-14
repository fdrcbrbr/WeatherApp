package com.example.weatherApp.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class WeatherInput {

    @JsonProperty("main")
    public WeatherData main;
}
