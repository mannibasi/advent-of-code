package org.puzzles.mullitover;

import org.junit.jupiter.api.Test;

import java.util.List;

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
        assertEquals(4, instructions.size());
    }
}
