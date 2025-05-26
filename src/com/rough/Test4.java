package com.rough;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Test4 {
    public static void main(String[] args) {
        String s = "0P";
        System.out.println(isPalindrome(s));
    }

    private static boolean isPalindrome(String s){
        char[] ch = s.toCharArray();

        int f = 0, b = ch.length - 1;

        while (f < b){
            while ((f < ch.length) && !((ch[f] >= 'A' && ch[f] <= 'Z') || (ch[f] >= 'a' &&
                    ch[f] <= 'z') || (ch[f] >= '0' && ch[f] <= '9'))){
                f++;
            }

            while ((b >= 0) && !((ch[b] >= 'A' && ch[b] <= 'Z') || (ch[b] >= 'a' &&
                    ch[b] <= 'z')  || (ch[b] >= '0' && ch[b] <= '9'))){
                b--;
            }

            if(f >= b) return true;

            if(ch[f] != ch[b]){
                if ((ch[f]>='A' &&  ch[f]<='Z')&&(ch[b]>='a' && ch[b]<='z')&&((int)ch[f]==(int)ch[b]-32))
                {}
                else if((ch[b] >= 'A' && ch[b] <= 'Z') && (ch[f] >= 'a' && ch[f] <= 'z')
                && ((int) ch[b] == (int)ch[f] - 32)){}
                else {
                    return false;
                }
            }
            f++; b--;
        }
        return true;
    }
}
