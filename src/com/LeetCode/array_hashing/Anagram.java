package com.LeetCode.array_hashing;

import java.util.Arrays;

public class Anagram {
    public static void main(String[] args) {
        String s = "rat";
        String t = "car";
        System.out.println(checkAnagram(s,t));
    }

    private static boolean checkAnagram(String s, String t) {
        s = sort(s);
        t = sort(t);
        if(s.equals(t)){
            return true;
        }
        return false;
    }

    private static String sort(String s) {
        char[] chArr = s.toCharArray();
        Arrays.sort(chArr);
        return new String(chArr);
    }
}
