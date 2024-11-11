package fr.uge.poo.question3;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Objects;
import java.util.function.Predicate;

public class PathLogger implements Logger, Closeable {
    private boolean close;
    private final BufferedWriter bufferedWriter;
    private Predicate<Level> levelPredicate = t -> true;

    public PathLogger(Path path) throws IOException {
        this.bufferedWriter = Files.newBufferedWriter(path,
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
    }

    @Override
    public void log(Level level, String message) {
        Objects.requireNonNull(level, "Your level is null");
        Objects.requireNonNull(message, "Your message is null");
        if(close){
            return;
        }
        try {
            if(levelPredicate.test(level)){
                bufferedWriter.write(level + " : " + message);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    @Override
    public void setLevelFilter(Predicate<Level> predicate) {
        this.levelPredicate = Objects.requireNonNull(predicate, "Your level predicate is null");
    }

    @Override
    public void close() throws IOException {
        close = true;
        bufferedWriter.close();
    }
}
