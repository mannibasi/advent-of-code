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
        return similarityScore;
    }


}
