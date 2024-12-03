package org.puzzles.rednosedreports;

import java.util.ArrayList;
import java.util.List;

public class SafetyProcessor {
    private final List<Integer> levelReadings;
    private boolean switchDampenerActivated = false;

    public SafetyProcessor(List<Integer> levelReadings) {
        this.levelReadings = levelReadings;
    }

    public boolean isSafe() {
        if (adjacentValuesDifferByMoreThanThree(levelReadings)) {
            return false;
        }
        if (isNeitherIncreasingOrDecreasing()) {
            return false;
        }
        return allIncreasingOrDecreasing(isIncreasing());
    }

    private boolean isIncreasing() {
        int numberOfLevelIncreases = 0;
        for (int i = 1; i < levelReadings.size(); i++) {
            if (levelReadings.get(i) > levelReadings.get(i - 1)) {
                numberOfLevelIncreases++;
            }
        }
        if (numberOfLevelIncreases == (levelReadings.size() / 2)) {
            System.out.println("Something has gone wrong");
        }
        return numberOfLevelIncreases > (levelReadings.size() / 2);
    }

    private boolean isNeitherIncreasingOrDecreasing() {
        int numberOfLevelIncreases = 0;
        for (int i = 1; i < levelReadings.size(); i++) {
            if (levelReadings.get(i) > levelReadings.get(i - 1)) {
                numberOfLevelIncreases++;
            }
        }
        return numberOfLevelIncreases == (levelReadings.size() / 2);
    }

    private boolean allIncreasingOrDecreasing(boolean isIncreasing) {
        if (isIncreasing) return allIncreasing(levelReadings);
        return allDecreasing(levelReadings);
    }

    private boolean allIncreasing(List<Integer> readings) {
        for (int i = 1; i < readings.size(); i++) {
            if (readings.get(i) <= readings.get(i - 1)) {
                if(switchDampenerActivated) {
                    return false;
                } else {
                    switchDampenerActivated = true;
                    List<Integer> modifiedList = new ArrayList<>(readings);
                    modifiedList.remove(i - 1);
                    return allIncreasing(modifiedList);
                }
            }
        }
        return true;
    }

    private boolean allDecreasing(List<Integer> readings) {
        for (int i = 1; i < readings.size(); i++) {
            if (readings.get(i) >= readings.get(i - 1)) {
                if(switchDampenerActivated) {
                    return false;
                } else {
                    switchDampenerActivated = true;
                    List<Integer> modifiedList = new ArrayList<>(readings);
                    modifiedList.remove(i - 1);
                    return allDecreasing(modifiedList);
                }
            }
        }
        return true;
    }

    private boolean adjacentValuesDifferByMoreThanThree(List<Integer> readings) {
        for (int i = 1; i < readings.size(); i++) {
            if (Math.abs(readings.get(i) - readings.get(i - 1)) > 3) {
                if(switchDampenerActivated) {
                    return true;
                } else {
                    switchDampenerActivated = true;
                    List<Integer> modifiedList = new ArrayList<>(readings);
                    modifiedList.remove(i - 1);
                    return adjacentValuesDifferByMoreThanThree(modifiedList);
                }
            }
        }
        return false;
    }
}
