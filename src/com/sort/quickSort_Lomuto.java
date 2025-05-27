/* This Lomuto partition algorithm starts from the left most algorithm and keep track of the index of smaller (or equal) elements as i . While traversing, if we find a smaller
   element, we swap the current element with arr[i]. Otherwise, we ignore the current element.
*/
package com.sort;

import java.util.Arrays;

public class quickSort_Lomuto {
    public static void main(String[] args) {
        int[] arr = {47, 83, 12, 65, 29, 91, 38, 56, 7, 74, 18, 99, 33, 60, 22};
        //int[] arr = {10, 7, 8, 9, 1, 5};
        int low = 0;
        int high = arr.length - 1;
        quickSort(arr, low, high);
        System.out.println(Arrays.toString(arr));
    }

    private static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i  = low - 1;
        for (int j = low; j <= high -1; j++) {
            if(arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i +1, high);
        return i+1;
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

    private static void quickSort(int[] arr, int low, int high){
        if(low < high){
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }
}
