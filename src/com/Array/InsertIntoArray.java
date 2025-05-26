package com.Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertIntoArray {

    // Test
    public static void main(String[] args) {
        int[] original = {1, 2, 3, 5};
        original = Arrays.copyOf(original, original.length + 1);
        System.out.println(Arrays.toString(original));
        int pos = 2;
    }
}
