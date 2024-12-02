package org.puzzles;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class SimilarityCalculatorTests {
    @Test
    public void testSimilarityScoreForItemThatDoesNotAppearInListTwo() {
        List<Integer> locationIdListOne = new ArrayList<>();
        locationIdListOne.add(3);

        List<Integer> locationIdListTwo = new ArrayList<>();
        locationIdListTwo.add(4);
        locationIdListTwo.add(9);
        locationIdListTwo.add(7);

        SimilarityCalculator calculator = new SimilarityCalculator(locationIdListOne, locationIdListTwo);

        int similarityScore = calculator.calculate();

        assertEquals(0, similarityScore);
    }
}