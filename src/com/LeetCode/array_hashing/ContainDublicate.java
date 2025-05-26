package com.LeetCode.array_hashing;

import java.util.HashSet;

public class ContainDublicate {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(containsDuplicate(nums));
    }

    private static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int num : nums) {
            if (hs.contains(num)) {
                return false;
            }
            hs.add(num);
        }
        return true;
    }
}
