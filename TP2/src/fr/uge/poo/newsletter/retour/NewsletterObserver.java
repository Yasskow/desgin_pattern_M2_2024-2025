package fr.uge.poo.newsletter.retour;


public interface NewsletterObserver {
    void onSubscribe(Newsletter newsletter);
    void subscribeFail(Newsletter newsletter);

}
