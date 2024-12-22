package com.deeparishi.javaapp.ZohoExam;

public class countingSortLexicographical {
    public static void main(String[] args) {
        String input = "bcaeedcd";
        String sorted = countingSortLexicographical(input);
         System.out.println("Sorted string: " + sorted);

    }

    public static String countingSortLexicographical(String input) {


        int[] count = new int[26]; // We have 26 lowercase alphabets (a-z)
        char[] output = new char[input.length()];

        // Count the occurrences of each character in the input
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            count[c - 'a']++;
        }

        // Build the sorted output array
        int index = 0;
        for (char c = 'a'; c <= 'z'; c++) {
            while (count[c - 'a'] > 0) {
                output[index++] = c;
                count[c - 'a']--;
            }
        }

        // Convert the sorted array back to a string
        return new String(output);
    }
}




