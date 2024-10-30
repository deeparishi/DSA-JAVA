package com.deeparishi.javaapp.leetcode.stack.animal;

import java.util.LinkedList;
import java.util.Queue;

public class AnimalQueue {

    Queue<Cat> catsQueue = new LinkedList<>();
    Queue<Dog> dogsQueue = new LinkedList<>();
    int order = 0;

    public void enqueue(Animal animal){
        animal.setOrder(order++);
        if(animal instanceof Cat)
            catsQueue.offer((Cat) animal);
        else if (animal instanceof  Dog)
            dogsQueue.offer((Dog) animal);
    }

    public Animal dequeueAny(){

        if(catsQueue.isEmpty())
            return dequeueDogs();
        else if (dogsQueue.isEmpty())
            return dequeueCats();

        Cat cat = catsQueue.peek();
        Dog dog = dogsQueue.peek();

        if (cat.isOlderThan(dog))
            return dequeueCats();
        else
            return dequeueDogs();
    }


    public Animal dequeueDogs(){
        return dogsQueue.poll();
    }

    public Animal dequeueCats(){
        return catsQueue.poll();
    }

}