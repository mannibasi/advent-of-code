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

    @Test
    public void testWordsFoundOverlappingVerticallyAndHorizontally() {
        char[][] board = {
                {'X', 'M', 'A', 'S'},
                {'M', 'X', 'C', 'A'},
                {'A', 'F', 'X', 'M'},
                {'S', 'A', 'M', 'X'}
        };
        WordSearchSolver wordSearchSolver = new WordSearchSolver(board);
        assertEquals(4, wordSearchSolver.find("XMAS"));
    }

    @Test
    public void testWordFoundDiagonally() {
        char[][] board = {
                {'S', 'M', 'A', 'A'},
                {'M', 'A', 'C', 'A'},
                {'A', 'F', 'M', 'M'},
                {'S', 'A', 'A', 'X'}
        };
        WordSearchSolver wordSearchSolver = new WordSearchSolver(board);
        assertEquals(1, wordSearchSolver.find("XMAS"));
    }

    @Test
    public void testExamplePuzzle() {
        char[][] board = {
                {'M', 'M', 'M', 'S', 'X', 'X', 'M', 'A', 'S', 'M'},
                {'M', 'S', 'A', 'M', 'X', 'M', 'S', 'M', 'S', 'A'},
                {'A', 'M', 'X', 'S', 'X', 'M', 'A', 'A', 'M', 'M'},
                {'M', 'S', 'A', 'M', 'A', 'S', 'M', 'S', 'M', 'X'},
                {'X', 'M', 'A', 'S', 'A', 'M', 'X', 'A', 'M', 'M'},
                {'X', 'X', 'A', 'M', 'M', 'X', 'X', 'A', 'M', 'A'},
                {'S', 'M', 'S', 'M', 'S', 'A', 'S', 'X', 'S', 'S'},
                {'S', 'A', 'X', 'A', 'M', 'A', 'S', 'A', 'A', 'A'},
                {'M', 'A', 'M', 'M', 'M', 'X', 'M', 'M', 'M', 'M'},
                {'M', 'X', 'M', 'X', 'A', 'M', 'A', 'S', 'X', 'X'}
        };
        WordSearchSolver wordSearchSolver = new WordSearchSolver(board);
        assertEquals(18, wordSearchSolver.find("XMAS"));
    }
}
