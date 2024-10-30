package fr.uge.poo.weatherservice.question1;

public class Application {

    public void start() throws InterruptedException {

        System.out.println("Warming  up");
        Thread.sleep(5_000);
        System.out.println("Starting");


        Thread.ofPlatform().start(() -> {
            for(;;){
                WeatherService service = WeatherServiceTS.getInstance();
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    throw new AssertionError();
                }
                System.out.println("Paris : "+service.query("Paris"));
            }
        });

        Thread.ofPlatform().start(() -> {
            for(;;){
                WeatherService service = WeatherServiceTS.getInstance();
                try {
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    throw new AssertionError();
                }
                System.out.println("Madrid : "+service.query("Madrid"));
            }
        });
    }
    public static void main(String[] args) throws InterruptedException {
        var application = new Application();
        application.start();
    }
}