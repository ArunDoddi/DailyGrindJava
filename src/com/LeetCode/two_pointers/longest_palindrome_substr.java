package com.LeetCode.two_pointers;

public class longest_palindrome_substr {
    public static void main(String[] args) {
        String s = "cbbd";
        String s1 = "babad";
//        System.out.println(palindrome_substring(s));
        System.out.println(s1.substring(1,2));
        System.out.println(longest_palindrome(s1));
    }

    private static String longest_palindrome(String s){
        int start = 0;
        int end = s.length() - 1;
        int largest = 0;
        String result = "";
        while(start < end){
            System.out.println(s.substring(start, end));
            if(isPalindrome(s.substring(start, end))){
                if((end-start) > largest){
                    largest = end - start;
                    result = s.substring(start, end);
                }
            }else {
                start ++;
                end --;
            }
        }
        return result;
    }

    private static boolean isPalindrome(String s){
        int start = 0;
        int end = s.length() - 1;

        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            else {
                start ++;
                end --;
            }
        }
        return true;
    }
}
