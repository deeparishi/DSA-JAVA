package com.deeparishi.javaapp.leetcode.arrays;

import java.util.Arrays;

//https://leetcode.com/problems/rotating-the-box/?envType=daily-question&envId=2024-11-23

public class RotatingTheBox {

    public static void main(String[] args) {
        char[][] box = {
                {'#','#','*','.','*','.'},
                {'#','#','#','*','.','.'},
                {'#','#','#','.','#','.'}
        };

        System.out.println(Arrays.deepToString(rotateTheBox(box)));
    }

    static char[][] rotateTheBox(char[][] box) {

        int row = box.length;
        int col = box[0].length;

        char[][] newBox = new char[col][row];

        for (int i = 0; i < row; i++) {
            int empty = col - 1;
            for (int j = col - 1; j >= 0; j--) {
                if (box[i][j] == '#') {
                    box[i][j] = '.';
                    box[i][empty] = '#';
                    empty--;
                } else if (box[i][j] == '*') {
                    empty = j - 1;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                newBox[j][row - 1 - i] = box[i][j];
            }
        }

        return newBox;
    }

    static char[][] rotateTheBoxOwn(char[][] box) {

        char[][] newBox = new char[box[0].length][box.length];

        for (int i = box.length - 1; i >= 0; i--) {
            int a = box[i].length - 1;
            int b = box[i].length - 1;
            while (a >= 0 && b >= 0){
                if(box[i][a] == '#' && box[i][b] == '#'){
                    newBox[i][a] = box[i][a];
                    a--;
                    b--;
                } else if(box[i][a] == '*' && box[i][b] == '*'){
                    newBox[i][a] = box[i][a];
                    a--;
                    b--;
                } else if (box[i][a] == '.' && box[i][b] == '.') {
                    b--;
                } else{
                    box[i][a] = '#';
                    a--;
                    b--;
                }
            }
        }

        return newBox;
    }
}
