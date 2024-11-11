package fr.uge.poo.question3;

import java.util.Objects;
import java.util.function.Predicate;

public class UpLogger implements Logger{
    private final Logger logger;
    private final SystemLogger sysLogger;

    public UpLogger(Logger logger) {
        this.logger = Objects.requireNonNull(logger, "Your logger is null");
        this.sysLogger = SystemLogger.getInstance();
    }

    @Override
    public void log(Level level, String message) {
        logger.log(level, message);
        sysLogger.log(level, message);
    }

    @Override
    public void setLevelFilter(Predicate<Level> predicate) {
        logger.setLevelFilter(predicate);
        sysLogger.setLevelFilter(predicate);
    }
}
