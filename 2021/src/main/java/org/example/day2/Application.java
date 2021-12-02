package org.example.day2;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import org.example.utils.FileReader;

public class Application {

    public static final String INSTRUCTIONS_FILE_LOCATION = "day2/input.txt";

    public static void main(String[] args) throws URISyntaxException, IOException {
        FileReader fileReader = new FileReader();
        fileReader.printFileToConsole("day2/banner.txt");
        List<String> instructions = fileReader.readFileLines(INSTRUCTIONS_FILE_LOCATION);

        Submarine submarine = new Submarine();

        instructions.forEach(instruction -> {
            String[] s1 = instruction.split("\\s+");
            Direction direction = Direction.valueOf(s1[0]);
            long value = Long.parseLong(s1[1]);
            submarine.basicMove(direction, value);
        });

        System.out.println("Result of problem 1 :" + submarine.getFinalPosition());

        submarine.resetPosition();

        instructions.forEach(instruction -> {
            String[] s1 = instruction.split("\\s+");
            Direction direction = Direction.valueOf(s1[0]);
            long value = Long.parseLong(s1[1]);
            submarine.moreAccurateMove(direction, value);
        });

        System.out.println("Result of problem 2 :" + submarine.getFinalPosition());
    }
}
