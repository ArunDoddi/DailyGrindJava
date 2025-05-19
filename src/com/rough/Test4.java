package com.rough;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Test4 {
    public static void main(String[] args) {
        int[] array = new int[]{2,3,4};
        int[] result = Arrays.stream(array).map(num -> (Arrays.stream(array).reduce(1, (subTotal, element) -> subTotal * element))/num).toArray();
        System.out.println(Arrays.toString(result));
    }
}
