package org.puzzles;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class LocationListReader {
    private final ArrayList<Integer> locationListOne = new ArrayList<>();
    private final ArrayList<Integer> locationListTwo = new ArrayList<>();

    public LocationListReader(String filePath) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Path.of(filePath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for (String line : lines) {
            String[] parts = line.split("\\s+");
            locationListOne.add(parseInt(parts[0]));
            locationListTwo.add(parseInt(parts[1]));
        }
    }

    public ArrayList<Integer> readListOne() {
        return locationListOne;
    }

    public ArrayList<Integer> readListTwo() { return locationListTwo; }
}