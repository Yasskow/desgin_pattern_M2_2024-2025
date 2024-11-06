package fr.uge.poo.newsletter.question2;

import com.evilcorp.eemailer.EEMailer;

import java.util.List;

public class EEMailerAdapter implements Mailer {
    private final EEMailer mailer = new EEMailer();

    @Override
    public void sendBulk(List<String> emails, MailRec mail) {
        emails.forEach(s -> mailer.send(toMail(mail, s)));
    }

    @Override
    public void send(String email, MailRec mail) {
        mailer.send(toMail(mail, email));
    }

    public static EEMailer.Mail toMail(MailRec mail, String email) {
        return new EEMailer.Mail(email, mail.subject(), mail.content());
    }
}
