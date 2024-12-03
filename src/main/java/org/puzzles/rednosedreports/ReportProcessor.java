package org.puzzles.rednosedreports;

import java.util.ArrayList;
import java.util.List;

public class ReportProcessor {

    private final List<Integer> levels = new ArrayList<>();

    public ReportProcessor(String report) {
        String[] levelReadings = report.split(" ");
        for (String levelReading : levelReadings) {
            levels.add(Integer.parseInt(levelReading));
        }
    }

    public List<Integer> readLevels() {
        return levels;
    }
}
