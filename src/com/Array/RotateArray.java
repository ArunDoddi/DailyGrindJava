package com.Array;

import java.util.Arrays;

public class RotateArray {

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int num_of_places = 12;
        rotateArray(arr, num_of_places);
    }

    private static void rotateArray(int[] arr, int d) {
        int n = arr.length;

        d %= n;

        reverse(arr, 0, d-1);

        reverse(arr, d, n-1);

        reverse(arr, 0, n-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void reverse(int[] arr, int start, int end) {
        while(start < end){
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start+=1;
            end-=1;
        }
    }
}
