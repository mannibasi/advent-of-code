package org.puzzles.ceressearch;

public class WordSearchSolver {
    private final char[][] board;

    public WordSearchSolver(char[][] board) {
        this.board = board;
    }

    public int find(String word) {
        int numberOfTimesWordFound = 0;
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                if(board[row][col] == word.charAt(0)) {
                    if (searchWord(row, col, word)) {
                        numberOfTimesWordFound++;
                    }
                }
            }
        }
        return numberOfTimesWordFound;
    }

    private boolean searchWord(int row, int col, String word) {
        return foundAcross(row, col, word) || foundDown(row, col, word) || foundDiagonal(row, col, word);
    }

    private boolean foundAcross(int row, int col, String word) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            if (col + i >= board[row].length) {
                return false;
            }
            sb.append(board[row][col + i]);
        }
        return sb.toString().equals(word);
    }

    private boolean foundDiagonal(int row, int col, String word) {
        return false;
    }

    private boolean foundDown(int row, int col, String word) {
        return false;
    }
}