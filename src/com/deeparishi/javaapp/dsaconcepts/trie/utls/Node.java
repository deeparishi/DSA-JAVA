package com.deeparishi.javaapp.dsaconcepts.trie.utls;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Node {

    Node[] links = new Node[26];

    boolean flag = false;

    int cntEndsWith = 0;

    int countPrefix = 0;

    List<String> suggestions = new ArrayList<>();

    public List<Integer> index = new ArrayList<>();

    public int value = 0;

    public boolean containsKey(char c) {

        return links[c - 'a'] != null;
    }

    public void put(char c, Node node) {
        links[c - 'a'] = node;
    }

    public Node get(char c) {
        return links[c - 'a'];
    }

    public void setEnd() {
        flag = true;
    }

    public boolean isEnd() {
        return flag;
    }

    public void increaseEnd() {
        cntEndsWith++;
    }

    public void decreaseEnd() {
        cntEndsWith--;
    }

    public void increasePrefix() {
        countPrefix++;
    }

    public void decreasePrefix() {
        countPrefix--;
    }

    public int getCountPrefix() {
        return countPrefix;
    }

    public int getCntEndsWith() {
        return cntEndsWith;
    }

    public Node[] getAllChildren() {
        return links;
    }

    public boolean isLeaf() {

        for (Node link : links) {
            if (link != null) return false;
        }
        return true;
    }

    public List<String> getSuggestions() {
        return suggestions;
    }

    public void setSuggestions(List<String> suggestions) {
        this.suggestions = suggestions;
    }

    public void addSuggestion(String word) {
        if (suggestions.size() < 3) {
            suggestions.add(word);
        } else if (word.compareTo(suggestions.get(2)) < 0) {
            suggestions.remove(2);
            suggestions.add(word);
        }
        Collections.sort(suggestions);
    }
}
