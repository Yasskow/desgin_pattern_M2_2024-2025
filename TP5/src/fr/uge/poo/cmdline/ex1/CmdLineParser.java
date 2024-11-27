package fr.uge.poo.cmdline.ex1;


import java.util.*;

public class CmdLineParser {

    private final HashMap<String, Runnable> registeredOptions = new HashMap<>();

    public void addFlags(String option, Runnable runnable){
        Objects.requireNonNull(option);
        Objects.requireNonNull(runnable);

        registeredOptions.put(option, runnable);
    }

    public List<String> process(String[] arguments) {
        ArrayList<String> files = new ArrayList<>();
        for (String argument : arguments) {
            if (registeredOptions.containsKey(argument)) {
                registeredOptions.get(argument).run();
            } else {
                files.add(argument);
            }
        }
        return files;
    }
}
