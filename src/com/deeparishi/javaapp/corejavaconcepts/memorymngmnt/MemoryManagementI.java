package com.deeparishi.javaapp.corejavaconcepts.memorymngmnt;

public class MemoryManagementI {

    public static void main(String[] args) {
        int integer = 10;
        String str = "rishi";
        Person person = new Person();
        MemoryManagementI mem = new MemoryManagementI();
        mem.memoryManagementTest(person);
        System.out.println(str);
    }

    public void memoryManagementTest(Person person) {
        Person person2 = person;
        String str = "ridevshi";
        String newStr = new String("rishi");
    }

    static class Person {
        int id;
        String name;
    }
}