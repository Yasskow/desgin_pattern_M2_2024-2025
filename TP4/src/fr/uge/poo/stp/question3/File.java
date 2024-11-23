package fr.uge.poo.stp.question3;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Objects;

public class File implements FileSystem{
    private final Path path;
    private final String name;
    private final String extension;

    public File(Path path, String name, String extension) {
        this.path = Objects.requireNonNull(path, "path is null");
        this.name = Objects.requireNonNull(name, "name is null");
        this.extension = Objects.requireNonNull(extension, "extension is null");
    }

    public static FileSystem of(Path path) {
        Objects.requireNonNull(path, "path is null");

        return new File(path, path.getFileName().toString(), path.getFileName().toString().toLowerCase());
    }
}
