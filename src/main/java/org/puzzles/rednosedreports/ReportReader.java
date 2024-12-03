package org.puzzles.rednosedreports;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReportReader {

    private final List<String> lines;

    public ReportReader(String filePath) {
        try {
            lines = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + filePath, e);
        }
    }

    public List<String> readReports() {
        return lines;
    }
}
