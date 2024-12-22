package com.deeparishi.javaapp.ZohoExam;

import java.util.Scanner;

public class firstSecondSecondFirst {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        char[] arr = a.toCharArray();
        for (int i = 0; i < arr.length; i += 2) {
            if (arr.length - 1 == i) {
                break;
            }
            if (i == 0 || i % 2 == 0) {
                char temp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = temp;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
    }
    // ODD
    //  I/P ---------------  SWAGY
    //  O/P ---------------- WSGAY

    //EVEN
    // I/P ----------------- RISHIS
    // O/P ----------------- IRHSSI
}
