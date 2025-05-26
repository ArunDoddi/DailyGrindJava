package com.Array;

public class GetSecondLargestOfArray {

    public static void main(String[] args) {
        int[] arr = {12, 35, 1, 10, 34, 1};
        System.out.println(getSecondLargest(arr));
    }

    private static int getSecondLargest(int[] arr) {
        int sizeOfArr = arr.length;

        int largest = -1, secondLargest = -1;

        for(int i = 0; i <sizeOfArr; i++){

            if(arr[i] > largest){
                secondLargest = largest;
                largest = arr[i];
            }

            else if(arr[i] < largest && arr[i] > secondLargest){
                secondLargest = arr[i];
            }
        }

        return secondLargest;
    }
}
