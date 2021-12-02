package org.example.utils;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class FileReader {

    public List<String> readFileLines(String fileLocation) throws URISyntaxException, IOException {
        Path filePath = Paths.get(ClassLoader.getSystemResource(fileLocation).toURI());
        List<String> linesAsStrings = Files.readAllLines(filePath);
        return linesAsStrings;
    }

    public void printFileToConsole(String fileLocation) throws URISyntaxException, IOException {
        Path filePath = Paths.get(ClassLoader.getSystemResource(fileLocation).toURI());
        System.out.println(new String(Files.readAllBytes(filePath)));
    }
}
