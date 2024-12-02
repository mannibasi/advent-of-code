package org.puzzles;

public class Main {
    public static void main(String[] args) {
        LocationListReader reader = new LocationListReader("src/main/resources/day_1_puzzle_input");
        DistanceCalculator calculator = new DistanceCalculator(reader.readListOne(), reader.readListTwo());
        int distance = calculator.calculate();
        System.out.println("Total distance: " + distance); //1223326
    }
}