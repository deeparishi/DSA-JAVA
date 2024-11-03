package com.deeparishi.javaapp.selfpractice.hashing.directchain;

import java.util.LinkedList;

public class DirectChaining {

    private LinkedList<String>[] hashTable;

    private final int maxChainSize;

    public DirectChaining(int size){
        hashTable = new LinkedList[size];
        this.maxChainSize = size;
    }

    public DirectChaining(){
        this(5);
    }

    public int asciiModForString(String input, int size){

        int total = 0;

        for (int i = 0; i < input.length(); i++) {
            total += input.charAt(i);
        }

        return total % size;
    }

    public void insert(String input){

        int index = asciiModForString(input, hashTable.length);

        if(hashTable[index] == null){
            hashTable[index] = new LinkedList<>();
            hashTable[index].add(input);
        }else{
            hashTable[index].add(input);
        }
    }

    public void displayHashTable(){
        if(hashTable == null)
            return;

        System.out.println("-------------Hash Table-----------");
        for (int i = 0; i < hashTable.length; i++) {
            System.out.println("Index " + i + " key: " + hashTable[i]);
        }
    }

    public boolean search(String input) {

        int index = asciiModForString(input, hashTable.length);
        if(hashTable[index] == null)
            return false;
        return hashTable[index].contains(input);

    }

    public void delete(String input){
        int index = asciiModForString(input, hashTable.length);
        if(hashTable[index] == null)
            return;

        hashTable[index].remove(input);
    }
}
