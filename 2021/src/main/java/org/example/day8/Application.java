package org.example.day8;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Stream;
import org.example.utils.FileReader;

public class Application {

    public static final String FILE_LOCATION = "day8/input.txt";

    public static void main(String[] args) throws URISyntaxException, IOException {
        FileReader fileReader = new FileReader();
        List<String> instructions = fileReader.readFileLines(FILE_LOCATION);

        partOne(instructions);
    }

    private static void partOne(List<String> instructions) {
        List<Integer> acceptedValues = List.of(2, 3, 4, 7);

        long total = instructions.stream()
                .map(i -> i.split("\\|")[1].split(" "))
                .flatMap(Stream::of)
                .filter(d -> acceptedValues.contains(d.length()))
                .count();

        System.out.println("Result was : " + total);
    }
}
