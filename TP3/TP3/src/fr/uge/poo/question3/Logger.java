package fr.uge.poo.question3;

import java.util.function.Predicate;

public interface Logger {
    enum Level {
        ERROR, WARNING, INFO
    }

    void log(Level level, String message);
    void setLevelFilter(Predicate<Level> predicate );
}
