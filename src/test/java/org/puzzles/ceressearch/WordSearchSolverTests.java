package org.puzzles.ceressearch;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WordSearchSolverTests {
    @Test
    public void testWordFoundInFirstRow() {
        char[][] board = {
                {'X', 'M', 'A', 'S'},
                {'S', 'F', 'C', 'S'},
                {'A', 'X', 'A', 'I'},
                {'M', 'S', 'E', 'O'}
        };
        WordSearchSolver wordSearchSolver = new WordSearchSolver(board);
        assertEquals(1, wordSearchSolver.find("XMAS"));
    }

    @Test
    public void testWordFoundInFirstRowInReverse() {
        char[][] board = {
                {'S', 'A', 'M', 'X'},
                {'S', 'F', 'C', 'S'},
                {'A', 'X', 'A', 'I'},
                {'M', 'S', 'E', 'O'}
        };
        WordSearchSolver wordSearchSolver = new WordSearchSolver(board);
        assertEquals(1, wordSearchSolver.find("XMAS"));
    }

    @Test
    public void testWordFoundInFirstColumn() {
        char[][] board = {
                {'X', 'A', 'A', 'X'},
                {'M', 'F', 'C', 'S'},
                {'A', 'X', 'A', 'I'},
                {'S', 'S', 'E', 'O'}
        };
        WordSearchSolver wordSearchSolver = new WordSearchSolver(board);
        assertEquals(1, wordSearchSolver.find("XMAS"));
    }

    @Test
    public void testWordFoundInFirstColumnInReverse() {
        char[][] board = {
                {'S', 'A', 'A', 'X'},
                {'A', 'F', 'C', 'S'},
                {'M', 'X', 'A', 'I'},
                {'X', 'S', 'E', 'O'}
        };
        WordSearchSolver wordSearchSolver = new WordSearchSolver(board);
        assertEquals(1, wordSearchSolver.find("XMAS"));
    }
}
