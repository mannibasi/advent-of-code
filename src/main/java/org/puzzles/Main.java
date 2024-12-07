package org.puzzles;

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
    }

    private static void mullItOver() {
        String corruptedInstructions;
        try {
            corruptedInstructions = Files.readAllLines(Path.of("src/main/resources/org/puzzles/mullitover/day_3_puzzle_input")).toString();
        } catch (IOException e) {
            throw new RuntimeException("Error reading day 3 input file", e);
        }
        Calculator calculator = new Calculator();
        CorruptedInstructionProcessor processor = new CorruptedInstructionProcessor(corruptedInstructions);
        List<String> instructions = processor.getMultiplicationInstructions();
        int total = 0;
        for (String instruction : instructions) {
            total += calculator.calculate(instruction);
        }
        System.out.println("Multiplication instruction total: " + total); //162813399; part 2: 53783319
    }

    private static void redNosedReports() {
        ReportReader reader = new ReportReader("src/main/resources/org/puzzles/rednosedreports/day_2_puzzle_input");
        List<String> reports = reader.readReports();
        int safeReportCount = 0;
        for (String report : reports) {
            ReportProcessor processor = new ReportProcessor(report);
            SafetyProcessor safetyProcessor = new SafetyProcessor(processor.readLevels());
            if(safetyProcessor.isSafe()) {
                safeReportCount++;
            }
        }
        System.out.println("Safe report count: " + safeReportCount); //486
    }

    private static void historianHysteria() {
        LocationListReader reader = new LocationListReader("src/main/resources/org/puzzles/historianhysteria/day_1_puzzle_input");
        DistanceCalculator calculator = new DistanceCalculator(reader.readListOne(), reader.readListTwo());
        int distance = calculator.calculate();
        System.out.println("Total distance: " + distance); //1223326

        SimilarityCalculator similarityCalculator = new SimilarityCalculator(reader.readListOne(), reader.readListTwo());
        int similarityScore = similarityCalculator.calculate();
        System.out.println("Similarity score: " + similarityScore); //21070419
    }
}