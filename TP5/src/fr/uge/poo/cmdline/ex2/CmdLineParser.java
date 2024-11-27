package fr.uge.poo.cmdline.ex2;


import java.util.*;
import java.util.function.Consumer;

public class CmdLineParser {

    private final HashMap<String, Consumer<Iterator<String>>> options = new HashMap<>();

    public void addFlags(String option, Runnable runnable){
        Objects.requireNonNull(option);
        Objects.requireNonNull(runnable);

        options.put(option, iterator -> runnable.run());
    }

    public void addOptionWithOneParameter(String option, Consumer<String> consumer){
        Objects.requireNonNull(option);
        Objects.requireNonNull(consumer);
        if(options.containsKey(option)){
            throw new IllegalStateException("The options " + option + "is already defined");
        }

        options.put(option, it -> {
           if(!it.hasNext()) {
               throw new NoSuchElementException();
           }
           consumer.accept(it.next());
        });
    }

    public List<String> process(String[] arguments) {
        ArrayList<String> files = new ArrayList<>();
        var it = Arrays.stream(arguments).iterator();
        while(it.hasNext()){
            var arg = it.next();
            if(options.containsKey(arg)){
                var action = options.get(arg);
                action.accept(it);
            }else{
                files.add(arg);
            }
        }
        return files;
    }
}
