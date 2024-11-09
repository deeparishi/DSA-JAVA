package com.deeparishi.javaapp.dsaconcepts.hashing.quadraticprobing;

public class Main {
    public static void main(String[] args) {
        QuadraticProbing probing = new QuadraticProbing(5);
        probing.insert("Rishi");
        probing.insert("Learning");
        probing.insert("DSA");
        probing.display();
        probing.insert("To");
        probing.display();
        probing.insert("Get");
        probing.insert("Into");
        probing.insert("Good");
        probing.insert("Company");
        probing.display();
    }
}
