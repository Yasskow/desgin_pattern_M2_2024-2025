package fr.uge.poo.newsletter;

import com.evilcorp.eemailer.EEMailer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Newsletter {
    private String name;
    private EEMailer mailer;
    private final ArrayList<User> subscribes = new ArrayList<>();
    private final Set<User> subscribers = new HashSet<>();

    public  Newsletter(String name){
        this.name =  Objects.requireNonNull(name, "Your name is null");
        this.mailer = new EEMailer();
    }
    public record User(String name, String email, int age, User.Nationality nationality) {
        public enum Nationality {
            FRENCH,BRITISH,SPANISH
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof User user)) return false;
            return Objects.equals(email, user.email);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(email);
        }

        public User {
            Objects.requireNonNull(name);
            Objects.requireNonNull(email);
            if (age<0) {
                throw new IllegalArgumentException("Age must be positive");
            }
            Objects.requireNonNull(nationality);


        }
    }

    public void subscribe(User user){
        if(!subscribers.add(user)){
            throw new IllegalStateException("Subscriber already exists");
        }
    }

    public void unsubscribe(User user){
        if(!subscribers.remove(user)){
            throw new IllegalStateException("Subscriber does not exist");
        }
    }

    public void sendMessage(String title, String content){
        Objects.requireNonNull(title, "Your title is null");
        Objects.requireNonNull(content, "Your content is null");
        subscribers.forEach(user -> {
            var mail = new EEMailer.Mail(user.name, title, content);
            mailer.send(mail);
        });
    }
}
