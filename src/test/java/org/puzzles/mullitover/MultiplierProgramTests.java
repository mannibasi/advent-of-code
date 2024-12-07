package org.puzzles.mullitover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplierProgramTests {
    @Test
    public void testMultiplication() {
        Calculator calculator = new Calculator();
        assertEquals(8, calculator.calculate("mul(2,4)"));
    }
}
