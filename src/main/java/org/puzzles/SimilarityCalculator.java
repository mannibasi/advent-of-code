package org.puzzles;

import java.util.List;

public class SimilarityCalculator {
    private final List<Integer> locationIdListOne;
    private final List<Integer> locationIdListTwo;

    public SimilarityCalculator(List<Integer> locationIdListOne, List<Integer> locationIdListTwo) {
        this.locationIdListOne = locationIdListOne;
        this.locationIdListTwo = locationIdListTwo;
    }

    public int calculate() {
        int similarityScore = 0;
        for (Integer listOneLocationId : locationIdListOne) {
            if (locationIdListTwo.contains(listOneLocationId)) {
                similarityScore += listOneLocationId * numberOfOccurrences(listOneLocationId);
            }
        }
        return similarityScore;
    }

    private Integer numberOfOccurrences(Integer listOneLocationId) {
        int count = 0;
        for (Integer listTwoLocationId : locationIdListTwo) {
            if (listTwoLocationId.equals(listOneLocationId)) {
                count++;
            }
        }
        return count;
    }

}
