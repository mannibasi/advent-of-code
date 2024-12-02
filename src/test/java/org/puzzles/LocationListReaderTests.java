package org.puzzles;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LocationListReaderTests {
    @Test
    public void testReadLocationListOne() {
        LocationListReader reader = new LocationListReader("src/test/resources/day_1_test_puzzle_input");
        List<Integer> listOne = reader.readListOne();
        assertAll(
                () -> assertEquals(37033, listOne.get(0)),
                () -> assertEquals(80098, listOne.get(1)),
                () -> assertEquals(88073, listOne.get(2))
        );
    }

    @Test
    public void testReadLocationListTwo() {
        LocationListReader reader = new LocationListReader("src/test/resources/day_1_test_puzzle_input");
        List<Integer> listTwo = reader.readListTwo();
        assertAll(
                () -> assertEquals(48086, listTwo.get(0)),
                () -> assertEquals(34930, listTwo.get(1)),
                () -> assertEquals(69183, listTwo.get(2))
        );
    }
}
