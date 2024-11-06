package fr.uge.poo.newsletter.question2;

import com.goodcorp.gmailer.GMailer;

import java.util.List;

public class GMailerAdapter implements Mailer {
    private final GMailer mailer = new GMailer();

    @Override
    public void sendBulk(List<String> emails, MailRec mail) {
        mailer.sendBulk(emails, toMail(mail));
    }

    @Override
    public void send(String email, MailRec mail) {
        mailer.send(email, toMail(mail));
    }

    private GMailer.Mail toMail(MailRec mail) {
        return new GMailer.Mail(mail.subject(), mail.content());
    }
}
