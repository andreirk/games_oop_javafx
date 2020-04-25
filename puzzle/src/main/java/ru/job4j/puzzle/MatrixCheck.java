package ru.job4j.puzzle;

public class MatrixCheck {
    public static boolean monoHorizontal(char[][] board, int row) {
        boolean result = true;
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] != 'X') {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean monoHorizontal(int[][] board, int row, int sign) {
        boolean result = true;
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] != sign) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean monoVertical(char[][] board, int column) {
        boolean result = true;
        for (int i = 0; i < board.length; i++) {
            if (board[i][column] != 'X') {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean monoVertical(int[][] board, int column, int sing) {
        boolean result = true;
        for (int i = 0; i < board.length; i++) {
            if (board[i][column] != sing) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static char[] extractDiagonal(char[][] board) {
        char[] rsl = new char[board.length];
        for (int i = 0; i < board.length; i++) {
            rsl[i] = board[i][i];
        }
        return rsl;
    }
    public static int[] extractDiagonal(int[][] board) {
        int[] rsl = new int[board.length];
        for (int i = 0; i < board.length; i++) {
            rsl[i] = board[i][i];
        }
        return rsl;
    }

    public static boolean isWin(char[][] board) {
        boolean result = false;
        char[] diagonal = MatrixCheck.extractDiagonal(board);
        int index = FindLoop.indexOf(diagonal, 'X');
        if (index == -1) {
            return false;
        }
        if (monoHorizontal(board, index) || monoVertical(board, index)) {
            result = true;
        }
        return result;
    }

    public static boolean isWin(char[][] board, char symb) {
        boolean result = false;
        char[] diagonal = MatrixCheck.extractDiagonal(board);
        int index = FindLoop.indexOf(diagonal, symb);
        if (index == -1) {
            return false;
        }
        if (monoHorizontal(board, index) || monoVertical(board, index)) {
            result = true;
        }
        return result;
    }

 public static boolean isWin(int[][] board, int sign) {
        boolean result = false;
        int[] diagonal = MatrixCheck.extractDiagonal(board);
        int index = FindLoop.indexOf(diagonal, sign);
        if (index == -1) {
            return false;
        }
        if (monoHorizontal(board, index, sign) || monoVertical(board, index, sign)) {
            result = true;
        }
        return result;
    }

}
