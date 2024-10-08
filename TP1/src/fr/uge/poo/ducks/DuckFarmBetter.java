package fr.uge.poo.ducks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ServiceLoader;

public class DuckFarmBetter {
    public static void main(String[] args) {
        ServiceLoader<DuckFactory> loader = ServiceLoader.load(fr.uge.poo.ducks.DuckFactory.class);
        var list = Arrays.asList("Riri", "Rifi", "Loulou");
        var i = 0;
        for (DuckFactory factory : loader) {
            System.out.println(factory.withName(list.get(i++)).quack());
        }
    }
}