package com.deeparishi.javaapp.dsaconcepts.heap;

import java.util.ArrayList;
import java.util.List;

public class Heap <T extends Comparable<T>>{

    List<T> list;

    public Heap(){
        this.list = new ArrayList<>();
    }

    private void swap(int a, int b){
        T temp = list.get(a);
        list.set(a, list.get(b));
        list.set(b, temp);
    }

    private int parent(int index){
        return (index - 1) / 2;
    }

    private int left(int index){
        return 1 + index * 2;
    }

    private int right(int index){
        return 2 + index * 2;
    }

    public void insert(T data){
        list.add(data);
        upHeap(list.size() - 1);
    }

    private void upHeap(int index) {

        if(index == 0) return;

        int parent = parent(index);

        if(list.get(index).compareTo(list.get(parent)) < 0){
            swap(index, parent);
            upHeap(parent);
        }
    }

    public T remove(){

        if(list.isEmpty())
            return null;

        T result = list.getFirst();
        T last = list.removeLast();

        if(!list.isEmpty()){
            list.set(0, last);
            downHeap(0);
        }

        return result;
    }

    private void downHeap(int index) {

        if(index == 1) return;

        int left = left(index);
        int right = right(index);
        int min = index;

        if(left < list.size() && list.get(min).compareTo(list.get(left)) > 0)
            min = left;

        if(right < list.size() && list.get(min).compareTo(list.get((right))) > 0)
            min = right;

        if(min != index){
            swap(index, min);
            downHeap(min);
        }
    }

    public List<T> heapSort(){

        List<T> sorted = new ArrayList<>();
        List<T> previous = new ArrayList<>(list);
        while (!list.isEmpty()){
            sorted.add(this.remove());
        }
        this.list = previous;
        return sorted;
    }

    public void print(){
        System.out.println(list);
    }


}
