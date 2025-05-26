package com.LeetCode.two_pointers;

import java.util.Arrays;

public class three_sum_closest {
    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        System.out.println(threeSum_closest(nums, 1));
    }

    private static int threeSum_closest(int[] nums, int target){
        Arrays.sort(nums);
        int res = Integer.MAX_VALUE/2;

        for (int i = 0; i < nums.length-2; i++) {
            if (i > 0 && nums[i] == nums[i-1])
                continue;

            int front_pointer = i + 1;
            int back_pointer = nums.length - 1;

            while (front_pointer < back_pointer){
                int total = nums[i] + nums[front_pointer] + nums[back_pointer];
                if (Math.abs(total - target) < Math.abs(res - target))
                    res = total;
                if(total < target){
                    front_pointer++;
                } else if(total > target){
                    back_pointer--;
                }
                else {
                    return total;
                }
            }
        }
        return res;
    }
}
