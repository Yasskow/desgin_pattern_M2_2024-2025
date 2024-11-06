package fr.uge.poo.newsletter.question1;

import com.evilcorp.eemailer.EEMailer;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Newsletter {
    private String name;
    private EEMailer mailer;
    private final Set<User> subscribers = new HashSet<>();
    private final UserRestriction userRestriction;

    private Newsletter(String name, UserRestriction userRestriction){
        this.name =  Objects.requireNonNull(name, "Your name is null");
        this.mailer = new EEMailer();
        this.userRestriction = Objects.requireNonNull(userRestriction, "Restriction is null");
    }

    public static class Builder{
        private String name;
        private UserRestriction userRestriction;

        public static Builder newBuilder(){
            return new Builder();
        }

        public Builder name(String name){
            this.name = Objects.requireNonNull(name);
            return this;
        }

        public Builder userRestriction(UserRestriction userRestriction){
            this.userRestriction = Objects.requireNonNull(userRestriction);
            return this;
        }
        public Newsletter build(){
            if(name == null){
                throw new IllegalStateException("name are null");
            }
            if(userRestriction == null){
                userRestriction = (nationality, age, email) -> true;
            }
            return new Newsletter(name, userRestriction);
        }
    }

    public Newsletter(String name){
        this(name, (nationality, age, email) -> true);
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
            var mail = new EEMailer.Mail(user.email, "[" + name + "]" + title , content);
            mailer.send(mail);
        });
    }

    public static void main(String[] args) {
        var carayol = new User("carayol", "arnaud.carayol@gustave.fr", 45, User.Nationality.FRENCH);
        var youssef = new User("Youssef", "Youssef.bergeron@gustave.fr", 25, User.Nationality.SPANISH);
        var christophe = new User("Christophe", "christophe@gustave.fr", 23, User.Nationality.FRENCH);
        var steven = new User("Steven", "steven.ly@univ-eiffel.fr", 26, User.Nationality.BRITISH);
        var yass = new User("Yassine", "Yassine.ben@univ-eiffel.fr", 25, User.Nationality.BRITISH);

        var potter4ever = Builder.newBuilder().name("potter4ever").userRestriction((nationality, age, _) -> nationality == User.Nationality.BRITISH && age > 17).build();
        potter4ever.subscribe(yass);
        //potter4ever.subscribe(youssef);
        potter4ever.sendMessage("Title", "Coucou twa");

        var java4ever = Builder.newBuilder().name("java4ever").userRestriction((nationality, age, _) -> (nationality == User.Nationality.BRITISH || nationality == User.Nationality.FRENCH )&& age > 21);
        var whyme = Builder.newBuilder().name("whyme").userRestriction((_, age, email) -> age%2 ==0 && email.endsWith("@univ-eiffel.fr"));
    }
}
