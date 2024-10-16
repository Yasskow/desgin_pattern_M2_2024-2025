package fr.uge.poo.uberclient.question1;

public record toHtmlWithEmailsAndAverageOverLast5Grades() implements UberClientFormatter {

    @Override
    public String format(UberClient.UberClientInfo uberClientInfo) {
        var averageGrade= uberClientInfo.grades().stream().limit(5).mapToLong(l -> l).average().orElseThrow(() -> new AssertionError("Client are meant to have at least one grade"));
        return String.format("<h2>%s %s (%1.2f*) : %s </h2>",uberClientInfo.firstName(),uberClientInfo.lastName(),averageGrade,uberClientInfo.emails());
    }
}
