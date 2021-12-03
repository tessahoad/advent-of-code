package org.example.day3;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.stream.Collectors;
import org.example.utils.FileReader;

import static java.lang.Long.parseLong;

public class Application {

    public static final String DIAGNOSTIC_REPORT_LOCATION = "day3/input.txt";

    public static void main(String[] args) throws URISyntaxException, IOException {
        FileReader fileReader = new FileReader();
        fileReader.printFileToConsole("banner.txt");
        List<String> diagnosticReport = fileReader.readFileLines(DIAGNOSTIC_REPORT_LOCATION);

        part1(diagnosticReport);
        part2(diagnosticReport);
    }

    private static void part1(List<String> diagnosticReport) {
        StringBuilder epsilonRate = new StringBuilder(5);
        StringBuilder gammaRate = new StringBuilder(5);
        int diagnosticPoints = diagnosticReport.get(0).length();

        for (int i = 0; i < diagnosticPoints; i++) {
            char mostPopularCharacterAtPosition = getMostPopularCharacterAtPosition(diagnosticReport, i);
            gammaRate.append(mostPopularCharacterAtPosition);
            epsilonRate.append(getOpposite(mostPopularCharacterAtPosition));
        }

        System.out.println("Answer to part 1: " + multiplyBinaryStrings(String.valueOf(gammaRate), String.valueOf(epsilonRate)));
    }

    private static void part2(List<String> diagnosticReport) {
        List<String> oxygenDiagnostic = List.copyOf(diagnosticReport);
        List<String> co2Diagnostic = List.copyOf(diagnosticReport);

        System.out.println("Answer to part 2: " + multiplyBinaryStrings(reduceReport(oxygenDiagnostic, true, 0), reduceReport(co2Diagnostic, false, 0)));
    }

    private static String reduceReport(List<String> diagnosticReport, boolean isOxygenReport, int examinationPoint) {
        if (diagnosticReport.size() == 1) {
            return diagnosticReport.get(0);
        }
        char mostPopularCharacterAtPosition = getMostPopularCharacterAtPosition(diagnosticReport, examinationPoint);
        char character = isOxygenReport ? mostPopularCharacterAtPosition : getOpposite(mostPopularCharacterAtPosition);
        return reduceReport(diagnosticReport.stream().filter(r -> r.charAt(examinationPoint) == character).collect(Collectors.toList()),
                isOxygenReport,
                examinationPoint + 1);
    }

    private static long multiplyBinaryStrings(String s1, String s2) {
        return parseLong(s1, 2) * parseLong(s2, 2);
    }

    private static char getMostPopularCharacterAtPosition(List<String> diagnosticReport, int position) {
        long countOnes = diagnosticReport.stream()
                .map(report -> report.charAt(position))
                .filter(c -> c == '1')
                .count();
        long countZeroes = diagnosticReport.size() - countOnes;
        return countOnes >= countZeroes ? '1' : '0';
    }

    private static char getOpposite(char c) {
        return c == '1' ? '0' : '1';
    }
}
