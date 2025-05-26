package com.dataStructures.hashing;

import java.util.HashMap;
import java.util.Map;

public class countLetterFrequency {
    public static HashMap<Character, Integer> countLetterFrequency(String sentence) {
        HashMap<Character, Integer> letterCount = new HashMap<>();
        for (char letter : sentence.toCharArray()) {
            // TODO: If the character is a letter, update its count in the HashMap
            // or add it with a count of 1 if it's not already there
            if((letter >= 65 && letter <= 90) || (letter >=95 && letter <= 122)){
                letter = Character.toLowerCase(letter);
                letterCount.put(letter, letterCount.getOrDefault(letter, 0) + 1);
            }else {
                continue;
            }
        }
        return letterCount;
    }

    public static void main(String[] args) {
        String sentence = "Once upon a time in a faraway library";
        // TODO: Call the function with the sentence variable and print the result
        Map<Character, Integer> letterCount = countLetterFrequency(sentence);

        for(Character c: letterCount.keySet()){
            System.out.println(c + ": " + letterCount.get(c));
        }
    }
}
