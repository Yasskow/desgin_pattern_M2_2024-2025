package fr.uge.poo.stp.question3;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Application {

    public static List<String> findFilesWithExtension(Path directory, String extension) throws IOException {
        Objects.requireNonNull(directory, "directory is null");
        Objects.requireNonNull(extension, "extension is null");
        List<String> files = new ArrayList<>();
        var allElements = Directory.of(directory);
        allElements.getSubDirectories().forEach(fileSystem -> {
            switch(fileSystem){
                case File file -> {
                    if(file.getName().endsWith(extension)){
                        files.add(file.getName());
                    }
                }
                case Directory directory1 -> {
                    try {
                        files.addAll(findFilesWithExtension(directory1.getPath(), extension));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        return files;
    }

    public static void main(String[] args) throws IOException {
        var address = "C:\\Users\\Yassine\\Desktop\\Master2\\M2\\S1\\Design_pattern\\TP4";
//        Directory.of(Path.of(address));
        var test = Application.findFilesWithExtension(Path.of(address), ".xml");
        System.out.println(test);
    }
}
