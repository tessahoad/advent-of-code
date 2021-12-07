package org.example.templateday;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import org.example.utils.FileReader;

public class Application {

    public static final String FILE_LOCATION = "day/input.txt";

    public static void main(String[] args) throws URISyntaxException, IOException {
        FileReader fileReader = new FileReader();
        fileReader.printFileToConsole("banner.txt");
        List<String> instructions = fileReader.readFileLines(FILE_LOCATION);
    }
}
