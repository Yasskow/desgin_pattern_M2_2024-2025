package fr.uge.poo.uberclient.question1;

import java.util.Objects;

public class toHTMWithAverageOverLast7Grades implements UberClientFormatter {
    private AverageCalculator average = s -> s.stream().mapToLong(l -> l).average().orElseThrow(() -> new AssertionError("Client are meant to have at least one grade"));

    public void setAverage(AverageCalculator averageCalculator){
        this.average = Objects.requireNonNull(averageCalculator);
    }
    @Override
    public String format(UberClient.UberClientInfo uberClientInfo) {
        return String.format("<h2>%s %s  (%1.2f*)</h2>",uberClientInfo.firstName(),uberClientInfo.lastName(),average.averageCalculator(uberClientInfo.grades()));
    }
}
