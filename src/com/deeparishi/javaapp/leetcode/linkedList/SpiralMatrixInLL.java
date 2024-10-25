package com.deeparishi.javaapp.leetcode.linkedList;

import com.deeparishi.javaapp.leetcode.linkedList.utl.Node;

import java.util.Arrays;

class SpiralMatrixInLL {

    public static void main(String[] args) {
        Node node = new Node(3);
        node.next = new Node(0);
        node.next.next = new Node(2);
        node.next.next.next = new Node(6);
        node.next.next.next.next = new Node(8);
        node.next.next.next.next.next = new Node(1);
        node.next.next.next.next.next.next = new Node(7);
        node.next.next.next.next.next.next.next = new Node(9);
        node.next.next.next.next.next.next .next.next= new Node(4);
        node.next.next.next.next.next.next.next.next.next = new Node(2);
        node.next.next.next.next.next.next.next.next.next.next= new Node(5);
        node.next.next.next.next.next.next.next.next.next.next.next= new Node(5);
        node.next.next.next.next.next.next.next.next.next.next.next.next= new Node(0);

        int[][] op = spiralMatrixNew(3,5,node);

        System.out.println(Arrays.deepToString(op));
    }

    static int[][] spiralMatrixNew(int rows, int columns, Node head){
        int[][] arr = new int[rows][];
        for (int i=0; i<rows; i++){
            arr[i] = new int [columns];
            Arrays.fill(arr[i], -1);
        }

        int leftCol = 0;
        int rightCol = columns - 1;
        int bottomRow = rows - 1;
        int topRow = 0;

        while (head != null){

            for(int col = leftCol; col <= rightCol && head != null; col++){
                arr[topRow][col] = head.value;
                head = head.next;
            }
            topRow++;

            for(int row = topRow; row <= bottomRow && head != null; row++){
                arr[row][rightCol] = head.value;
                head = head.next;
            }
            rightCol--;

            for(int col = rightCol; col >= leftCol && head != null; col--){
                arr[bottomRow][col] = head.value;
                head = head.next;
            }
            bottomRow--;

            for(int row = bottomRow; row >= topRow && head != null; row--){
                arr[row][leftCol] = head.value;
                head = head.next;
            }
            leftCol++;
        }

        return arr;
    }
    static int[][] spiralMatrix(int rows, int columns, Node head) {

        int[][] matrix = new int[rows][];
        for (int i = 0; i < rows; i++) {
            matrix[i] = new int [columns];
            Arrays.fill(matrix[i], -1);
        }

        int topRow = 0, bottomRow = rows - 1, leftColumn = 0, rightColumn = columns - 1;
        while (head != null) {

            for (int col = leftColumn; col <= rightColumn && head != null; col++) {
                matrix[topRow][col] = head.value;
                head = head.next;
            }
            topRow++;


            for (int row = topRow; row <= bottomRow && head != null; row++) {
                matrix[row][rightColumn] = head.value;
                head = head.next;
            }
            rightColumn--;


            for (int col = rightColumn; col >= leftColumn && head != null; col--) {
                matrix[bottomRow][col] = head.value;
                head = head.next;
            }
            bottomRow--;


            for (int row = bottomRow; row >= topRow && head != null; row--) {
                matrix[row][leftColumn] = head.value;
                head = head.next;
            }
            leftColumn++;
        }

        return matrix;
    }
}
