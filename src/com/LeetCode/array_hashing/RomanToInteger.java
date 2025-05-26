package com.LeetCode.array_hashing;

public class RomanToInteger {

    public static void main(String[] args) {
        String s = "MCMXCIV";
        RomanToInteger rti = new RomanToInteger();
        System.out.println(rti.romanToInt(s));
    }

    public int romanToInt(String s) {
        int sum = 0;
        if (!s.isEmpty() && s.length() <=15) {
            for (int i = s.length() - 1; i >= 0; i--) {
                if(i == s.length() - 1){
                    sum = sum + checkRoman(s.charAt(i));
                }else {
                    if(s.charAt(i) == 'I' && (s.charAt(i+1) == 'V' || s.charAt(i+1) == 'X')){
                        sum = sum - checkRoman(s.charAt(i));
                    }else if(s.charAt(i) == 'X' && (s.charAt(i+1) == 'L' || s.charAt(i+1) == 'C')){
                        sum = sum - checkRoman(s.charAt(i));
                    } else if(s.charAt(i) == 'C' && (s.charAt(i+1) == 'D' || s.charAt(i+1) == 'M')){
                        sum = sum - checkRoman(s.charAt(i));
                    }else{
                        sum = sum + checkRoman(s.charAt(i));
                    }
                }
            }
            return sum;
        }else{
            return 0;
        }
    }

    public int checkRoman(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
