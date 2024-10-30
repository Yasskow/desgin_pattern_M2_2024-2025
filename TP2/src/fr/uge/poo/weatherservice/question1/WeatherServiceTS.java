package fr.uge.poo.weatherservice.question1;

/* This class is thread-safe */
public class WeatherServiceTS implements WeatherService {

    private WeatherServiceTS() {
        System.out.println("Creating a connection to WeatherServiceTS");
    }
    private static final WeatherServiceTS  INSTANCE = new WeatherServiceTS();
    public static WeatherServiceTS getInstance() {
        return INSTANCE;
    }

    public int query(String city){
        return city.hashCode()%30;
    }
}
