package org.puzzles.rednosedreports;

import java.util.ArrayList;
import java.util.List;

public class SafetyProcessor {
    private boolean dampenerUsed = false;

    public SafetyProcessor() { }

    public boolean isSafe(List<Integer> levelReadings) {
        if (adjacentValuesDifferByMoreThanThree(levelReadings)) {
            return false;
        }

        if (mostlyIncreasing(levelReadings)) {
            return allIncreasing(levelReadings);
        }

        return allDecreasing(levelReadings);
    }

    private boolean mostlyIncreasing(List<Integer> levelReadings) {
        int increasingCount = 0;
        int decreasingCount = 0;
        for (int i = 1; i < levelReadings.size(); i++) {
            if (levelReadings.get(i) > levelReadings.get(i - 1)) {
                increasingCount++;
            } else if (levelReadings.get(i) < levelReadings.get(i - 1)) {
                decreasingCount++;
            }
        }
        return increasingCount >= decreasingCount;
    }

    private boolean allIncreasing(List<Integer> levelReadings) {
        for (int i = 1; i < levelReadings.size(); i++) {
            if (levelReadings.get(i) <= levelReadings.get(i - 1)) {
                if (dampenerUsed) {
                    return false;
                } else {
                    dampenerUsed = true;
                    return dampenedSafetyCheck(levelReadings, i);
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
                    return dampenedSafetyCheck(levelReadings, i);
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
                    return dampenedSafetyCheck(levelReadings, i);
                }
            }
        }
        return false;
    }

    private boolean dampenedSafetyCheck(List<Integer> levelReadings, int i) {
        if (i >= 1) {
            List<Integer> listWithPreviousItemRemoved = new ArrayList<>(levelReadings);
            listWithPreviousItemRemoved.remove(i - 1);
            if (isSafe(listWithPreviousItemRemoved)) return true;
        }

        if (levelReadings.size() > i + 1) {
            List<Integer> listWithNextItemRemoved = new ArrayList<>(levelReadings);
            listWithNextItemRemoved.remove(i + 1);
            return isSafe(listWithNextItemRemoved);
        }

        List<Integer> listWithCurrentItemRemoved = new ArrayList<>(levelReadings);
        listWithCurrentItemRemoved.remove(i);
        return isSafe(listWithCurrentItemRemoved);
    }
}
