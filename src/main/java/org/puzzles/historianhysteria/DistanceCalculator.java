package org.puzzles.historianhysteria;

import java.util.Collections;
import java.util.List;

public class DistanceCalculator {

    private final List<Integer> locationIdListOne;
    private final List<Integer> locationIdListTwo;

    public DistanceCalculator(List<Integer> locationIdListOne, List<Integer> locationIdListTwo) {
        this.locationIdListOne = locationIdListOne;
        this.locationIdListTwo = locationIdListTwo;

        Collections.sort(this.locationIdListOne);
        Collections.sort(this.locationIdListTwo);
    }

    public int calculate() {
        int totalDistance = 0;
        for (int i = 0; i < locationIdListOne.size(); i++) {
            totalDistance += Math.abs(locationIdListTwo.get(i) - locationIdListOne.get(i));
        }
        return totalDistance;
    }
}
