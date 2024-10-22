package fr.uge.poo.newsletter.question1;

@FunctionalInterface
public interface NationalityRestriction {
    boolean isValid(Newsletter.User.Nationality nationality);
}
