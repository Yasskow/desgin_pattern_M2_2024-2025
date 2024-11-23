package fr.uge.poo.stp.question3;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {

    public static List<String> findFilesWithExtension(Path directory, String extension){
        Objects.requireNonNull(directory, "directory is null");
        Objects.requireNonNull(extension, "extension is null");
        List<String> files = new ArrayList<>();

    }
}
