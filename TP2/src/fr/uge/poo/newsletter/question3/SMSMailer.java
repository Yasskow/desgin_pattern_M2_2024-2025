package fr.uge.poo.newsletter.question3;

public interface SMSMailer {
    public void sendMail(String to, String subject, String body);
}
