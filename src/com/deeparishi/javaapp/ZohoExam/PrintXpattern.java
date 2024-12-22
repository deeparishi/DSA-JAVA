package com.deeparishi.javaapp.ZohoExam;

public class PrintXpattern {
    public static void main(String[] args) {
        print1("12345");
    }

    public static void print1(String a) {
        int len = a.length();

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j) {
                    System.out.print(a.charAt(i));
                } else if (i + j == len - 1) {
                    System.out.print(a.charAt(len - 1 - i));
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }


    public static void print(String a) {
        int len = a.length();

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i == j || i + j == len - 1) {
                    System.out.print(a.charAt(i));
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
