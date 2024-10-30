package fr.uge.poo.weatherservice.question1;

/* Assume that this class is not thread-safe */
public class WeatherServiceNTS implements WeatherService {

    private WeatherServiceNTS() {
        System.out.println("Creating a connection to WeatherServiceTS");
    }
    private static final WeatherServiceNTS INSTANCE = new WeatherServiceNTS();
    public static WeatherServiceNTS getInstance() {
        return INSTANCE;
    }

    public int query(String city){
        return city.hashCode()%30;
    }
}
