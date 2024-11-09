package com.deeparishi.javaapp.dsaconcepts.hashing.linearprobing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinearProbing {

    private String[] hashTable;

    private int size;

    private int usedCellNumber;

    public LinearProbing(){
        this.size = 5;
        this.hashTable = new String[size];
    }

    public LinearProbing(int size){
        this.size = size;
        this.hashTable = new String[size];
    }

    private int asciiForString(String input){

        int total = 0;

        for (int i = 0; i < input.length(); i++) {
            total += input.charAt(i);
        }

        return total % hashTable.length;
    }

    private double getLoadFactor(){
        return usedCellNumber * 1.0 / hashTable.length;
    }

    private void getNewHash(String input){

        usedCellNumber = 0;

        List<String> backupData = new ArrayList<>(Arrays.asList(hashTable));
        backupData.add(input);

        hashTable = new String[hashTable.length * 2];

        for (String data : backupData){
            if(data != null)
                insert(data);
        }
    }


    public void insert(String input) {

        double loadFactor = getLoadFactor();

        if(loadFactor >= 0.75)
            getNewHash(input);
        else{
            int index = asciiForString(input);
            for (int i = index; i<index+hashTable.length; i++) {
                int newIndex = i % hashTable.length;
                if (hashTable[newIndex] == null) {
                    hashTable[newIndex] = input;
                    System.out.println("The " + input + " successfully inserted at location: "+newIndex);
                    break;
                } else {
                    System.out.println(newIndex+" is already occupied . Trying next empty cell");
                }
            }
        }
        usedCellNumber++;
    }


    public void display(){

        for (int i = 0; i < hashTable.length; i++) {
            System.out.println("Index: "+ i + " Value: " + hashTable[i]);
        }
    }

    public boolean search(String input) {

        int index = asciiForString(input);
        int len = hashTable.length + index;
        for (int i = 0; i < len; i++) {
            int newIndex = i % hashTable.length;
            if(hashTable[newIndex] != null && hashTable[newIndex].equals(input))
                return true;
        }

        return false;
    }

}
