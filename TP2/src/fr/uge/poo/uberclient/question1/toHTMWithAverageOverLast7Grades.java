package fr.uge.poo.uberclient.question1;

import java.util.Objects;

public class toHTMWithAverageOverLast7Grades implements UberClientFormatter {
    @Override
    public String format(UberClient.UberClientInfo uberClientInfo) {
        return String.format("<h2>%s %s  (%1.2f*)</h2>",uberClientInfo.firstName(),uberClientInfo.lastName(),uberClientInfo.average().orElseThrow());
    }
}
