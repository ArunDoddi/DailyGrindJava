/** The secondary diagonal is defined as the diagonal line that starts from the upper-right
 * corner and ends in the bottom-left corner of a square matrix. For example, in a 3x3 matrix,
 * the secondary diagonal elements are matrix[0][2], matrix[1][1], and matrix[2][0].*/
package com.Array;

public class ReflectMatrixOverSecondaryDiagonal {
    public static int[][] reflectOverSecondaryDiagonal(int[][] matrix) {
        int size = matrix.length;
        int[][] newMatrix = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // Reflect over the secondary diagonal
                newMatrix[size - 1 - j][size - 1 - i] = matrix[i][j];
            }
        }
        return newMatrix;
    }

    public static void main(String[] args) {
        // Example square matrix to reflect over the secondary diagonal
        int[][] squareMatrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        // TODO: Call the function on squareMatrix and store the result in transformedMatrix.
        int[][] reflectedMatrix = reflectOverSecondaryDiagonal(squareMatrix);

        // Print the transformed matrix.
        for (int[] is : reflectedMatrix) {
            for (int is2 : is) {
                System.out.print(is2 + " ");
            }
            System.out.println();
        }
    }
}
