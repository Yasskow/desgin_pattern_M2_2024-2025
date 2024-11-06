package fr.uge.poo.weatherservice.question3;
import com.evilcorp.weatherservice.WeatherService;

import java.util.Optional;

public class Application {

    public void start() throws InterruptedException {

        System.out.println("Warming  up");
        Thread.sleep(5_000);
        System.out.println("Starting");


        Thread.ofPlatform().start(() -> {
            for(;;){
                Optional<WeatherService> service = WeatherServices.getInstance();
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    throw new AssertionError();
                }
                if(service.isPresent()){
                    System.out.println("Madrid : "+service.get().query("Madrid"));
                }
            }
        });

        Thread.ofPlatform().start(() -> {
            for(;;){
                Optional<WeatherService> service = WeatherServices.getInstance();
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    throw new AssertionError();
                }
                if(service.isPresent()){
                    System.out.println("Madrid : "+service.get().query("Madrid"));
                }
            }
        });
    }
    public static void main(String[] args) throws InterruptedException {
        var application = new Application();
        application.start();
    }
}
