package com.deeparishi.javaapp.dsaconcepts.arraylist;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayList<T> implements Iterable<T> {

    private int size;

    private Object[] array;

    private int pointer;

    ArrayList() {
        size = 2;
        array = new Object[size];
        pointer = 0;
    }

    ArrayList(int size) {
        this.size = size;
        array = new Object[size];
        pointer = 0;
    }

    public T add(T number) {

        if (isFull()) {
            copyTheArray();
        }

        array[pointer++] = number;

        return number;
    }

    public T add(int index, T number) {

        if (index > pointer)
            throw new ArrayIndexOutOfBoundsException();

        if (isFull())
            copyTheArray();

        for (int i = pointer; i > index; i--)
            array[i] = array[i - 1];

        array[index] = number;
        pointer++;

        return number;
    }

    private void copyTheArray() {
        size *= 2;
        array = Arrays.copyOf(array, size);
    }

    public boolean isFull() {
        return pointer >= size;
    }

    public int size() {
        return pointer;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index > pointer)
            throw new ArrayIndexOutOfBoundsException();

        return (T) array[index];
    }

    public void remove(int index) {
        if (index > pointer)
            return;

        for (int i = index; i <= pointer - 1; i++) {
            array[i] = array[i + 1];
        }

        pointer--;
    }

    public boolean remove(T value) {
        for (int i = 0; i < pointer; i++) {
            if (array[i].equals(value)) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean removeAll() {
        if (pointer == 0)
            return true;

        size = 2;
        array = new Object[size];
        pointer = 0;
        return true;
    }

    public boolean removeFirst() {

        if (pointer == 0)
            throw new ArrayIndexOutOfBoundsException();

        for (int i = 0; i < pointer; i++) {
            array[i] = array[i + 1];
        }

        pointer--;
        return true;

    }

    public boolean removeLast() {
        if (pointer == 0)
            return true;

        array[pointer] = 0;
        pointer--;
        return true;
    }

    public void print() {
        if (pointer == 0) {
            System.out.println("[]");
            return;
        }
        for (int i = 0; i < pointer; i++) {
            System.out.println(array[i]);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < pointer;
            }

            @SuppressWarnings("unchecked")
            @Override
            public T next() {
                return (T) array[currentIndex++];
            }
        };
    }
}