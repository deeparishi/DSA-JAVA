package com.deeparishi.javaapp.leetcode.hashing;

import java.util.Arrays;

public class DesignHashmap{

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        myHashMap.put(1, 1); // The map is now [[1,1]]
        myHashMap.put(2, 2); // The map is now [[1,1], [2,2]]
        System.out.println(myHashMap.get(1));    // return 1, The map is now [[1,1], [2,2]]
        System.out.println(myHashMap.get(3));;    // return -1 (i.e., not found), The map is now [[1,1], [2,2]]
        myHashMap.put(2, 1); // The map is now [[1,1], [2,1]] (i.e., update the existing value)
        System.out.println(myHashMap.get(2));    // return 1, The map is now [[1,1], [2,1]]
        myHashMap.remove(2); // remove the mapping for 2, The map is now [[1,1]]
        System.out.println(myHashMap.get(2));    // return -1 (i.e., not found), The map is now [[1,1]]
    }
}
class MyHashMap {

    private final  int[] arr;

    private static final int EMPTY = -1;

    public MyHashMap() {
        int range = (int) Math.pow(10,6) + 1;
        this.arr = new int[range];
        Arrays.fill(arr, EMPTY);
    }

    public void put(int key, int value) {
        arr[key] = value;
    }

    public int get(int key) {
        return arr[key] == EMPTY ? -1 : arr[key];
    }

    public void remove(int key) {
        arr[key] = EMPTY;
    }
}
