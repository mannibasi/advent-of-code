package org.puzzles.rednosedreports;

import java.util.List;

public class SafetyProcessor {
    private boolean dampenerUsed = false;

    public SafetyProcessor() { }

    public boolean isSafe(List<Integer> levelReadings) {
        if (adjacentValuesDifferByMoreThanThree(levelReadings)) {
            return false;
        }
        return allIncreasing(levelReadings) || allDecreasing(levelReadings);
    }

    private boolean allIncreasing(List<Integer> levelReadings) {
        for (int i = 1; i < levelReadings.size(); i++) {
            if (levelReadings.get(i) <= levelReadings.get(i - 1)) {
                if (dampenerUsed) {
                    return false;
                } else {
                    dampenerUsed = true;
                }
            }
        }
        return true;
    }

    private boolean allDecreasing(List<Integer> levelReadings) {
        for (int i = 1; i < levelReadings.size(); i++) {
            if (levelReadings.get(i) >= levelReadings.get(i - 1)) {
                if (dampenerUsed) {
                    return false;
                } else {
                    dampenerUsed = true;
                }
            }
        }
        return true;
    }

    private boolean adjacentValuesDifferByMoreThanThree(List<Integer> levelReadings) {
        for (int i = 1; i < levelReadings.size(); i++) {
            if (Math.abs(levelReadings.get(i) - levelReadings.get(i - 1)) > 3) {
                if (dampenerUsed) {
                    return true;
                } else {
                    dampenerUsed = true;
                }
            }
        }
        return false;
    }
}
