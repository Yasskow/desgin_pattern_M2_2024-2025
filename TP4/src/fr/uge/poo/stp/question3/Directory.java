package fr.uge.poo.stp.question3;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Directory implements FileSystem{
    private final Path path;
    private final String name;
    private final List<FileSystem> subDirectories;
    
    public Directory(Path path, String name, List<FileSystem> subDirectories) {
        this.path = Objects.requireNonNull(path, "Path is null");
        this.name = Objects.requireNonNull(name, "Name is null");
        this.subDirectories = List.copyOf(subDirectories);
    }

    public static FileSystem of(Path path) throws IOException {
        Objects.requireNonNull(path, "Path is null");
        var listElements = Files.list(path);
        var allElements = new ArrayList<FileSystem>();

        listElements.forEach(path1 -> {
            var tmp = path1.toFile();
            if(tmp.isDirectory()) {
                try {
                    allElements.add(of(path1));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }else{
                allElements.add(File.of(path1));
            }
        });
        return new Directory(path, path.getFileName().toString(), allElements);
    }
}
