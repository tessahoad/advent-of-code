package org.example.day7;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.OptionalLong;
import java.util.function.LongUnaryOperator;
import java.util.stream.LongStream;
import org.example.utils.FileReader;

public class Application {

    public static final String CRAB_LOCATIONS_LOCATION = "day7/input.txt";

    public static void main(String[] args) throws URISyntaxException, IOException {
        FileReader fileReader = new FileReader();
        fileReader.printFileToConsole("banner.txt");
        String crabLocations = fileReader.readFileLines(CRAB_LOCATIONS_LOCATION).get(0);
        long[] crabHorizontalPositions = Arrays.stream(crabLocations.split(",")).mapToLong(Long::parseLong).sorted().toArray();
        long smallest = crabHorizontalPositions[0];
        long biggest = crabHorizontalPositions[crabHorizontalPositions.length - 1];

        part1(crabHorizontalPositions, smallest, biggest);
        part2(crabHorizontalPositions, smallest, biggest);
    }

    private static void part1(long[] crabHorizontalPositions, long smallest, long biggest) {
        OptionalLong min = LongStream.range(smallest, biggest)
                .map(horizontalPosition -> getFuelConsumption(crabHorizontalPositions, l -> Math.abs(l - horizontalPosition)))
                .min();

        System.out.println(min.getAsLong());
    }

    private static void part2(long[] crabHorizontalPositions, long smallest, long biggest) {
        OptionalLong min = LongStream.range(smallest, biggest)
                .map(horizontalPosition -> getFuelConsumption(crabHorizontalPositions, l -> getNthTriangleNumber(Math.abs(l - horizontalPosition))))
                .min();

        System.out.println(min.getAsLong());
    }

    private static long getFuelConsumption(long[] crabHorizontalPositions, LongUnaryOperator operator) {
        return Arrays.stream(crabHorizontalPositions)
                .map(operator)
                .sum();
    }

    private static long getNthTriangleNumber(long n) {
        return (n * (n + 1)) / 2;
    }
}
