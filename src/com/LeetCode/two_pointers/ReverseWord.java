package com.LeetCode.two_pointers;

public class ReverseWord {
    public static void main(String[] args) {
//        String input = "The sky is blue";
//        String input = "  hello world  ";
//        String input = "a good   example";
        String input = "EPY2giL";
        System.out.println(reverseOfString(input));
    }

    private static String reverseOfString(String s) {
        int back_pointer = s.length() - 1;
        StringBuilder newString = new StringBuilder();
        for (int i = s.length() - 1; i >= 0 ; i--) {
            if(s.charAt(i) == ' ' && (i < s.length() - 1 && s.charAt(i+1) != ' ')){
                appendString(newString, i, back_pointer, s);
                back_pointer = i - 1;
            } else if((s.charAt(i) >= 65 && s.charAt(i) <= 90) || (s.charAt(i) >= 97 && s.charAt(i) <= 122)
            || (s.charAt(i) >= 48 && s.charAt(i) <= 57)){
                if (i == 0) {
                    newString.append(' ');
                    appendString(newString, i, back_pointer, s);
                    back_pointer = i;
                }
            }
            else {
                back_pointer--;
            }
        }
        return newString.substring(1, newString.length());
    }

    private static void appendString(StringBuilder newString, int i, int back_pointer, String input){
        while (i <= back_pointer) {
            newString.append(input.charAt(i));
            i++;
        }
    }
}
