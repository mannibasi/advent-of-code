package org.puzzles;

import java.util.List;

public class DistanceCalculator {

    private final List<Integer> locationIdListOne;
    private final List<Integer> locationIdListTwo;

    public DistanceCalculator(List<Integer> locationIdListOne, List<Integer> locationIdListTwo) {
        this.locationIdListOne = locationIdListOne;
        this.locationIdListTwo = locationIdListTwo;
    }

    public int calculate() {
        return locationIdListTwo.getFirst() - locationIdListOne.getFirst();
    }
}
