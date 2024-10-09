package com.deeparishi.javaapp.old.leetcode;

public class FindArrayForXor {
    public static void main(String[] args) {
        int [] arr = findArray(new int[]{5,2,0,3,1});
        for (int i=0; i<arr.length; i++){
            System.out.println(arr[i]);
        }
    }
    public static int[] findArray(int[] pref) {
     int[] result = new int[pref.length];
     result[0] = pref[0];
     for(int i=1; i<pref.length; i++){
         int ans = pref[i];
         for(int j=0; j<result.length; j++){
             ans = result[j] ^ ans;
         }
         result[i] = ans;
     }
     return result;
    }
}

//Optimized code
//public int[] findArray(int[] pref) {
//    int n = pref.length;
//    int arr[] = new int[n];
//    arr[0] = pref[0];
//
//    for(int i=1; i<n; i++){
//        arr[i] = pref[i-1]^pref[i];
//    }
//    return arr;
//}