package com.rough;

import java.util.ArrayList;
import java.util.List;

class Test {
    // The trekPath function should go here
    // TODO: Define the trekPath function that takes the elevationMap, startRow, and startCol as parameters.
    private static List<Integer> trekPath(int[][] mountain, int row, int col){
        int rows = mountain.length;
        int cols = mountain[0].length;

        int[][] directions = {
                {1, 0},
                {0, 1},
                {0, -1},
                {-1, 0}
        };

        // TODO: Initialize the path with the starting position's elevation.
        int currentMax = mountain[row][col];

        List<Integer> highestPeakMountains = new ArrayList<>();
        highestPeakMountains.add(mountain[row][col]);
        // TODO: Implement the loop to find the path through higher elevations.
        for(int[] direction : directions){
            row = direction[0];
            col = direction[1];

            if(row >= 0 && row < rows && col >= 0 && col < cols && mountain[row][col] > currentMax){
                highestPeakMountains.add(mountain[row][col]);
            }
        }
        return highestPeakMountains;
    }


    public static void main(String[] args) {
        int[][] mountain = {
                {1, 2, 3},
                {2, 3, 4},
                {3, 5, 6}
        };
        Test sol = new Test();
        List<Integer> result = trekPath(mountain, 1, 1);
        for (int height : result) {
            System.out.print(height + " ");
        }
    }
}