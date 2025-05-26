package com.LeetCode.two_pointers;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class three_sum {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }

    private static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            if(i > 0 && nums[i] == nums[i - 1])
                continue;

            int front_pointer = i + 1;
            int back_pointer = nums.length - 1;

            while (front_pointer < back_pointer){
                int total = nums[i] + nums [front_pointer] + nums[back_pointer];

                if(total > 0){
                    back_pointer--;
                } else if (total < 0) {
                    front_pointer++;
                } else{
                    res.add(List.of(nums[i], nums[front_pointer], nums[back_pointer]));
                    front_pointer++;

                    while (nums[front_pointer] == nums[front_pointer - 1] && front_pointer < back_pointer) {
                        front_pointer += 1;
                    }
                }
            }
        }
        return res;
    }
}
