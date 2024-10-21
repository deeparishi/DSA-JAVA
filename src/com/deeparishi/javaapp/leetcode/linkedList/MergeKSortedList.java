package com.deeparishi.javaapp.leetcode.linkedList;

import com.deeparishi.javaapp.leetcode.linkedList.utl.Node;

import java.util.PriorityQueue;

public class MergeKSortedList {

    // https://leetcode.com/problems/merge-k-sorted-lists/?envType=problem-list-v2&envId=linked-list

    public static void main(String[] args) {

    }

    public Node mergeKSortedList(Node[] lists){

        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.value - b.value);

        for (Node node : lists){
            if(node != null)
                pq.add(node);
        }

        Node dummy = new Node(-1);
        Node temp = dummy;

        while (!pq.isEmpty()){
            Node q = pq.poll();

            if(q.next != null)
                pq.add(q.next);

            temp.next = q;
            temp = temp.next;
        }

        return dummy.next;
    }


}
