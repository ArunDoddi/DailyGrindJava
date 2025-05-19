package com.LeetCode.two_pointers;

public class ValidPalindrome_14ms {
    public static void main(String[] args) {
//        String s="A man, a plan, a canal: Panama";
        String s = "Damosel, a poem? A carol? Or a cameo pale? (So mad!)";
        s=s.replaceAll("[\\s,:.;()!/~`$%\\\\^&*?\\-@#_{}'\"\\[\\]]", "").toLowerCase();

        System.out.println(s);
        System.out.println(isPalindrome(s));
    }

    private static boolean isPalindrome(String s) {
        int f = 0, b = s.length() - 1;
        while(f < b){
            if(s.charAt(f) != s.charAt(b))
                return false;
            else if(s.charAt(f) == s.charAt(b)) {
                f++;
                b--;
            }
        }
        return true;
    }


}
