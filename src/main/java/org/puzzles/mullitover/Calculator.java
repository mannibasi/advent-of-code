package org.puzzles.mullitover;

public class Calculator {
    public int calculate(String calculationInstruction) {
        String[] instructionInput = calculationInstruction.replace("mul(", "").replace(")", "").split(",", 2);
        int multiplicand = Integer.parseInt(instructionInput[0]);
        int multiplier = Integer.parseInt(instructionInput[1]);
        return multiplicand * multiplier;
    }
}
