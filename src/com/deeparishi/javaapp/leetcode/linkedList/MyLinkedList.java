                                                                                                                                           package com.deeparishi.javaapp.leetcode.linkedList;

                                                                                                                                            import com.deeparishi.javaapp.leetcode.linkedList.utl.Node;

                                                                                                                                            //https://leetcode.com/problems/design-linked-list/description/?envType=problem-list-v2&envId=linked-list
                                                                                                                                            class Main{

                                                                                                                                                public static void main(String[] args) {
                                                                                                                                                    MyLinkedList myLinkedList = new MyLinkedList();
                                                                                                                                                    myLinkedList.addAtHead(1);
                                                                                                                                                    myLinkedList.addAtTail(3);
                                                                                                                                                    myLinkedList.addAtIndex(1, 2);
                                                                                                                                                    System.out.println(myLinkedList.get(1)); //2
                                                                                                                                                    myLinkedList.deleteAtIndex(1);
                                                                                                                                                    System.out.println(myLinkedList.get(1)); //3
                                                                                                                                                }
                                                                                                                                            }
                                                                                                                                                public class MyLinkedList {

                                                                                                                                                    Node head;

                                                                                                                                                    Node tail;

                                                                                                                                                    int size;


                                                                                                                                                    public MyLinkedList() {
                                                                                                                                                        head = null;
                                                                                                                                                        tail = null;
                                                                                                                                                        size = 0;
                                                                                                                                                    }

                                                                                                                                                    public int get(int index) {

                                                                                                                                                        if (index < 0 || index >= size) {
                                                                                                                                                            return -1;
                                                                                                                                                        }

                                                                                                                                                        Node temp = head;

                                                                                                                                                        for (int i = 0; i < index ; i++) {
                                                                                                                                                            temp = temp.next;
                                                                                                                                                        }
                                                                                                                                                        return temp.value;
                                                                                                                                                    }

                                                                                                                                                    public void addAtHead(int val) {

                                                                                                                                                        Node node = new Node();
                                                                                                                                                        node.value = val;

                                                                                                                                                        if(head == null){
                                                                                                                                                            head = node;
                                                                                                                                                            tail = node;
                                                                                                                                                            size++;
                                                                                                                                                        }else{
                                                                                                                                                            node.next = head;
                                                                                                                                                            head = node;
                                                                                                                                                            size++;
                                                                                                                                                        }
                                                                                                                                                    }

                                                                                                                                                    public void addAtTail(int val) {

                                                                                                                                                        if(head == null){
                                                                                                                                                            addAtHead(val);
                                                                                                                                                            return;
                                                                                                                                                        }

                                                                                                                                                        Node node = new Node();
                                                                                                                                                        node.value = val;

                                                                                                                                                        tail.next = node;
                                                                                                                                                        tail = node;
                                                                                                                                                        size++;
                                                                                                                                                    }

                                                                                                                                                    public void addAtIndex(int index, int val) {

                                                                                                                                                        if(index == 0 || head == null){
                                                                                                                                                            addAtHead(val);
                                                                                                                                                            return;
                                                                                                                                                        }

                                                                                                                                                        if(size >= index){
                                                                                                                                                            addAtTail(val);
                                                                                                                                                            return;
                                                                                                                                                        }

                                                                                                                                                        Node node = new Node();
                                                                                                                                                        node.value = val;

                                                                                                                                                        Node temp = head;

                                                                                                                                                        for (int i = 0; i < index - 1; i++) {
                                                                                                                                                            temp = temp.next;
                                                                                                                                                        }

                                                                                                                                                        node.next = temp.next;
                                                                                                                                                        temp.next = node;
                                                                                                                                                        size++;
                                                                                                                                                    }

                                                                                                                                                    public void deleteAtIndex(int index) {

                                                                                                                                                        if(index == 0){
                                                                                                                                                            head = head.next;
                                                                                                                                                            size--;
                                                                                                                                                            if (size == 1) {
                                                                                                                                                                tail = null;
                                                                                                                                                            }
                                                                                                                                                            return;
                                                                                                                                                        }
                                                                                                                                                        Node temp = head;

                                                                                                                                                        for (int i = 0; i < index - 1; i++) {
                                                                                                                                                            temp = temp.next;
                                                                                                                                                        }

                                                                                                                                                        temp.next = temp.next.next;
                                                                                                                                                        if (index == size - 1) {
                                                                                                                                                            tail = temp; // Update tail if last element was deleted
                                                                                                                                                        }
                                                                                                                                                        size--;
                                                                                                                                                    }
                                                                                                                                                }
