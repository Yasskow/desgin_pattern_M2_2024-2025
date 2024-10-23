package fr.uge.poo.newsletter.question1;

@FunctionalInterface
public interface UserRestriction {
    boolean isValid(Newsletter.User.Nationality nationality, int age, String email);
}
