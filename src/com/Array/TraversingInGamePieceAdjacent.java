package com.Array;

import java.util.ArrayList;
import java.util.List;

class TraversingInGamePieceAdjacent {
    public static boolean evaluateMove(char[][] board, int row, int col) {
        // TODO: Check if a move to the given cell is possible; write a condition to check if the cell is empty.
        // TODO: Check if at least one neighboring cell is empty (not diagonally).
        if(board[row][col] == 'E'){
            return (
                    (row > 0 && board[row -1 ][col] == 'E') ||
                            (row < board.length - 1 && board[row + 1][col] == 'E') ||
                            (col > 0 && board[row][col - 1] == 'E') ||
                            (col < board[0].length - 1 && board[row][col + 1] == 'E')
            );
        }
        return false;
    }

    public static void main(String[] args) {
        // Assuming a constant 2D array representing a board
        char[][] board = {
                {'P', 'E', 'E', 'P'},
                {'E', 'P', 'E', 'P'},
                {'P', 'E', 'P', 'P'},
                {'P', 'E', 'P', 'E'}
        };

        // TODO: Write a loop or loops to find all valid move positions and display them.

        List<int[]> positionList = new ArrayList<>();

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (evaluateMove(board, row, col)) {
                    positionList.add(new int[]{row, col});
                }
            }
        }

        for (int[] is : positionList) {
            System.out.println("(" + is[0] + ", " + is[1] + ")");
        }
    }
}