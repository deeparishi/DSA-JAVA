package com.deeparishi.javaapp.ZohoExam;

import java.util.HashMap;

public class Panagram {
    public static void main(String[] args) {
        String a = "abc defGhi JklmnOP QRStuv wxyz";
        String b = a.replaceAll(" ", "");
        System.out.println(checkIfPangram(b.toLowerCase()));
    }

    public static boolean checkIfPangram(String sentence) {
        //sentence.trim();
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < sentence.length(); i++) {
            map.put(sentence.charAt(i), 1);
        }

        if (map.size() == 26) {
            return true;
        }

        return false;
    }
}


