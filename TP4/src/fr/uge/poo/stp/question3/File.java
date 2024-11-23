package fr.uge.poo.stp.question3;

import java.nio.file.Path;
import java.util.Objects;

public record File(Path path, String name, String extension) implements FileSystem {
    public File(Path path, String name, String extension) {
        this.path = Objects.requireNonNull(path, "path is null");
        this.name = Objects.requireNonNull(name, "name is null");
        this.extension = Objects.requireNonNull(extension, "extension is null");
    }

    public static File of(Path path) {
        Objects.requireNonNull(path, "path is null");

        return new File(path, path.getFileName().toString(), path.getFileName().toString().toLowerCase());
    }
}
