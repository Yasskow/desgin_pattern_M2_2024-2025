package fr.uge.poo.uberclient.question1;

import java.util.List;

@FunctionalInterface
public interface UberClientFormatter {
    String format(UberClient.UberClientInfo uberClientInfo);

    private String printEmails(String emails) {
        var devideEmail = emails.split("@");
        var firstPart = devideEmail[0];
        var  secondPart = devideEmail[1].split("\\.");
        var maskedFirstPart = firstPart.charAt(0) + "*";
        var maskedSecondPart = secondPart[0].charAt(0) + "*";
        return maskedFirstPart +  "@" + maskedSecondPart;
    }
    default List<String> printEmails(List<String>  emails){
        return emails.stream().map(s -> s = printEmails(s)).toList();
    }
}

