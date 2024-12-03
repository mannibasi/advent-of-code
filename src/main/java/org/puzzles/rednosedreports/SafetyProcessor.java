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
        boolean increasing = true;
        boolean decreasing = true;

        for (int i = 1; i < levelReadings.size(); i++) {
            if (levelReadings.get(i) >= levelReadings.get(i - 1)) {
                decreasing = false;
            }
            if (levelReadings.get(i) <= levelReadings.get(i - 1)) {
                increasing = false;
            }
        }

        return increasing || decreasing;
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
