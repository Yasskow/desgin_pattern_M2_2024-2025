package fr.uge.poo.uberclient.question1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.ThreadLocalRandom;

public class UberClient {
    private String firstName;
    private String lastName;
    private long uid;
    private final List<Integer> grades;
    private final List<String> emails;
    private final List<String> phoneNumbers;

//    public static class Builder{
//        private String firstName;
//        private String lastName;
//        private long uid;
//        private final List<Integer> grades = new ArrayList<>();
//        private final List<String> emails = new ArrayList<>();
//        private final List<String> phoneNumbers = new ArrayList<>();
//
//        public Builder firstName(String firstName){
//            this.firstName = Objects.requireNonNull(firstName);
//            return this;
//        }
//
//        public Builder lastName(String lastName){
//            this.lastName = Objects.requireNonNull(lastName);
//            return this;
//        }
//
//        public Builder uid(long uid){
//            this.uid = Objects.requireNonNull(uid);
//            if(uid < 0){
//                throw new IllegalArgumentException("UID must be positive");
//            }
//            return this;
//        }
//
//        public Builder grades(int grade){
//            grades.add(Objects.requireNonNull(grade));
//            if (grade < 1 ||grade > 5) {
//                throw new IllegalArgumentException("All grades must be between 1 and 5");
//            }
//            return this;
//        }
//
//        public Builder emails(String email){
//            emails.add(Objects.requireNonNull(email));
//            return this;
//        }
//
//        public Builder phoneNumbers(String phoneNumber){
//            phoneNumbers.add(Objects.requireNonNull(phoneNumber));
//            return this;
//        }
//
//        public UberClient(String firstName, String lastName, long uid, List<Integer> grades, List<String> emails, List<String> phoneNumbers) {
//            this.firstName = Objects.requireNonNull(firstName);
//            this.lastName = Objects.requireNonNull(lastName);
//            if (uid<0) {
//                throw new IllegalArgumentException("UID must be positive");
//            }
//            this.uid = uid;
//            this.grades = List.copyOf(grades);
//            for(var grade : grades){
//                if (grade < 1 ||grade > 5) {
//                    throw new IllegalArgumentException("All grades must be between 1 and 5");
//                }
//            }
//            this.emails = List.copyOf(emails);
//            this.phoneNumbers = List.copyOf(phoneNumbers);
//            if (grades.size()==0){
//                throw new IllegalArgumentException("A client must have at least one grade");
//            }
//            if (emails.size()==0 && phoneNumbers.size()==0) {
//                throw new IllegalArgumentException("A client must have at least an email or a phoneNumber");
//            }
//        }
//        public UberClient build(){
//            if(firstName == null || lastName == null ){
//                throw new IllegalStateException("firstName or/and lastName are null");
//            }
//            if(grades.size() == 0 || emails.size() == 0 || phoneNumbers.size() == 0){
//                throw new IllegalArgumentException("A cleint must have at least one grade or ane email or phoneNumber");
//            }
//            return new UberClient(firstName, lastName, uid, grades, emails, phoneNumbers);
//        }
//    }
public static class Builder {
    private String firstName;
    private String lastName;
    private long uid;
    private final List<Integer> grades = new ArrayList<>();
    private final List<String> emails = new ArrayList<>();
    private final List<String> phoneNumbers = new ArrayList<>();

    // Step 1: Forcing firstName to be called first
    public static FirstNameStep newBuilder() {
        return new BuilderSteps();
    }

    // Interfaces for each step in the building process
    public interface FirstNameStep {
        LastNameStep firstName(String firstName);
    }

    public interface LastNameStep {
        UidStep lastName(String lastName);
    }

    public interface UidStep {
        GradesStep uid(long uid);
    }

    public interface GradesStep {
        EmailStep grades(int grade);
    }
    public interface EmailStep {
        PhoneNumberStep emails(String email);
    }
    public interface PhoneNumberStep {
        Build phoneNumbers(String phoneNumber);
    }

    public interface Build{
        UberClient build();
    }


    // Private static class that implements all the steps
    private static class BuilderSteps implements FirstNameStep, LastNameStep, UidStep, GradesStep, EmailStep, PhoneNumberStep, Build {
        private String firstName;
        private String lastName;
        private long uid;
        private final List<Integer> grades = new ArrayList<>();
        private final List<String> emails = new ArrayList<>();
        private final List<String> phoneNumbers = new ArrayList<>();

        @Override
        public LastNameStep firstName(String firstName) {
            this.firstName = Objects.requireNonNull(firstName);
            return this;
        }

        @Override
        public UidStep lastName(String lastName) {
            this.lastName = Objects.requireNonNull(lastName);
            return this;
        }

        @Override
        public GradesStep uid(long uid) {
            this.uid = Objects.requireNonNull(uid);
            if (uid < 0) {
                throw new IllegalArgumentException("UID must be positive");
            }
            return this;
        }

        @Override
        public EmailStep grades(int grade) {
            grades.add(Objects.requireNonNull(grade));
            if (grade < 1 || grade > 5) {
                throw new IllegalArgumentException("All grades must be between 1 and 5");
            }
            return this;
        }

        @Override
        public PhoneNumberStep emails(String email) {
            emails.add(Objects.requireNonNull(email));
            return this;
        }

        @Override
        public Build phoneNumbers(String phoneNumber) {
            phoneNumbers.add(Objects.requireNonNull(phoneNumber));
            return this;
        }

        @Override
        public UberClient build() {
            if (firstName == null || lastName == null) {
                throw new IllegalStateException("firstName or/and lastName are null");
            }
            if (grades.isEmpty() || emails.isEmpty() || phoneNumbers.isEmpty()) {
                throw new IllegalArgumentException("A client must have at least one grade, one email, or one phone number");
            }
            return new UberClient(firstName, lastName, uid, grades, emails, phoneNumbers);
        }
    }
}

    private UberClient(String firstName, String lastName, long uid, List<Integer> grades, List<String> emails, List<String> phoneNumbers){
        this.firstName = firstName;
        this.lastName = lastName;
        this.uid = uid;
        this.grades = grades;
        this.emails = emails;
        this.phoneNumbers = phoneNumbers;
    }

    public static void main(String[] args) {
        //var arnaud = new UberClient("Arnaud","Carayol",1,List.of(1,2,5,2,5,1,1,1),List.of("arnaud.carayol@univ-eiffel.fr","arnaud.carayol@u-pem.fr"),List.of("07070707070707"));
        //var youssef = new UberClient("Youssef", "Bergeron", List.of(5), List.of("youssefbergeron@outlook.fr"),List.of());
        //var yass = new Builder().firstName("Yass").lastName("Benmechich").uid(4).emails("a@t.fr").grades(5).phoneNumbers("050402").build();
        var yass = Builder.newBuilder().firstName("Yass").lastName("Benmechich").uid(4).grades(4).emails("a@y.fr").phoneNumbers("02020").build();
    }
}
