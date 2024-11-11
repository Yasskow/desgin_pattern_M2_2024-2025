package fr.uge.poo.question3;

import java.util.Objects;
import java.util.function.Predicate;

public class SystemLogger implements Logger{
    private Predicate<Level> predicate = t -> true;

    private SystemLogger(){

    }

    private static final SystemLogger INSTANCE = new SystemLogger();

    public static SystemLogger getInstance(){
        return INSTANCE;
    }



    public void log(Logger.Level level, String message) {
        Objects.requireNonNull(message, "Your message cannot be null");
        Objects.requireNonNull(level, "Your level cannot be null");
        if(predicate.test(level)){
            System.err.println(level + " " + message);
        }
    }

    @Override
    public void setLevelFilter(Predicate<Level> predicate) {
        this.predicate = Objects.requireNonNull(predicate, "Your predicate cannot be null");
    }
}