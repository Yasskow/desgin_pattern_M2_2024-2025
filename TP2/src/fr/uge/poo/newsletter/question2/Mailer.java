package fr.uge.poo.newsletter.question2;

import java.util.List;

public interface Mailer {
    record MailRec(String subject, String content){}
    void sendBulk(List<String> emails, MailRec mail);
    void send(String email, MailRec mail);
}
