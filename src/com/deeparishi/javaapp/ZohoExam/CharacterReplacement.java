package com.deeparishi.javaapp.ZohoExam;

import java.util.Scanner;

public class CharacterReplacement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        System.out.println(checkDuplicate(a));

    }

    public static String checkDuplicate(String a) {
        StringBuilder st = new StringBuilder();
        char[] ch = a.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            char dup = ch[i];
            boolean isDuplicate = false;
            for (int j = 0; j < i; j++) {
                if (dup == ch[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (isDuplicate) {
                char replace = getReplacement(dup);
                st.append(replace);
            } else {
                st.append(dup);
            }
        }
        return st.toString();
    }

    private static char getReplacement(char a) {

        if (Character.isDigit(a)) {
            int digit = Character.getNumericValue(a);
            if (digit < 9) {
                return (char) (digit + '0' + 1);
            } else {
                return '0';
            }
        }
        if (Character.isLowerCase(a)) {
            if (a == 'z') {
                return 'a';
            } else {
                return (char) (a + 1);
            }
        }
        if (Character.isUpperCase(a)) {
            if (a == 'Z') {
                return 'A';
            } else {
                return (char) (a + 1);
            }
        }
        return a;
    }
}
