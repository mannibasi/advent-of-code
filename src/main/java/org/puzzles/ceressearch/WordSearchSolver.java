package org.puzzles.ceressearch;

public class WordSearchSolver {
    private final char[][] board;
    private int numberOfTimesWordFound;

    public WordSearchSolver(char[][] board) {
        this.board = board;
    }

    public int find(String word) {
        numberOfTimesWordFound = 0;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                searchWord(row, col, word);
            }
        }
        return numberOfTimesWordFound;
    }

    private void searchWord(int row, int col, String word) {
        findHorizontally(row, col, word);
        findVertically(row, col, word);
        foundDiagonally(row, col, word);
    }

    private void findHorizontally(int row, int col, String word) {
        StringBuilder forward = new StringBuilder();
        StringBuilder backward = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (col + i < board[row].length) {
                forward.append(board[row][col + i]);
            }
            if (col - i >= 0) {
                backward.append(board[row][col - i]);
            }
        }

        if (forward.toString().equals(word)) {
            numberOfTimesWordFound++;
        }
        if (backward.toString().equals(word)) {
            numberOfTimesWordFound++;
        }
    }

    private void foundDiagonally(int row, int col, String word) {
    }

    private void findVertically(int row, int col, String word) {
        StringBuilder forward = new StringBuilder();
        StringBuilder backward = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (row + i < board[col].length) {
                forward.append(board[row + i][col]);
            }
            if (row - i >= 0) {
                backward.append(board[row - i][col]);
            }
        }
        if (forward.toString().equals(word)) {
            numberOfTimesWordFound++;
        }
        if (backward.toString().equals(word)) {
            numberOfTimesWordFound++;
        }
    }
}