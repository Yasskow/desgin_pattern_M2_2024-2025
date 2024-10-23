package fr.uge.poo.newsletter.question2;

@FunctionalInterface
public interface UserRestriction {
    boolean isValid(Newsletter.User.Nationality nationality, int age, String email);
}
