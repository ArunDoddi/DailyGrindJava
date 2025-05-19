package com.String;

import java.util.Arrays;

public class Longest_Substring {

    public int lengthOfLongestSubstring(String s){
        int res = 0;
        int j = 0;
        int[] vocab = new int[128];
        for(int i =0; i<s.length();i++){
            char ch = s.charAt(i);
            j = Math.max(vocab[ch],j);
            System.out.println(j + " " + vocab[ch]);
            res = Math.max(res, i-j+1);
            System.out.println(res);
            vocab[ch]= i+1;
            System.out.println(Arrays.toString(vocab));
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "pwwkew";
        Longest_Substring ls = new Longest_Substring();
        System.out.println(ls.lengthOfLongestSubstring(s));
    }
}
