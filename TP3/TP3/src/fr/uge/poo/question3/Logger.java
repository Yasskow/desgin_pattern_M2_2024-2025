package fr.uge.poo.question3;

public interface Logger {
    enum Level {
        ERROR, WARNING, INFO
    }

    void log(Level level, String message);
}
