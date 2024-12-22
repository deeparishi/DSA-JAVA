package com.deeparishi.javaapp.ZohoExam;

import java.util.ArrayList;

public class SumOrProduct {
    public static void main(String[] args) {


        int arr[] = {120, 24, 71, 10, 59};

        int sum = 0;
        int prod = 1;
        ArrayList<Integer> a = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            while (val != 0) {
                int rev = val % 10;
                sum += rev;
                prod *= rev;
                val /= 10;
            }
            if (sum > prod)
                a.add(sum);
            else if (prod > sum)
                a.add(prod);
            sum = 0;
            prod = 1;
        }
        System.out.println(a);
    }
}