package com.LeetCode.two_pointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class twoSum {
    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(two_Sum(arr, target)));
    }

    public static int[] two_Sum(int[] arr, int target){
        Map<Integer, Integer> hm = new HashMap<>();

        for(int i = 0; i < arr.length; i++){

            int complement = target - arr[i];

            if(hm.containsKey(complement)) {
                return new int[] {hm.get(complement), i};
            }

            hm.put(arr[i], i);
        }
        return new int[]{};
    }
}
