package org.puzzles.rednosedreports;

import java.util.ArrayList;
import java.util.List;

public class SafetyProcessor {
    private List<Integer> levelReadings;
    private boolean dampenerUsed = false;

    public SafetyProcessor(List<Integer> levelReadings) {
        this.levelReadings = levelReadings;
    }

    private boolean isSafe(List<Integer> readings) {
        if (adjacentValuesDifferByThreeOrLess(readings)) {
            if (mostlyIncreasing()) {
                return allIncreasing(readings);
            }
            return allDecreasing(readings);
        }
        return false;
    }

    public boolean isSafe() {
        if (adjacentValuesDifferByThreeOrLess(levelReadings)) {
            if (mostlyIncreasing()) {
                return allIncreasing(levelReadings);
            }
            return allDecreasing(levelReadings);
        }
        return false;
    }

    private boolean mostlyIncreasing() {
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

    private boolean allIncreasing(List<Integer> readings) {
        for (int i = 1; i < readings.size(); i++) {
            if (readings.get(i) <= readings.get(i - 1)) {
                if (dampenerUsed) {
                    return false;
                } else {
                    dampenerUsed = true;
                    return dampenedSafetyCheck(readings, i);
                }
            }
        }
        return true;
    }

    private boolean allDecreasing(List<Integer> readings) {
        for (int i = 1; i < readings.size(); i++) {
            if (readings.get(i) >= readings.get(i - 1)) {
                if (dampenerUsed) {
                    return false;
                } else {
                    dampenerUsed = true;
                    return dampenedSafetyCheck(readings, i);
                }
            }
        }
        return true;
    }

    private boolean adjacentValuesDifferByThreeOrLess(List<Integer> readings) {
        for (int i = 1; i < readings.size(); i++) {
            if (Math.abs(readings.get(i) - readings.get(i - 1)) > 3) {
                if (dampenerUsed) {
                    return false;
                } else {
                    dampenerUsed = true;
                    return dampenedSafetyCheck(readings, i);
                }
            }
        }
        return true;
    }

    private boolean dampenedSafetyCheck(List<Integer> readings, int i) {
        if (i >= 1) {
            List<Integer> listWithPreviousItemRemoved = new ArrayList<>(readings);
            listWithPreviousItemRemoved.remove(i - 1);
            if (isSafe(listWithPreviousItemRemoved)) {
                this.levelReadings = listWithPreviousItemRemoved;
                return true;
            }
        }

        if (readings.size() > i + 1) {
            List<Integer> listWithNextItemRemoved = new ArrayList<>(readings);
            listWithNextItemRemoved.remove(i + 1);
            if(isSafe(listWithNextItemRemoved)) {
                this.levelReadings = listWithNextItemRemoved;
                return true;
            };
        }

        List<Integer> listWithCurrentItemRemoved = new ArrayList<>(readings);
        listWithCurrentItemRemoved.remove(i);
        if(isSafe(listWithCurrentItemRemoved)) {
            this.levelReadings = listWithCurrentItemRemoved;
            return true;
        };
        return false;
    }
}
