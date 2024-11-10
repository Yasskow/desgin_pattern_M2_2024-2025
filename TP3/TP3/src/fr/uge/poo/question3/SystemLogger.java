package fr.uge.poo.question3;

public class SystemLogger implements Logger{

    public void log(Logger.Level level, String message) {
        System.err.println(level + " " + message);
    }
}