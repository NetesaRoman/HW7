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
        String result;
        String guess;
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado", "broccoli", "carrot", "cherry",
                "garlic", "grape", "melon", "leak", "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut",
                "pear", "pepper", "pineapple", "pumpkin", "potato"};
        char[] resultArray = {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'};

        int targetWordIndex = (int) (Math.random() * words.length);

        System.out.println("\n--------------------GAME------------------------------");
        do {

            System.out.println("Guess the word (up to 15 letters)");
            guess = scanner.nextLine();

            int loopLength = Math.min(words[targetWordIndex].length(), guess.length());

            for (int i = 0; i < loopLength; i++) {
                if (words[targetWordIndex].charAt(i) == guess.charAt(i) && resultArray[i] == '#') {
                    resultArray[i] = guess.charAt(i);

                }
            }

            result = new String(resultArray);

            if (result.substring(0, words[targetWordIndex].length()).equals(words[targetWordIndex])) {
                break;
            }
            System.out.println(resultArray);

        } while (true);

        System.out.println("You win! your word " + result.substring(0, words[targetWordIndex].length()));
    }

    public static int findSymbolOccurance(String string, char c) {
        int i;
        int counter = 0;

        for (i = 0; i < string.length(); i++) {
            if (string.charAt(i) == c) {
                counter++;
            }
        }

        return counter;
    }

    public static int findWordPosition(String target, String word) {
        return target.indexOf(word, 0);
    }

    public static String stringReverse(String string) {
        return new StringBuilder(string).reverse().toString();
    }

    public static boolean isPalindrome(String string) {
        int start = 0;
        int end = string.length() - 1;
        String str = string.toLowerCase();

        while (start < end) {
            if (str.charAt(start) != str.charAt(end))
                return false;

            start++;
            end--;

        }
        return true;
    }


}