package fr.uge.poo.question3;

import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Path;

public class Application {
    public static void main(String[] args) {
        try {
            var test = new PathLogger(Path.of("logs.txt"));
            test.log(Logger.Level.INFO,  "TEST");
            UpLogger logger = new UpLogger(test);
            logger.log(Logger.Level.INFO,"HELLO WORLD");
            logger.log(Logger.Level.WARNING,"In class "+ Application.class.getName()+" logger");
            logger.log(Logger.Level.ERROR,"PROBLEM ENCOUNTERED HERE "+ Application.class.getName());
            logger.setLevelFilter(t-> t.ordinal()>= Logger.Level.WARNING.ordinal());
            logger.log(Logger.Level.INFO,"HELLO FROM WARNING+");
            logger.log(Logger.Level.WARNING,"In class "+ Application.class.getName()+" logger WARNING +");
            logger.log(Logger.Level.ERROR,"PROBLEM ENCOUNTERED HERE AFTER WARNING+ "+ Application.class.getName());

            test.close();
        } catch (UncheckedIOException | IOException e) {
            System.out.println("HELLLOO");
            e.getCause();
        }
    }
}
