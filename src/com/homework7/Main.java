package com.homework7;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println(findSymbolOccurance("aaabbbssfr", 's'));
        System.out.println(findWordPosition("HappyBirthDay", "BirthDay"));
        System.out.println(stringReverse("abc"));
        System.out.println(isPalindrome("avva"));
        System.out.println(isPalindrome("abc"));

        Scanner scanner = new Scanner(System.in);

        String guess;
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};

        StringBuilder result = new StringBuilder("###############");
        int targetWordIndex = (int) (Math.random() * words.length);

        System.out.println("\n--------------------GAME------------------------------");
        do {

            System.out.println("Guess the word (up to 15 letters)");
            guess = scanner.nextLine();

            if (guess != null) {
                int loopLength = Math.min(words[targetWordIndex].length(), guess.length());

                for (int i = 0; i < loopLength; i++) {
                    if (words[targetWordIndex].charAt(i) == guess.charAt(i) && result.charAt(i) == '#') {
                        result.setCharAt(i, guess.charAt(i));

                    }
                }
            }


            if (result.substring(0, words[targetWordIndex].length()).equals(words[targetWordIndex])) {
                break;
            }
            System.out.println(result);

        } while (true);

        System.out.println("You win! your word " + result.substring(0, words[targetWordIndex].length()));
    }

    public static int findSymbolOccurance(String string, char c) {
        if (string != null) {
            int i;
            int counter = 0;

            for (i = 0; i < string.length(); i++) {
                if (string.charAt(i) == c) {
                    counter++;
                }
            }

            return counter;
        } else {
            return -1;
        }
    }

    public static int findWordPosition(String target, String word) {
        if (target != null && word != null)
            return target.indexOf(word, 0);
        return -1;
    }

    public static String stringReverse(String string) {
        if (string != null)
            return new StringBuilder(string).reverse().toString();
        return "Error!";
    }

    public static boolean isPalindrome(String string) {
        if (string != null)
            return string.equals(stringReverse(string));
        return false;
    }


}