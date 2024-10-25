package com.deeparishi.javaapp.udemychallenge.linkedlist;

public class MergeTwoSortLL {

    public static void main(String[] args) {

    }

    Node sortedMerge(Node a1, Node b1) {

        Node head = new Node(0);
        Node tail = head;

       while (a1 != null && b1 != null){

           if(a1.data <= b1.data){
               tail.next = a1;
               a1 = a1.next;
           }else{
               tail.next = b1;
               b1 = b1.next;
           }

           tail = tail.next;
       }

       if(a1 != null)
           tail.next = a1;

       if(b1 != null)
           tail.next = b1;

       return head.next;
    }

    int intersectPoint(Node head1, Node head2) {

        int length1 = getLength(head1);
        int length2 = getLength(head2);

        while (length1 > length2){
            length1--;
            head1 = head1.next;
        }

        while (length2 > length1){
            length2--;
            head2 = head2.next;
        }

        while (head1 != null && head2 != null){
            if(head1.data == head2.data)
                return head1.data;
            head1 = head1.next;
            head2 = head2.next;
        }

        return 0;
    }

    private int getLength(Node head) {

        int length = 0;

        while (head != null){
            length++;
            head = head.next;
        }

        return length;
    }

    Node reverse(Node head) {
        return null;
    }

    public static void removeLoop(Node head) {

        boolean inLoop = false;
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(fast == slow) {
                inLoop = true;
                break;
            }
        }

        if (inLoop) {
            slow = head;

            if (slow == fast) {
                while (fast.next != slow) {
                    fast = fast.next;
                }
            } else {
                while (slow.next != fast.next) {
                    slow = slow.next;
                    fast = fast.next;
                }
            }
            fast.next = null;
        }
    }

    public Node sortedInsert(Node head, int data) {

        Node newNode = new Node(data);

        if (head == null || data <= head.data) {
            newNode.next = head;
            return newNode;
        }

        Node curr = head;

        while (curr.next != null && curr.next.data < data) {
            curr = curr.next;
        }

        newNode.next = curr.next;
        curr.next = newNode;

        return head;

    }

    public Node sortedInserts(Node head, int data) {

        Node newNode=new Node(data);

        if(head== null){
            return newNode;
        }

        Node current= head;

        if(data <= head.data){
            while(current.next != head){
                current=current.next;
            }
            newNode.next=head;
            current.next=newNode;
            return newNode;
        }

        current = head;
        while(current.next != head && current.next.data < data){
            current=current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        return head;
    }

    Node deleteNode(Node head, int key) {
        return null;
    }
}

class Node{
    int data;
    Node next;
    Node prev;
    Node(int d) {data = d; prev = null; next = null; }
}
