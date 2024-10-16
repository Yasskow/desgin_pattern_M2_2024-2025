package fr.uge.poo.uberclient.question1;

public record toHTMLSimple() implements UberClientFormatter {

    @Override
    public String format(UberClient.UberClientInfo uberClientInfo) {
        return String.format("<h2>%s %s </h2>",uberClientInfo.firstName(),uberClientInfo.lastName());
    }
}
