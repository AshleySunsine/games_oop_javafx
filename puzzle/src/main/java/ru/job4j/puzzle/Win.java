package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        for (int index = 0; index < board.length; index++) {
            if (board[index][index] == 1) {
                return (checkHorizontal(board, index) || checkVertical(board, index));
                }
            }
        return false;
        }

    public static boolean checkHorizontal(int[][] board, int index) {
        for (int cell = 0; cell < board[index].length; cell++) {
            if (board[index][cell] != 1) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkVertical(int[][] board, int index) {
        for (int row = 0; row < board[index].length; row++) {
            if (board[row][index] != 1) {
                return false;
            }
        }
        return true;
    }


}
