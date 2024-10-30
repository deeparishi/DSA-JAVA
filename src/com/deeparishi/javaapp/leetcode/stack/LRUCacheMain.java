package com.deeparishi.javaapp.leetcode.stack;

import com.deeparishi.javaapp.leetcode.linkedList.utl.Node;

import java.util.HashMap;
import java.util.Map;

public class LRUCacheMain {

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        lRUCache.put(1, 1); // cache is {1=1}
        lRUCache.put(2, 2); // cache is {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // return 1
        lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
        System.out.println(lRUCache.get(2));    // returns -1 (not found)
        lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
        System.out.println(lRUCache.get(1));    // return -1 (not found)
        System.out.println(lRUCache.get(3));   // return 3
        System.out.println(lRUCache.get(4));    // return 4
    }
}

class LRUCache {

    Map<Integer, Node> trackCache;
    Node head;
    Node tail;
    int capacity;

    public LRUCache(int capacity) {
        trackCache = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
        this.capacity = capacity;
    }

    public int get(int key) {
        Node node = trackCache.get(key);
        if (node == null) return -1;

        removeNode(node);
        addToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = trackCache.get(key);
        if(node != null){
            node.value = value;
            moveToHead(node);
        }else {
            if (trackCache.size() >= capacity) {
                removeLeastUsed();
            }
                node = new Node(key, value);
                addToHead(node);
                trackCache.put(key, node);

        }
    }

    private void addToHead(Node node) {
       node.next = head.next;
       node.prev = head;
       head.next.prev = node;
       head.next = node;
    }

    private void removeLeastUsed() {
        Node leastUsed = tail.prev;
        trackCache.remove(leastUsed.key);
        removeNode(leastUsed);
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    private void removeNode(Node leastUsed){
        leastUsed.prev.next = leastUsed.next;
        leastUsed.next.prev = leastUsed.prev;
    }
}
