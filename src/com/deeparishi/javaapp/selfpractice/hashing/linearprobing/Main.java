package com.deeparishi.javaapp.selfpractice.hashing.linearprobing;

public class Main {

    public static void main(String[] args) {
        LinearProbing linearProbing = new LinearProbing(3);
        linearProbing.insert("Rishi");
        linearProbing.insert("Learning");
        linearProbing.insert("DSA");
        linearProbing.display();
        linearProbing.insert("To");
        linearProbing.display();
        linearProbing.insert("Get");
        linearProbing.insert("Into");
        linearProbing.insert("Good");
        linearProbing.insert("Company");

        System.out.println(linearProbing.search("dvRishi"));
    }
}
