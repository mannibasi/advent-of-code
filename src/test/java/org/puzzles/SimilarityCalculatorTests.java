package org.puzzles;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    public void testSimilarityScoreForItemThatAppearsInListTwoOnce() {
        List<Integer> locationIdListOne = new ArrayList<>();
        locationIdListOne.add(3);
        locationIdListOne.add(4);

        List<Integer> locationIdListTwo = new ArrayList<>();
        locationIdListTwo.add(4);
        locationIdListTwo.add(7);
        locationIdListTwo.add(9);
        locationIdListTwo.add(7);

        SimilarityCalculator calculator = new SimilarityCalculator(locationIdListOne, locationIdListTwo);

        int similarityScore = calculator.calculate();

        assertEquals(4, similarityScore);
    }

    @Test
    public void testSimilarityScoreForItemThatAppearsInListTwoTwice() {
        List<Integer> locationIdListOne = new ArrayList<>();
        locationIdListOne.add(3);
        locationIdListOne.add(7);

        List<Integer> locationIdListTwo = new ArrayList<>();
        locationIdListTwo.add(4);
        locationIdListTwo.add(7);
        locationIdListTwo.add(9);
        locationIdListTwo.add(7);

        SimilarityCalculator calculator = new SimilarityCalculator(locationIdListOne, locationIdListTwo);

        int similarityScore = calculator.calculate();

        assertEquals(14, similarityScore);
    }
}