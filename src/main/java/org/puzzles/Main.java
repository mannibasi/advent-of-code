package org.puzzles;

import org.puzzles.ceressearch.WordSearchSolver;
import org.puzzles.historianhysteria.DistanceCalculator;
import org.puzzles.historianhysteria.LocationListReader;
import org.puzzles.historianhysteria.SimilarityCalculator;
import org.puzzles.mullitover.Calculator;
import org.puzzles.mullitover.CorruptedInstructionProcessor;
import org.puzzles.rednosedreports.ReportProcessor;
import org.puzzles.rednosedreports.ReportReader;
import org.puzzles.rednosedreports.SafetyProcessor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        historianHysteria();
        redNosedReports();
        mullItOver();
        ceresSearch();
    }

    private static void ceresSearch() {
        char[][] board = readBoardFromFile("src/main/resources/org/puzzles/ceressearch/day_4_puzzle_input");
        WordSearchSolver wordSearchSolver = new WordSearchSolver(board);
        System.out.println("Word count: " + wordSearchSolver.find("XMAS"));
        System.out.println("Word cross count: " + wordSearchSolver.findCrosses("MAS"));
    }

    private static void mullItOver() {
        String corruptedInstructions = readFileAsString("src/main/resources/org/puzzles/mullitover/day_3_puzzle_input");
        Calculator calculator = new Calculator();
        CorruptedInstructionProcessor processor = new CorruptedInstructionProcessor(corruptedInstructions);
        int total = processor.getMultiplicationInstructions().stream()
                .mapToInt(calculator::calculate)
                .sum();
        System.out.println("Multiplication instruction total: " + total);
    }

    private static void redNosedReports() {
        ReportReader reader = new ReportReader("src/main/resources/org/puzzles/rednosedreports/day_2_puzzle_input");
        List<String> reports = reader.readReports();
        long safeReportCount = reports.stream()
                .map(ReportProcessor::new)
                .map(ReportProcessor::readLevels)
                .map(SafetyProcessor::new)
                .filter(SafetyProcessor::isSafe)
                .count();
        System.out.println("Safe report count: " + safeReportCount);
    }

    private static void historianHysteria() {
        LocationListReader reader = new LocationListReader("src/main/resources/org/puzzles/historianhysteria/day_1_puzzle_input");
        DistanceCalculator distanceCalculator = new DistanceCalculator(reader.readListOne(), reader.readListTwo());
        System.out.println("Total distance: " + distanceCalculator.calculate());

        SimilarityCalculator similarityCalculator = new SimilarityCalculator(reader.readListOne(), reader.readListTwo());
        System.out.println("Similarity score: " + similarityCalculator.calculate());
    }

    private static char[][] readBoardFromFile(String filePath) {
        try {
            return Files.readAllLines(Path.of(filePath)).stream()
                    .map(String::toCharArray)
                    .toArray(char[][]::new);
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + filePath, e);
        }
    }

    private static String readFileAsString(String filePath) {
        try {
            return Files.readString(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + filePath, e);
        }
    }
}