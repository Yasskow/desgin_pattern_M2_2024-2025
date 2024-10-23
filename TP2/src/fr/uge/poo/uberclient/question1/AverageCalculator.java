package fr.uge.poo.uberclient.question1;

import java.util.List;
import java.util.OptionalDouble;

@FunctionalInterface
public interface AverageCalculator {
    AverageCalculator STANDARD = s -> s.stream().mapToLong(l -> l).average();

    OptionalDouble averageCalculator(List<Integer> list);
}
