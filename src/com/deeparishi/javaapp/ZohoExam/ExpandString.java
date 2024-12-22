package com.deeparishi.javaapp.ZohoExam;

public class ExpandString {
    public static void main(String[] args) {

        String a = "a1b2c3d4e5";
        System.out.println(expandString(a));
        printPattern("12345");
    }

    public static void printPattern(String input) {
        int n = input.length();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j || i + j == n - 1) {
                    System.out.print(input.charAt(n - 1 - i));
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static String expandString(String input) {
        StringBuilder result = new StringBuilder();
        char current = '\0';
        int repeat = 0;

        for (char a : input.toCharArray()) {
            if (Character.isLetter(a)) {
                if (current != '\0') {
                    for (int i = 0; i < repeat; i++) {
                        result.append(current);
                    }
                }
                current = a;
                repeat = 0;
            } else if (Character.isDigit(a)) {
                repeat = repeat * 10 + Character.getNumericValue(a);
            }
        }
        if (current != '\0') {
            for (int i = 0; i < repeat; i++) {
                result.append(current);
            }
        }
        return result.toString();
    }
}


