package fr.uge.poo.newsletter.retour;

@FunctionalInterface
public interface UserRestriction {
    boolean isValid(Newsletter.User.Nationality nationality, int age, String email);
}
