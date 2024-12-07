package org.puzzles.mullitover;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MultiplierProgramTests {
    @Test
    public void testMultiplicationWithOneDigitMultiplicandAndMultiplier() {
        Calculator calculator = new Calculator();
        assertEquals(8, calculator.calculate("mul(2,4)"));
    }

    @Test
    public void testMultiplicationWithThreeDigitMultiplicandAndOneDigitMultiplier() {
        Calculator calculator = new Calculator();
        assertEquals(404, calculator.calculate("mul(101,4)"));
    }
}
