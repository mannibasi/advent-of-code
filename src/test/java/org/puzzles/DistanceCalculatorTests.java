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
}
