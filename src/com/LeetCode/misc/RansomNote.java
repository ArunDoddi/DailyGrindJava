package com.LeetCode.misc;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public static void main(String[] args) {
        String ransomNote = "aab";
        String magazine = "baa";
        System.out.println(canConstruct(ransomNote, magazine));
    }

    private static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < magazine.length(); i++) {
            if(!hm.containsKey(magazine.charAt(i))){
                hm.put(magazine.charAt(i), 1);
            } else{
                hm.put(magazine.charAt(i), hm.get(magazine.charAt(i))+1);
            }
        }

        int i = 0;
        while (i < ransomNote.length()){
            if (hm.containsKey(ransomNote.charAt(i)) && hm.get(ransomNote.charAt(i))!=0){
                hm.put(ransomNote.charAt(i), hm.get(ransomNote.charAt(i))-1);
                i++;
            }
            else {
                return false;
            }
        }
        return true;
    }
}
