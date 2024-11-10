package fr.uge.poo.question3;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Objects;

public class PathLogger implements Logger, Closeable {
    private final Path path;
    private boolean close;
    private BufferedWriter bufferedWriter;

    public PathLogger(Path path) throws IOException {
        this.path = Objects.requireNonNull(path, "Your path is null");
        this.bufferedWriter = Files.newBufferedWriter(path,
                StandardCharsets.UTF_8,
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND);
    }

    @Override
    public void log(Level level, String message) {
        Objects.requireNonNull(level, "Your level is null");
        Objects.requireNonNull(message, "Your message is null");
        bufferedWriter.write();
    }

    @Override
    public void close() throws IOException {
        close = true;
        bufferedWriter.close();
    }
}
