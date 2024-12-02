package org.puzzles;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class LocationListReaderTests {
    @Test
    public void testReadLocationListOne() {
        LocationListReader reader = new LocationListReader("src/test/resources/day_1_test_puzzle_input");
        ArrayList<Integer> listOne = reader.readListOne();
        assertAll(
                () -> assertEquals(37033, listOne.get(0)),
                () -> assertEquals(80098, listOne.get(1)),
                () -> assertEquals(88073, listOne.get(2))
        );
    }
}
