package fr.uge.poo.question2;

import java.util.Map;
import java.util.Objects;

public class Main{
    public static void main(String[] args) {
        var map = Map.of("cat","http://www.example.com/cat.png",
                "dog","http://www.example.com/dog.png",
                "mice","http://www.example.com/mice.png");
        var images =map.values().stream().map(ImageGenerator::downloadLazy).toList();
        System.out.println(images.get(0).hue());
    }
}