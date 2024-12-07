package org.puzzles.mullitover;

public class Calculator {
    public int calculate(String calculationInstruction) {
        int multiplicand = Integer.parseInt(calculationInstruction.substring(4, 5));
        int multiplier = Integer.parseInt(calculationInstruction.substring(6, 7));
        return multiplicand * multiplier;
    }
}
