package com.deeparishi.javaapp.selfpractice.trie.utls;

public class Node {

    Node[] links = new Node[26];

    boolean flag = false;

    int cntEndsWith = 0;

    int countPrefix = 0;


    public boolean containsKey(char c) {

        return links[c - 'a'] != null;
    }

    public void put(char c, Node node) {
        links[c - 'a'] = node;
    }

    public Node get(char c) {
        return links[c - 'a'];
    }

    public void setEnd(){
        flag = true;
    }

    public boolean isEnd(){
        return flag;
    }

    public void increaseEnd(){
        cntEndsWith++;
    }

    public void decreaseEnd(){
        cntEndsWith--;
    }

    public void increasePrefix(){
        countPrefix++;
    }

    public void decreasePrefix(){
        countPrefix--;
    }

    public int getCountPrefix(){
        return countPrefix;
    }

    public int getCntEndsWith(){
        return cntEndsWith;
    }

    public Node[] getAllChildren(){
        return links;
    }
}
