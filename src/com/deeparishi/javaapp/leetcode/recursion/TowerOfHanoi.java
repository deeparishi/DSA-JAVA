package com.deeparishi.javaapp.leetcode.recursion;

public class TowerOfHanoi {

    public static void main(String[] args) {

        System.out.println(toh(2, 1,3,2));
    }

    static long toh(int n, int from, int to, int aux) {

        if (n == 1){
            System.out.println("move disk 1 from rod " +  from + " to rod "+ to);
            return n;
        }

        long moveCount = toh(n-1, from, aux, to);
        System.out.println("move disk " + n +" from rod " +  from + " to rod "+ to);
        moveCount++;

        moveCount += toh(n-1, aux, to, from);
        return moveCount;
    }

    public long moveCountsFromTower(int n){
        if (n == 1) return 1;
        return 2 * moveCountsFromTower(n - 1) + 1;
    }
}
