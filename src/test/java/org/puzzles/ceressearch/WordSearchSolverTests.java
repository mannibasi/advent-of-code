package org.puzzles.ceressearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordSearchSolverTests {
    @Test
    public void testWordFoundFirstRow() {
        char[][] board = {
                {'X', 'M', 'A', 'S'},
                {'S', 'F', 'C', 'S'},
                {'A', 'X', 'A', 'I'},
                {'M', 'S', 'E', 'O'}
        };
        WordSearchSolver wordSearchSolver = new WordSearchSolver(board);
        assertEquals(1, wordSearchSolver.find("XMAS"));
    }
}
