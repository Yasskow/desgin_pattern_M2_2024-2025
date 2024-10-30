package fr.uge.poo.newsletter.question3;

import com.evilcorp.eemailer.EEMailer;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Newsletter {
    private String name;
    private EEMailer mailer;
    private final Set<User> subscribers = new HashSet<>();
    private final UserRestriction userRestriction;

    public Newsletter(String name, UserRestriction userRestriction){
        this.name =  Objects.requireNonNull(name, "Your name is null");
        this.mailer = new EEMailer();
        this.userRestriction = userRestriction;
    }

    public Newsletter(String name){
        this(name, (nationality, age, email) -> true);
    }

    public record User(String name, String email, int age, Nationality nationality) {
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
        Objects.requireNonNull(user, "User is null");
            if(userRestriction.isValid(user.nationality, user.age, user.email)){
                if(!subscribers.add(user)){
                    throw new IllegalStateException("Subscriber already exists");
                }
            }else{
                throw new IllegalArgumentException("Your age or nationality or email are wrong");
            }
    }

    public void unsubscribe(User user){
        Objects.requireNonNull(user, "User is null");
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

    public static void main(String[] args) {
        var carayol = new User("Arnaud", "arnaud.carayol@gustave.fr", 45, User.Nationality.FRENCH);
        var youssef = new User("Youssef", "Youssef.bergeron@gustave.fr", 25, User.Nationality.SPANISH);
        var christophe = new User("Christophe", "christophe@gustave.fr", 23, User.Nationality.FRENCH);
        var steven = new User("Steven", "steven.ly@univ-eiffel.fr", 26, User.Nationality.BRITISH);
        var yass = new User("Yassine", "Yassine.ben@univ-eiffel.fr", 25, User.Nationality.BRITISH);

        var potter4ever = new Newsletter("Potter4ever", (nationality, age, email) -> nationality == User.Nationality.BRITISH && age > 17);
        var java4ever = new Newsletter("Java4ever", (nationality, age, email) -> (nationality == User.Nationality.BRITISH || nationality == User.Nationality.FRENCH )&& age > 21);
        var whyme = new Newsletter("Why me", (nationality, age, email) -> age%2 ==0 && email.endsWith("@univ-eiffel.fr"));

        //potter4ever.subscribe(carayol);
        potter4ever.subscribe(steven);
        potter4ever.sendMessage("coucou", "Coucou à tous");
        java4ever.subscribe(yass);
        whyme.subscribe(steven);
        //whyme.subscribe(carayol);
    }
}
