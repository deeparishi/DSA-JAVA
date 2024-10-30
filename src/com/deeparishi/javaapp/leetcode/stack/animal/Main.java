package com.deeparishi.javaapp.leetcode.stack.animal;

//https://www.udemy.com/course/java-data-structures-and-algorithms-masterclass/learn/quiz/5132874#questions

public class Main {

    public static void main(String[] args) {

        AnimalQueue animals = new AnimalQueue();

        animals.enqueue(new Cat("Kiki"));
        animals.enqueue(new Cat("Kari"));
        animals.enqueue(new Dog("Beji"));
        animals.enqueue(new Cat("Reki"));
        animals.enqueue(new Dog("Dexter"));

        System.out.println(animals.dequeueAny().name());
        System.out.println(animals.dequeueDogs().name());
        System.out.println(animals.dequeueCats().name());

    }
}
