package com.Array;

import java.util.Arrays;

public class MoveZerosToLast {

    public static void main(String[] args) {
        int[] arr = {1,2,0,4,3,0,5,0};
        System.out.println(Arrays.toString(moveZerosToLast(arr)));
    }

    private static int[] moveZerosToLast(int[] arr) {
        int n = arr.length - 1, count = 0;
        for(int i = 0; i <= n; i++){
                if(arr[i] != 0){
                    int temp = arr[i];
                    arr[i] = arr[count];
                    arr[count] = temp;
                    count ++;
                }
        }

        return arr;
    }
}
