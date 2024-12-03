package org.puzzles.rednosedreports;

import java.util.List;

public class SafetyProcessor {
    private final List<Integer> levelReadings;

    public SafetyProcessor(List<Integer> levelReadings) {
        this.levelReadings = levelReadings;
    }

    public boolean isSafe() {
        if (adjacentValuesDifferByMoreThanThree()) {
            return false;
        }
        return allIncreasingOrDecreasing();
    }

    private boolean allIncreasingOrDecreasing() {
        return allIncreasing() || allDecreasing();
    }

    private boolean allIncreasing() {
        for (int i = 1; i < levelReadings.size(); i++) {
            if (levelReadings.get(i) <= levelReadings.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean allDecreasing() {
        for (int i = 1; i < levelReadings.size(); i++) {
            if (levelReadings.get(i) >= levelReadings.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean adjacentValuesDifferByMoreThanThree() {
        for (int i = 1; i < levelReadings.size(); i++) {
            if (Math.abs(levelReadings.get(i) - levelReadings.get(i - 1)) > 3) {
                return true;
            }
        }
        return false;
    }
}
