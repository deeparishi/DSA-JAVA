package com.deeparishi.javaapp.leetcode.trie;

// 3043. Find the Length of the Longest Common Prefix
// https://leetcode.com/problems/find-the-length-of-the-longest-common-prefix/description/?envType=problem-list-v2&envId=trie&difficulty=MEDIUM

public class LCP {

    public static void main(String[] args) {

        int [] arr1 = new int[]{34};
        int [] arr2 = new int[]{39};
        System.out.println(longestCommonPrefix(arr1,arr2));
    }

    static int longestCommonPrefix(int[] arr1, int[] arr2) {

        TrieForNumbers trie = new TrieForNumbers();

        for (int val : arr1) {
            trie.insert(String.valueOf(val));
        }

        int longest = 0;

        for (int i = 0; i < arr2.length; i++) {
            int val = trie.isValidLongest(String.valueOf(arr2[i]));
            if(val > longest) longest = val;
        }

        return longest;
    }
}

class TrieForNumbers{

    NodeForNumbers root = new NodeForNumbers();

    public void insert(String val){
        NodeForNumbers temp = root;
        for (int i = 0; i < val.length(); i++) {
            char ch = val.charAt(i);
            if(!temp.containsKey(ch)){
                temp.put(ch, new NodeForNumbers());
            }
            temp = temp.get(ch);
        }
        temp.setEnd();
    }


    public int isValidLongest(String s) {

        int count = 0;
        NodeForNumbers temp = root;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(temp.containsKey(ch)){
                temp = temp.get(ch);
                count++;
            }else{
                break;
            }

        }
        return count;
    }
}


class NodeForNumbers{

    NodeForNumbers[] links = new NodeForNumbers[10];

    boolean flag;

    public boolean containsKey(char ch){
        return links[ch - '0'] != null;
    }

    public void put(int ch, NodeForNumbers node){
        links[ch - '0'] = node;
    }

    public NodeForNumbers get(int ch){
        return links[ch - '0'];
    }

    public void setEnd(){
        flag = true;
    }

    public boolean isEnd(){
        return flag;
    }
}
