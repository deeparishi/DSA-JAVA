package com.deeparishi.javaapp.leetcode;

public class ProblemLL {


    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode temp = head;

            for (ListNode i = temp; temp.next != null; temp = temp.next) {
                if (temp.val == temp.next.val) {
                    temp.next = temp.next.next;
                }
                return temp.next;
            }
            return temp.next;
        }
    }
}
