package com.deeparishi.javaapp.leetcode.graph.shortestpath.basic;

import java.util.*;

//https://leetcode.com/problems/word-ladder/

public class WordLadderI {
    public static void main(String[] args) {
        List<String> words = List.of("hot","dot","dog","lot","log","cog");
        System.out.println(ladderLengthOptimized("hit", "cog", words));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        Set<String> set = new HashSet<>(wordList);
        Queue<Pair> wordQueue = new LinkedList<>();
        wordQueue.add(new Pair(beginWord, 1));
        set.remove(beginWord);

        while (!wordQueue.isEmpty()){

            String word = wordQueue.peek().word;
            int distance = wordQueue.peek().distance;
            wordQueue.poll();

            if(endWord.equals(word))
                return distance;

            for (int i = 0; i < word.length(); i++) {
                for (char j = 'a'; j < 'z'; j++) {
                    char[] ch = word.toCharArray();
                    ch[i] = j;
                    String newWord = new String(ch);
                    if(set.contains(newWord)){
                        set.remove(newWord);
                        wordQueue.add(new Pair(newWord, distance + 1));
                    }
                }
            }
        }

        return 0;
    }

    public static int ladderLengthOptimized(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);

        int distance = 1;

        while (!beginSet.isEmpty() && !endSet.isEmpty()) {

            if (beginSet.size() > endSet.size()) {
                Set<String> temp = beginSet;
                beginSet = endSet;
                endSet = temp;
            }

            Set<String> nextLevel = new HashSet<>();

            for (String word : beginSet) {
                char[] wordChars = word.toCharArray();

                for (int i = 0; i < wordChars.length; i++) {
                    char originalChar = wordChars[i];

                    for (char c = 'a'; c <= 'z'; c++) {

                        if (c == originalChar) continue;

                        wordChars[i] = c;
                        String newWord = new String(wordChars);

                        if (endSet.contains(newWord))
                            return distance + 1;

                        if (wordSet.contains(newWord)) {
                            nextLevel.add(newWord);
                            wordSet.remove(newWord);
                        }
                    }

                    wordChars[i] = originalChar;
                }
            }

            beginSet = nextLevel;
            distance++;
        }

        return 0;
    }
}

class Pair{

    public Pair(String word, int distance) {
        this.word = word;
        this.distance = distance;
    }

    String word;

    int distance;

}