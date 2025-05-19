package com.LeetCode.array_hashing;

import java.util.*;

public class groupAnagram {
    public static void main(String[] args) {
        String[] strings = {"eat", "tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strings));
    }

    private static List<List<String>> groupAnagrams(String[] strings) {
        HashMap<String, List<String>> hm = new HashMap<>();
        for(String s: strings){
            char[] chArr = s.toCharArray();
            Arrays.sort(chArr);
            String sortedWord = new String(chArr);

            hm.computeIfAbsent(sortedWord, k -> new ArrayList<>()).add(s);
        }
        List<List<String>> result = new ArrayList<>(hm.values());
        result.sort(Comparator.comparingInt(List::size));
        return result;
    }
}
