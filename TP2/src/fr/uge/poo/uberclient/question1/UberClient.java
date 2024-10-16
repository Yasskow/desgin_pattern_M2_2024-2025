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

    public record UberClientInfo(String firstName, String lastName, List<Integer> grades, List<String> emails) {

    }
    public static class Builder {

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
                if (grades.isEmpty() || emails.isEmpty() || phoneNumbers.isEmpty()) {
                    throw new IllegalArgumentException("A client must have at least one grade, one email, or one phone number");
                }
                return new UberClient(firstName, lastName, uid, grades, emails, phoneNumbers);
            }
        }
    }

    private UberClientInfo infos(){
        return new UberClientInfo(firstName, lastName, grades, emails);
    }

    public String toExport(UberClientFormatter formatter){
        return formatter.format(infos());
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
        var arnaud = Builder.newBuilder().firstName("Arnaud").lastName("Carayol").uid(4).grades(5).emails("a@t.fr").phoneNumbers("050402").build();
        System.out.println(arnaud.toExport(new ToHTML()));
        System.out.println(arnaud.toExport(new toHTMLSimple()));
        System.out.println(arnaud.toExport(new toHtmlWithEmails()));
        System.out.println(arnaud.toExport(new toHtmlWithEmailsAndAverageOverLast5Grades()));
        System.out.println(arnaud.toExport(new toHTMWithAverageOverLast7Grades()));
    }
}

/* Il y a trop d'interface. Il ne respecte pas le interface segragation principle
 * */

/* Il ne respecte plus le single-responsability principle
 * */