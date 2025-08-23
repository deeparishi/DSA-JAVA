package com.deeparishi.javaapp.warmup;

import com.deeparishi.javaapp.practice.ListNode;
import com.deeparishi.javaapp.practice.Node;

import java.util.*;
import java.util.stream.IntStream;

public class LLProblems {

    /* Linked List Problems */
    public boolean isPalindrome(ListNode head) {
        Deque<Integer> deque = new LinkedList<>();
        ListNode temp = head;

        while (temp != null) {
            deque.add(temp.val);
            temp = temp.next;
        }

        while (deque.size() > 1) {
            int front = deque.removeFirst();
            int last = deque.removeLast();
            if (front != last) return false;
        }

        return true;
    }

    public void reverseAtKPos(int[] arr, int k) {
        if (k % arr.length == 0) return;
        k %= arr.length;

        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, k - 1);
        reverse(arr, k, arr.length - 1);
    }

    public void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public ListNode addTwoNumberLL(ListNode l1, ListNode l2) {
        return addTwoNumberLL(l1, l2, 0);
    }

    private ListNode addTwoNumberLL(ListNode l1, ListNode l2, int carry) {

        if (l1 == null && l2 == null && carry == 0)
            return null;

        int sum = carry;

        if (l1 != null) {
            sum += l1.val;
            l1 = l1.next;
        }

        if (l2 != null) {
            sum += l2.val;
            l2 = l2.next;
        }

        ListNode newNode = new ListNode(sum % 10);
        int div = sum / 10;
        newNode.next = addTwoNumberLL(l1, l2, div);
        return newNode;
    }

    public ListNode deleteDuplicates(ListNode head) {

        ListNode temp = head;

        while (temp.next != null) {
            if (temp.val == temp.next.val)
                temp.next = temp.next.next;
            else
                temp = temp.next;
        }
        return head;
    }

    public Node connect(Node root) {
        Node temp = root;
        while (temp.left != null) {
            Node curr = temp;
            while (curr != null) {
                curr.left.next = curr.right;
                if (curr.next != null)
                    curr.right.next = curr.next.left;
                curr = curr.next;
            }
            temp = temp.left;
        }
        return root;
    }

    public static void removeDuplicatesOnSortedArray(int[] arr) {

        int slow = 0;

        for (int fast = 1; fast < arr.length; fast++) {
            if (arr[fast] != arr[slow]) {
                slow++;
                arr[slow] = arr[fast];
            }
        }

        IntStream.rangeClosed(0, slow)
                .forEach(i -> System.out.println(arr[i]));
    }

    public static void findSubArraysWithSum(int[] arr, int target) {

        int start = 0;
        int end = 0;
        int currSum = 0;
        int len = arr.length;

        List<int[]> arrays = new ArrayList<>();

        while (end < len) {
            currSum += arr[end];

            while (currSum > target && start < len) {
                currSum -= arr[start];
                start++;
            }

            if (target == currSum)
                arrays.add(new int[]{start, end});
            end++;
        }

        arrays.forEach(a -> System.out.println(a[0] + " " + a[1]));
    }

    public static void findMaxSubArrayWithFixedSize(int[] arr, int window) {

        int start = 0;
        int end = 0;
        int max = Integer.MIN_VALUE;
        int condition = arr.length - window;

        while (start <= condition) {
            int count = 0;
            int times = 0;
            while (times < window) {
                count += arr[end];
                end++;
                times++;
            }
            if (count > max)
                max = count;

            start++;
            end = start;
        }

        System.out.println(max);
    }

    public static void containerWithMostWater(int[] arr) {

        int left = 0;
        int right = arr.length - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int small = Math.min(arr[left], arr[right]);
            int area = width * small;
            maxArea = Math.max(maxArea, area);

            if (arr[left] < arr[right])
                left++;
            else
                right--;
        }

        System.out.println(maxArea);

    }

    public ListNode mergeSortedNode(ListNode a, ListNode b) {

        ListNode head = new ListNode(0);
        ListNode tail = head;

        while (a != null && b != null) {
            if (a.val <= b.val) {
                tail.next = new ListNode(a.val);
                a = a.next;
            } else {
                tail.next = new ListNode(b.val);
                b = b.next;
            }
            tail = tail.next;
        }

        if (a != null) tail.next = a;
        if (b != null) tail.next = b;

        return head.next;
    }

    public boolean detectLoop(ListNode node) {

        ListNode fast = node;
        ListNode slow = node;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow)
                return true;
        }
        return false;
    }

    public ListNode reverseLL(ListNode node) {
        ListNode prev = null;
        ListNode curr = node;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public ListNode removeNthNode(ListNode head, int pos) {

        ListNode temp = head;

        if (pos == 0) {
            return head.next;
        }

        for (int i = 0; i < pos - 1; i++) {

            if (temp.next == null)
                return head;

            temp = temp.next;
        }

        if (temp.next != null)
            temp.next = temp.next.next;

        return head;
    }

    public int findIntersectionTwoLL(ListNode a, ListNode b) {

        int aLen = 0;
        int bLen = 0;

        ListNode currA = a, currB = b;

        while (currA != null) {
            aLen++;
            currA = currA.next;
        }

        while (currB != null) {
            bLen++;
            currB = currB.next;
        }

        currA = a;
        currB = b;

        if (aLen > bLen) {
            for (int i = 0; i < aLen - bLen; i++) {
                currA = currA.next;
            }
        } else {
            for (int i = 0; i < bLen - aLen; i++) {
                currB = currB.next;
            }
        }

        while (currA != null && currB != null) {
            if (currA == currB)
                return currA.val;

            currA = currA.next;
            currB = currB.next;
        }

        return 0;
    }

    public boolean validParenthesis(String str) {

        Stack<Character> stack = new Stack<>();
        for (char ch : str.toCharArray()) {
            if (ch == '[' || ch == '{' || ch == '(')
                stack.push(ch);
            else if (stack.empty()) return false;
            char top = stack.pop();
            if (
                    (ch == ']' && top != '[') ||
                            (ch == '}' && top != '{') ||
                            (ch == ')' && top != '(')
            ) {
                return false;
            }
        }

        return stack.empty();
    }
}
