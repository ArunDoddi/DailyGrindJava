package com.LeetCode.merge_intervals;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class inserted_interval {
    public static void main(String[] args) {
//        int[][] arr1 = {
//                {1,3},
//                {6,9}
//        };
        int[][] arr2 = {
                {1,2},{3,5},{6,7},{8,10},{12,16}};
        int[][] arr3 = {
                {1, 5}
        };
        int[][] arr4 = {
                {1,5}
        };
//        int[] newInterval1 = {2, 5};
        int[] newInterval2 = {4, 8};
//        int[] newInterval3 = {2, 7};
        int[] newInterval4 = {2, 3};
//        System.out.println(Arrays.deepToString(insert(arr1, newInterval1)));
        System.out.println(Arrays.deepToString(insert(arr2, newInterval2)));
//        System.out.println(Arrays.deepToString(insert(arr3, newInterval3)));
        System.out.println(Arrays.deepToString(insert(arr4, newInterval4)));
    }

    private static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new LinkedList<>();

        int i = 0;
        int n = intervals.length;

        // 1. Add all intervals ending before newInterval starts
        while (i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // 2. Merge overlapping intervals with newInterval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        result.add(newInterval); // Add the merged interval

        // 3. Add all intervals after newInterval ends
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }
}
