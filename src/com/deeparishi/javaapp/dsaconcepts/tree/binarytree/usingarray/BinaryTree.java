package com.deeparishi.javaapp.dsaconcepts.tree.binarytree.usingarray;

public class BinaryTree {

    String[] datas;

    int leastUsedIndex;

    BinaryTree(int size) {
        datas = new String[size];
        leastUsedIndex = 0;
    }

    void insert(String data) {
        if (!isFull()) {
            datas[++leastUsedIndex] = data;
            System.out.println(data + "Inserted Successfully...");
        } else
            System.out.println("Array is Full!!!!!");
    }

    boolean isFull() {
        return datas.length - 1 == leastUsedIndex;
    }

    public void preOrder(int index) {
        if(index > leastUsedIndex) return;

        System.out.print(datas[index] + " ");
        preOrder(index * 2);
        preOrder(index * 2 + 1);
    }

    public void inOrder(int index){

        if (index > leastUsedIndex) return;

        inOrder(2 * index);
        System.out.print(datas[index] + " ");
        inOrder(2 * index + 1);

    }

    public void postOrder(int index){

        if(index > leastUsedIndex) return;

        postOrder(2 * index);
        postOrder(2 * index + 1);
        System.out.print(datas[index] + " ");
    }

    public void levelOrder(){
        for (String data : datas)
            System.out.print(data + " ");
    }

    public boolean search(String data){
        for (int i = 1; i <= leastUsedIndex; i++){
            if(datas[i].equals(data)) return true;
        }
        return false;
    }

    public String delete(String value){
        for (int i = 1; i <= leastUsedIndex; i++){
            if(datas[i].equals(value)){
                datas[i] = datas[leastUsedIndex];
                leastUsedIndex--;
                return datas[i].concat(" ").concat(value);
            }
        }
        return null;
    }
}