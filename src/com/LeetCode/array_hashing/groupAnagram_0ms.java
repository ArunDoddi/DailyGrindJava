package com.LeetCode.array_hashing;

import java.util.*;

public class groupAnagram_0ms {
    private static List<List<String>> groupAnagrams(String[] strs) {
        return new AbstractList<List<String>>() {
            List<List<String>> ans;

            public List<String> get(int index) {
                if (ans == null) init();
                return ans.get(index);
            }

            public int size() {
                if (ans == null) init();
                return ans.size();
            }

            public void init() {
                Map<String, List<String>> hm = new HashMap<>();

                for (String s : strs) {
                    char[] count = new char[26];
                    for (char c : s.toCharArray()) {
                        count[c - 'a']++;
                    }
                    String key = new String(count);
                    System.out.println(key);
                    hm.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
                }

                ans = new ArrayList<>(hm.values());
            }
        };
    }

    public static void main(String[] args) {
        String[] strings = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strings));
    }
}
