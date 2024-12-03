package org.puzzles;

import org.puzzles.historianhysteria.DistanceCalculator;
import org.puzzles.historianhysteria.LocationListReader;
import org.puzzles.historianhysteria.SimilarityCalculator;
import org.puzzles.rednosedreports.ReportProcessor;
import org.puzzles.rednosedreports.ReportReader;
import org.puzzles.rednosedreports.SafetyProcessor;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        historianHysteria();
        redNosedReports();
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