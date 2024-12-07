package org.puzzles.mullitover;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
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

    @Test
    public void testCorruptedMemoryInstructionProcessorReturnsMultiplicationInstructions() {
        CorruptedInstructionProcessor processor = new CorruptedInstructionProcessor("xmul(2,4)%&mul[3,7]!@^do_not_mul(5,5)+mul(32,64]then(mul(11,8)mul(8,5))");
        List<String> instructions = processor.getMultiplicationInstructions();
        assertAll(
            () -> assertEquals(4, instructions.size()),
            () -> assertEquals("mul(2,4)", instructions.get(0)),
            () -> assertEquals("mul(5,5)", instructions.get(1)),
            () -> assertEquals("mul(11,8)", instructions.get(2)),
            () -> assertEquals("mul(8,5)", instructions.get(3))
        );
    }
}
