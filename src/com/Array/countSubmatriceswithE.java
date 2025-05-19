package com.Array;

public class countSubmatriceswithE {
    public static int countSubmatricesWithE(char[][] board) {
        // TODO: Initialize a count variable to keep track of 3x3 submatrices with 'E's in all four corners
        int count  = 0;

        // TODO: Use a nested loop to go through each element that can be the top-left corner of a 3x3 submatrix
        if(board.length > 3 && board[0].length > 3){
            for (int row = 0; row < board.length; row++) {
                for (int col = 0; col < board[0].length; col++) {
                    if (col + 2 < board[0].length && row + 2 < board.length)
                        if ((board[row][col] == 'E') && (board[row + 2][col] == 'E') && (board[row + 2][col + 2] == 'E') && board[row][col + 2] == 'E') {
                            count += 1;
                        }
                }
            }
        }

        // TODO: Check if the current 3x3 submatrix has 'E's in all four corners
        // If it does, increment the count

        // TODO: Return the count of submatrices with 'E's in all four corners
        return count;
    }

    public static void main(String[] args) {
        // TODO: Define a 2D array 'board' with some 'E's and 'P's, representing empty and piece positions respectively
        char[][] board = {
                {'E', 'P', 'E', 'E'},
                {'P', 'E', 'P', 'E'},
                {'E', 'P', 'E', 'P'},
                {'E', 'E', 'P', 'E'}
        };


        // TODO: Call the function to count the submatrices and output the result
        System.out.println(countSubmatricesWithE(board));
    }
}
