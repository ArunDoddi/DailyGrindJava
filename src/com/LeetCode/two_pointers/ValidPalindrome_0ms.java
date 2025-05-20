package com.LeetCode.two_pointers;

import java.util.Arrays;

public class ValidPalindrome_0ms {
    public static void main(String[] args) {
        String s = "Damosel, a poem? A carol? Or a cameo pale? (So mad!)";
        System.out.println(isPalindrome_0ms(s));
    }

    private static boolean isPalindrome_0ms(String s) {
        char[] ch = s.toCharArray();
        System.out.println(Arrays.toString(ch));

        int i = 0, j = ch.length -1;

        while (i<j)
        {
            while (i<ch.length && !((ch[i]>='A' &&  ch[i]<='Z') || (ch[i]>='0' && ch[i]<='9') || (ch[i]>='a' && ch[i]<='z')))
            {
                i++;
            }
            while (j>=0 && !((ch[j]>='A' &&  ch[j]<='Z') || (ch[j]>='0' && ch[j]<='9') || (ch[j]>='a' && ch[j]<='z')))
            {
                j--;
            }

            if (i>=j) return true;

            if (ch[i]!=ch[j]){
                if ((ch[i]>='A' &&  ch[i]<='Z')&&(ch[j]>='a' && ch[j]<='z')&&((int)ch[i]==(int)(ch[j]-32)))
                {}
                else if ((ch[j]>='A' &&  ch[j]<='Z')&&(ch[i]>='a' && ch[i]<='z')&&((int)ch[j]==(int)(ch[i]-32)))
                {}
                else
                    return false;
            }
            i++; j--;
        }
        return true;
    }


}
