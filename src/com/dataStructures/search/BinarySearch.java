package com.dataStructures.search;

import java.util.Arrays;

public class BinarySearch {

    private static int binarySearch(int[] arr, int key){
        int low = 0;
        int high = arr.length - 1;
        while (low<=high) {
            int mid = low+(high - low)/2;

            if(arr[mid] == key){
                return mid;
            } else if (key < arr[mid]) {
                high = mid - 1;
            } else if (key > arr[mid]) {
                low = mid + 1;
            }
        }
        return low;
    }

    private static boolean isSorted(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            if(arr[i] < arr[i-1]){
                return  false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,5,6};
        int key = 2;
        if(isSorted(arr)){
            System.out.println(binarySearch(arr, key));
        }
        else {
            arr = sortArr(arr);
            System.out.println(Arrays.toString(arr));
            System.out.println(binarySearch(arr, key));
        }
    }

    private static int[] sortArr(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j = j - 1;
            }
            arr[j+1] = key;
        }
        return arr;
    }
}
