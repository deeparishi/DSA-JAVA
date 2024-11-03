package com.deeparishi.javaapp.selfpractice.hashing.directchain;

public class Main {

    public static void main(String[] args) {

        DirectChaining directChaining = new DirectChaining();

        directChaining.insert("Rishi");
        directChaining.insert("Is");
        directChaining.insert("one");
        directChaining.insert("of");
        directChaining.insert("beginning");
        directChaining.insert("developer");

        System.out.println(directChaining.search("Rishi"));
        System.out.println(directChaining.search("Rishsvi"));
        directChaining.displayHashTable();
        directChaining.delete("Rishi");
        directChaining.delete("one");
        directChaining.displayHashTable();
        directChaining.delete("Rishii");
        directChaining.delete("developer");
        directChaining.displayHashTable();

    }
}
