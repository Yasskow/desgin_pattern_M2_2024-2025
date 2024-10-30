package fr.uge.poo.question1;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggedDuck implements Duck{
    private final static Logger LOGGER = Logger.getLogger(LoggedDuck.class.getClass().getName());
    private final Duck duck;

    public LoggedDuck(Duck duck){
        this.duck = Objects.requireNonNull(duck);
    }
    @Override
    public void quack() {
        LOGGER.log(Level.INFO, "Call quack !");
        duck.quack();
    }

//    @Override
//    public void quackManyTimes(int n) {
//        duck.quackManyTimes(n);
//    }

    public static void main(String[] args) {
//        Duck duck1 = new RegularDuck();
//        duck1.quack();
//        Duck duck2 = new LoggedDuck(new RegularDuck());
//        duck2.quack();
//        duck1.quack();
//        duck2.quack();
        Duck duck = new LoggedDuck(new RegularDuck());
        duck.quackManyTimes(2);
    }
}
