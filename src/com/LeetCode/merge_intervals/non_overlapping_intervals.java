package com.LeetCode.merge_intervals;

import java.util.Arrays;

public class non_overlapping_intervals {
    public static void main(String[] args) {
        int[][] arr = {
                {1,2},
                {2,3},
                {3,4},
                {1,3}
        };
        int[][] arr1 = {
                {1,2},
                {1,2},
                {1,2}
        };

        int[][] arr2 = {
                {1,100},
                {1, 11},
                {2, 12},
                {11, 22}
        };
        System.out.println(eraseOverlapIntervals(arr));
        System.out.println(eraseOverlapIntervals(arr2));
    }

    private static int eraseOverlapIntervals(int[][] intervals) {
        int i = 1, n = intervals.length, count = 0;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0],b[0]));
        System.out.println(Arrays.deepToString(intervals));
        while (i < n && (i > 0 && intervals[i][0] == intervals[i-1][0])){
            count +=1;
            i++;
        }
        return count;
    }
}
