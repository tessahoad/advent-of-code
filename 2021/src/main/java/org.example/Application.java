package org.example;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Application {

    public static void main(String[] args) {

    }

    private static List<String> readInputFile() throws URISyntaxException, IOException {
        Path fileLocation = Paths.get(ClassLoader.getSystemResource("input.txt").toURI());
        List<String> linesAsStrings = Files.readAllLines(fileLocation);
        return linesAsStrings;
    }
}
