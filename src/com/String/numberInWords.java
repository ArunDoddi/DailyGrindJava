package com.String;

import java.util.Scanner;

public class numberInWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(integerToWords(n));
    }

    private static String integerToWords(int n) {
        String[] words = new String[]{"Million", "Thousand", "Hundred", "Ninety", "Eighty", "Seventy", "Sixty",
                "Fifty", "Forty", "Thirty", "Twenty", "Nineteen","Eighteen","Seventeen","Sixteen","Fifteen","Fourteen",
                "Thirteen","Twelve","Eleven","Ten", "Nine", "Eight", "Seven","Six","Five","Four","Three", "Two", "One"
        };
        int[] numbers = new int[]{1000000,1000, 100, 90, 80, 70, 60, 50, 40, 30, 20, 19, 18, 17, 16, 15, 14, 13, 12,
                11, 10, 9, 8 ,7,6,5,4,3,2,1
        };
        return integerToWords(n, words, numbers);
    }
    private static String integerToWords(int n, String[] words, int[] numbers){
        StringBuilder res = new StringBuilder();
        if(String.valueOf(n).length()>7){
            return "Integer out of range to convert into words";
        }else{
            for(int i = 0; i < words.length; i++){
                int number = numbers[i];
                String word = words[i];

                if(n >= number){
                     if(n>=100){
                         res.append(integerToWords(n/number, words, numbers)).append(" ");
                     }
                     res.append(word);

                    if (n % number > 0)
                        res.append(" ").append(integerToWords(n % number, words, numbers));

                    return res.toString();
                }
            }
        }
        return res.toString();
    }
}
