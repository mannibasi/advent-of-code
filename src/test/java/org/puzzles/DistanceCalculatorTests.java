package org.puzzles;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DistanceCalculatorTests {
    @Test
    public void testTotalDistanceCalculationWithSingleItemLists() {
        List<Integer> locationIdListOne = new ArrayList<>();
        locationIdListOne.add(1);

        List<Integer> locationIdListTwo = new ArrayList<>();
        locationIdListTwo.add(3);

        DistanceCalculator calculator = new DistanceCalculator(locationIdListOne, locationIdListTwo);
        int distance = calculator.calculate();

        assertEquals(2, distance);
    }

    @Test
    public void testTotalDistanceCalculationWithMultiItemLists() {
        List<Integer> locationIdListOne = new ArrayList<>();
        locationIdListOne.add(1);
        locationIdListOne.add(2);

        List<Integer> locationIdListTwo = new ArrayList<>();
        locationIdListTwo.add(3);
        locationIdListTwo.add(4);

        DistanceCalculator calculator = new DistanceCalculator(locationIdListOne, locationIdListTwo);
        int distance = calculator.calculate();

        assertEquals(4, distance);
    }

    @Test
    public void testTotalDistanceCalculationWithExampleLists() {
        List<Integer> locationIdListOne = new ArrayList<>();
        locationIdListOne.add(3);
        locationIdListOne.add(4);
        locationIdListOne.add(2);
        locationIdListOne.add(1);
        locationIdListOne.add(3);
        locationIdListOne.add(3);

        List<Integer> locationIdListTwo = new ArrayList<>();
        locationIdListTwo.add(4);
        locationIdListTwo.add(3);
        locationIdListTwo.add(5);
        locationIdListTwo.add(3);
        locationIdListTwo.add(9);
        locationIdListTwo.add(3);

        DistanceCalculator calculator = new DistanceCalculator(locationIdListOne, locationIdListTwo);
        int distance = calculator.calculate();

        assertEquals(11, distance);
    }
}