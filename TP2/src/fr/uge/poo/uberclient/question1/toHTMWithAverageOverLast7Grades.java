package fr.uge.poo.uberclient.question1;

public class toHTMWithAverageOverLast7Grades implements UberClientFormatter {
    private AverageCalculator average = s -> s.stream().mapToLong(l -> l).average().orElseThrow(() -> new AssertionError("Client are meant to have at least one grade"));

    @Override
    public String format(UberClient.UberClientInfo uberClientInfo) {
        var averageGrade= uberClientInfo.grades().stream().limit(7).mapToLong(l -> l).average().orElseThrow(() -> new AssertionError("Client are meant to have at least one grade"));
        return String.format("<h2>%s %s  (%1.2f*)</h2>",uberClientInfo.firstName(),uberClientInfo.lastName(),averageGrade);
    }
}
