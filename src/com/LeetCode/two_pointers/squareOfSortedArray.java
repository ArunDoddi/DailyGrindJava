package com.LeetCode.two_pointers;

import java.util.Arrays;

public class squareOfSortedArray {
    public static void main(String[] args) {
        int[] nums = {-7,-3,2,3,11};
        System.out.println(Arrays.toString(sort_and_square(nums)));
    }

    private static int[] sort_and_square(int[] nums) {
        int back_pointer = nums.length - 1;
        int insert_pointer = nums.length - 1;
        int front_pointer = 0;
        int[] resultArray = new int[nums.length];
        while (front_pointer <= back_pointer) {
            if((nums[front_pointer] * nums[front_pointer]) > (nums[back_pointer] * nums[back_pointer])){
                resultArray[insert_pointer--] = (nums[front_pointer] * nums[front_pointer]);
                front_pointer++;
            } else{
                resultArray[insert_pointer--] = (nums[back_pointer] * nums[back_pointer]);
                back_pointer--;
            }
        }
        return resultArray;
    }
}
