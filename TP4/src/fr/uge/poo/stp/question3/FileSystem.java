package fr.uge.poo.stp.question3;

import java.io.IOException;
import java.nio.file.Path;

public sealed interface FileSystem permits Directory, File {
    String getName();
    Path getPath();
}


/**
 * C'est le design pattern Composite
 *
 * */