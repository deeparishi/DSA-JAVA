package com.deeparishi.javaapp.ZohoExam;

public class FindSubString {
    public static void main(String[] args) {
        String string1 = "testing123";
        String string2 = "123";

        int op = -1;
        for (int i = 0; i <= string1.length() - string2.length(); i++) {
            if (string1.substring(i, i + string2.length()).equals(string2)) {
                op = i;
                break;
            }
        }

        System.out.println(op);
    }
}
