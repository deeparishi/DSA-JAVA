package com.deeparishi.javaapp.ZohoExam;

public class PlusMinus {
    public static void main(String[] args) {
        int[] arr = {1, 2, 0, -1, -2};
        double pos = 0;
        double neg = 0;
        double zer = 0;
        String a = "klooiugb7";
        a.matches("bdtrsdo0");

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                neg++;
            } else if (arr[i] > 0) {
                pos++;
            } else if (arr[i] == 0) {
                zer++;
            }
        }

        double posR = pos / arr.length;
        double negR = neg / arr.length;
        double zerR = zer / arr.length;

        System.out.println(String.format("%.6f", posR));
    }
}
