package fr.uge.poo.weatherservice.question3;

import com.evilcorp.weatherservice.WeatherService;
import com.evilcorp.weatherservice.WeatherServiceTSFail;

import java.util.Optional;

public class WeatherServices {

    private static WeatherService INSTANCE;

    public static Optional<WeatherService> getInstance(){
        if(INSTANCE != null) {
            return Optional.of(INSTANCE);
        }
        try {
            INSTANCE = new WeatherServiceTSFail();
        } catch(IllegalStateException e) {
            System.out.println(e.getMessage());
        }
        return Optional.ofNullable(INSTANCE);
    }
}
