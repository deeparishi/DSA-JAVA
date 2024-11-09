package com.deeparishi.javaapp.dsaconcepts.hashing.doublehashing;

public class Main {

    public static void main(String[] args) {
        DoubleHashing hashing = new DoubleHashing(3);
        hashing.insert("Rishi");
        hashing.insert("Learning");
        hashing.insert("DSA");
        hashing.display();
        hashing.insert("To");
        hashing.display();
        hashing.insert("Get");
        hashing.insert("Into");
        hashing.insert("Good");
        hashing.insert("Company");

    }
}
