package fr.uge.poo.newsletter.retour;


public class SubscribeObserver implements NewsletterObserver{

    @Override
    public void onSubscribe(Newsletter newsletter) {
        newsletter.sendMessage("Welcome", "Welcome to the Newsletter");
    }

    @Override
    public void subscribeFail(Newsletter newsletter) {

    }
}
