package org.example.day6;

import java.util.HashMap;
import java.util.Map;
import org.example.utils.FileReader;

public class Application {

    public static final String FILE_LOCATION = "day6/input.txt";

    public static void main(String[] args) throws Exception {
        FileReader fileReader = new FileReader();
        fileReader.printFileToConsole("banner.txt");

        System.out.println("Fishes " + fishAfterDays(256));
    }

    public static long fishAfterDays(int days) throws Exception {
        FileReader fileReader = new FileReader();
        String ages = fileReader.readFileLines(FILE_LOCATION).get(0);

        Map<String, Long> fishAtAges = initialiseFishMap();

        for (String s : ages.split(",")) {
            fishAtAges.merge(s, 1L, Long::sum);
        }

        for (int i = 0; i < days; i++) {
            Map<String, Long> nextDayAges = initialiseFishMap();

            for (String age : fishAtAges.keySet()) {
                switch (age) {
                    case "0":
                        nextDayAges.merge("6", fishAtAges.get(age), Long::sum);
                        nextDayAges.merge("8", fishAtAges.get(age), Long::sum);
                        break;
                    default:
                        nextDayAges.merge(String.valueOf(Long.parseLong(age) - 1L), fishAtAges.get(age), Long::sum);
                        break;
                }
            }

            fishAtAges = nextDayAges;
        }

        return fishAtAges.values().stream().mapToLong(l -> l).sum();
    }

    private static Map<String, Long> initialiseFishMap() {
        Map<String, Long> fishAtAges = new HashMap<>(9);
        fishAtAges.put("0", 0L);
        fishAtAges.put("1", 0L);
        fishAtAges.put("2", 0L);
        fishAtAges.put("3", 0L);
        fishAtAges.put("4", 0L);
        fishAtAges.put("5", 0L);
        fishAtAges.put("6", 0L);
        fishAtAges.put("7", 0L);
        fishAtAges.put("8", 0L);
        return fishAtAges;
    }
}
