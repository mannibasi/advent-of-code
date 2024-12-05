package org.puzzles.rednosedreports;

import java.util.ArrayList;
import java.util.List;

public class SafetyProcessor {
    private List<Integer> levelReadings;
    private final boolean mostlyIncreasing;

    public SafetyProcessor(List<Integer> levelReadings) {
        this.levelReadings = levelReadings;
        this.mostlyIncreasing = mostlyIncreasing(levelReadings);
    }

    public boolean isSafe() {
        return isSafe(levelReadings, false);
    }

    private boolean isSafe(List<Integer> readings, boolean dampenerUsed) {
        if (adjacentValuesDifferByThreeOrLess(readings, dampenerUsed)) {
            if (mostlyIncreasing) {
                return allIncreasing(readings, dampenerUsed);
            }
            return allDecreasing(readings, dampenerUsed);
        }
        return false;
    }

    private boolean mostlyIncreasing(List<Integer> readings) {
        int increasingCount = 0;
        int decreasingCount = 0;
        for (int i = 1; i < readings.size(); i++) {
            if (readings.get(i) > readings.get(i - 1)) {
                increasingCount++;
            } else if (readings.get(i) < readings.get(i - 1)) {
                decreasingCount++;
            }
        }
        return increasingCount >= decreasingCount;
    }

    private boolean allIncreasing(List<Integer> readings, boolean dampenerUsed) {
        for (int i = 1; i < readings.size(); i++) {
            if (readings.get(i) <= readings.get(i - 1)) {
                return dampenedSafetyCheck(readings, i, dampenerUsed);
            }
        }
        return true;
    }

    private boolean allDecreasing(List<Integer> readings, boolean dampenerUsed) {
        for (int i = 1; i < readings.size(); i++) {
            if (readings.get(i) >= readings.get(i - 1)) {
                return dampenedSafetyCheck(readings, i, dampenerUsed);
            }
        }
        return true;
    }

    private boolean adjacentValuesDifferByThreeOrLess(List<Integer> readings, boolean dampenerUsed) {
        for (int i = 1; i < readings.size(); i++) {
            if (Math.abs(readings.get(i) - readings.get(i - 1)) > 3) {
                return dampenedSafetyCheck(readings, i, dampenerUsed);
            }
        }
        return true;
    }

    private boolean dampenedSafetyCheck(List<Integer> readings, int index, boolean dampenerUsed) {
        if (dampenerUsed) {
            return false;
        }

        List<Integer> listWithPreviousItemRemoved = new ArrayList<>(readings);
        listWithPreviousItemRemoved.remove(index - 1);
        if (isSafe(listWithPreviousItemRemoved, true)) {
            this.levelReadings = listWithPreviousItemRemoved;
            return true;
        }

        if (readings.size() > index + 1) {
            List<Integer> listWithNextItemRemoved = new ArrayList<>(readings);
            listWithNextItemRemoved.remove(index + 1);
            if (isSafe(listWithNextItemRemoved, true)) {
                this.levelReadings = listWithNextItemRemoved;
                return true;
            }
        }

        List<Integer> listWithCurrentItemRemoved = new ArrayList<>(readings);
        listWithCurrentItemRemoved.remove(index);
        if (isSafe(listWithCurrentItemRemoved, true)) {
            this.levelReadings = listWithCurrentItemRemoved;
            return true;
        }

        return false;
    }
}