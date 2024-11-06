package fr.uge.poo.weatherservice.question1;

import com.evilcorp.weatherservice.WeatherService;
import com.evilcorp.weatherservice.WeatherServiceTS;

public class WeatherServices {

    private WeatherServices(){}

    private final static WeatherService INSTANCE = new WeatherServiceTS();
    public static WeatherService getInstance() {
        return INSTANCE;
    }
}
