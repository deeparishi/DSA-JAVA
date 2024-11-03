package com.deeparishi.javaapp.selfpractice.hashing.quadraticprobing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuadraticProbing {

    String[] hashTable;

    int size;

    int usedCellNumber;

    public QuadraticProbing(int size){
        this.size = size;
        this.hashTable = new String[size];
        this.usedCellNumber = 0;
    }

    public QuadraticProbing(){
        this.size = 5;
        this.hashTable = new String[5];
        this.usedCellNumber = 0;
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
            int counter = 0;
            int len = index + hashTable.length;

            for (int i = index; i < len; i++) {
                int newIndex = (index + (counter * counter)) % hashTable.length;
                if(hashTable[newIndex] == null){
                    hashTable[newIndex] = input;
                    System.out.println("Inserted the "+ input + "sucessfully at "+ i);
                    break;
                }
                counter++;
            }
        }
        usedCellNumber++;
    }

    public void display() {
        for (int i = 0; i < hashTable.length; i++) {
            System.out.println("Index : "+ i + "Value : " + hashTable[i]);
        }
    }
}
