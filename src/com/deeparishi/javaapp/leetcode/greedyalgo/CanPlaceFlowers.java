package com.deeparishi.javaapp.leetcode.greedyalgo;

public class CanPlaceFlowers {

    public static void main(String[] args) {
        int[] a = new int[]{1,0,0,0,0,0,1};
//        System.out.println(canPlaceFlowers(a, 1));
        System.out.println(canPlaceFlowers(a, 2));
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {

        int count = n;

        for (int i = 0; i < flowerbed.length; i++) {

            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0) &&
                    (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                count--;
            }

            if (count <= 0) return true;
        }

        return count <= 0;
    }

}
