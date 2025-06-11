package com.LeetCode.prefix;

public class longest_com_prefix {

    public static void main(String[] args) {
        String[] strArray = {"flowers", "flank", "fleet"};
        System.out.println(longest_prefix(strArray));
    }

    private static String longest_prefix(String[] strArray) {
        for (int i = 0; i < strArray[0].length(); i++) {
            char ch = strArray[0].charAt(i);
            for (int j = 1; j < strArray.length; j++) {
                if(i > strArray.length || strArray[j].charAt(i) != ch){
                    return strArray[0].substring(0, i);
                }
            }
        }
        return strArray[0];
    }

}
