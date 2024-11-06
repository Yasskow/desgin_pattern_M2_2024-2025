package fr.uge.poo.weatherservice.question2;


import com.evilcorp.weatherservice.WeatherService;
import com.evilcorp.weatherservice.WeatherServiceNTS;

public class WeatherServices {

    private WeatherServices(){}

    private final static WeatherService INSTANCE = new WeatherService(){
        private final Object lock = new Object();
        private final WeatherServiceNTS weatherServiceNTS = new WeatherServiceNTS();

        @Override
        public int query(String city) {
            synchronized (lock) {
                return weatherServiceNTS.query(city);
            }
        }
    };

    public static WeatherService getInstance() {
        return INSTANCE;
    }
}
