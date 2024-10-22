package fr.uge.poo.newsletter.question1;

@FunctionalInterface
public interface AgeRestriction {
    boolean isValid(int age);
}
