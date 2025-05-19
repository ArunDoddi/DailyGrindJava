package com.String;

import java.util.LinkedList;
import java.util.List;

public class Longest_Substring_ver1 {

    public int lengthOfLongestSubstring(String s){
        int res = 0;
        List<Character> ls = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ls.contains(ch)){
                ls.subList(0, ls.indexOf(ch) + 1).clear();
            }
            ls.add(ch);
            res = Math.max(res, ls.size());
        }
        return res;
    }
    public static void main(String[] args) {
        String s = "abcabcbedfb";
        Longest_Substring_ver1 ls = new Longest_Substring_ver1();
        System.out.println(ls.lengthOfLongestSubstring(s));
    }
}
