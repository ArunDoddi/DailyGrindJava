package com.LeetCode.prefix;

import java.util.Arrays;

public class prefix_sum {
    public static void main(String[] args) {
        int[] arr = {10,20,6,23,43};
        System.out.println(Arrays.toString(pre_sum(arr)));
        System.out.println(rangeSum(1, 3, pre_sum(arr)));
        System.out.println(rangeSum(2, 4, pre_sum(arr)));
    }

    private static int[] pre_sum(int[] arr) {
        int[] prefix = new int[arr.length];
        prefix[0] = arr[0];
        for (int i = 1; i < prefix.length; i++) {
            prefix[i] = prefix[i-1] + arr[i];
        }
        return prefix;
    }

    private static int rangeSum(int left, int right, int[] arr) {
        if (left == 0){
            return arr[right];
        }

        return arr[right] - arr[left -1];
    }
}
