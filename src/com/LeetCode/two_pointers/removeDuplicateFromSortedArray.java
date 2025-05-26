package com.LeetCode.two_pointers;

public class removeDuplicateFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(removeDuplicateNumbers(nums));
    }

    private static int removeDuplicateNumbers(int[] nums) {
        int i  = 0;
        for(int j = 1; j<nums.length;j++){
            if(nums[j] != nums[i]){
                i++;
                nums[i] = nums[j];
            }
        }
        return ++i;
    }
}
