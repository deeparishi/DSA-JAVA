package com.deeparishi.javaapp.dsaconcepts.greedyalgo.youtube;

import java.util.Arrays;

public class AssignCookie {

    public static void main(String[] args) {

        int[] greed = new int[]{1, 5, 3, 3, 4};
        int[] children = new int[]{4, 2, 1, 2, 1, 3};
        System.out.println(count(greed, children));
    }


    static int count(int[] greed, int[] children) {

        Arrays.sort(greed);
        Arrays.sort(children);

        int greedIdx = 0;
        int childIdx = 0;
        int count = 0;

        while (greedIdx < greed.length && childIdx < children.length) {
            if (children[childIdx] >= greed[greedIdx]) {
                count++;
                greedIdx++;
            }
            childIdx++;
        }

        return greedIdx;
    }
}
