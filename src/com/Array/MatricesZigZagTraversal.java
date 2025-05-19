package com.Array;

public class MatricesZigZagTraversal {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        int[] result = columnTraverse(matrix);
        int[] reverseTraverseResult = reverseTraverse(matrix);
        for(int num: result){
            System.out.print(num + " ");
        }
        System.out.println();
        for (int num: reverseTraverseResult){
            System.out.print(num + " ");
        }
    }

    public static int[] columnTraverse(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        System.out.println(rows + " " + cols);
        String direction = "up";
        int row = rows - 1;
        int col = cols - 1;
        System.out.println(row + " " + col);
        int[] output = new int[rows * cols];
        int index = 0;

        while (index < rows * cols){
            output[index ++] = matrix[row][col];

            if(direction.equals("up")){
                if(row-1 < 0){
                    direction = "down";
                    col -= 1;
                }else {
                    row -= 1;
                }
            }else {
                if(row+1 == rows){
                    direction = "up";
                    col -= 1;
                }else{
                    row += 1;
                }
            }
        }
        return output;
    }

    public static int[] reverseTraverse(int[][] matrix){
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] output = new int[rows * cols];
        int index = 0;
        for(int row = rows - 1; row >= 0; row--){
            for(int col = cols -1; col >= 0; col--){
                output[index ++] = matrix[row][col];
            }
        }
        return output;
    }
}
