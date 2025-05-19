package com.Udemy;

import java.util.Arrays;
import java.util.Scanner;

public class AmountOfWords {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please, enter any text: ");

        String userInput = sc.nextLine();
        int minLength = 4;
        int amountOfWords = getWordsAmount(userInput, minLength);

        System.out.println("Amount of words in your text: " + amountOfWords);
    }

    public static int getWordsAmount(String text, int minLength) {
        String[] wordsArray = text.split(" ");
        String[] filteredWords = Arrays.stream(wordsArray).filter(word -> word.length() >= minLength).toArray(String[]::new);
        System.out.println(Arrays.toString(filteredWords));
        return wordsArray.length;
    }
}