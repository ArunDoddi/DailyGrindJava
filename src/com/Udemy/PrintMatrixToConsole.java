package com.Udemy;

import java.util.Arrays;

public class PrintMatrixToConsole {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5,},
                {6, 7},
                {8, 9, 10}
        };

        for(int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
    }

}
