package com.deeparishi.javaapp.leetcode.trie;

import java.util.*;

class Soln {
    public static void main(String[] args) {
        AutocompleteSystem obj = new AutocompleteSystem(
                new String[] {"i love you", "island", "ironman", "i love leetcode"},
                new int[] {5, 3, 2, 2}
        );

        // Full sentence search with "i"
        System.out.println(obj.input("i"));  // Expected: ["i love you", "island", "i love leetcode"]

        // Full sentence search with "i love"
        System.out.println(obj.input("i love"));  // Expected: ["i love you", "i love leetcode"]

        // Adding a new sentence "Hello world"
        System.out.println(obj.input("Hello world#")); // Expected: []

        // Searching for the newly added sentence
        System.out.println(obj.input("Hello")); // Expected: ["Hello world"]
    }
}

class AutocompleteSystem {
    private Trie trie;
    private StringBuilder currentInput;

    public AutocompleteSystem(String[] sentences, int[] times) {
        trie = new Trie();
        currentInput = new StringBuilder();

        for (int i = 0; i < sentences.length; i++) {
            trie.insert(sentences[i], times[i]);
        }
    }

    public List<String> input(String inputString) {
        if (inputString.endsWith("#")) {  // Check if the input ends with '#'
            String sentence = currentInput.toString() + inputString.substring(0, inputString.length() - 1);
            trie.insert(sentence, 1);  // Insert or update frequency of the full sentence
            currentInput.setLength(0); // Reset current input after adding
            return new ArrayList<>();   // Return empty list when a sentence is added
        }

        currentInput.append(inputString); // Append the input string to the current input
        return trie.searchSuggestions(currentInput.toString());
    }
}

class Trie {
    private final NodeForAs root;
    private final Map<String, Integer> frequencyMap;

    public Trie() {
        root = new NodeForAs();
        frequencyMap = new HashMap<>();
    }

    public void insert(String word, int frequency) {
        frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + frequency);
        NodeForAs node = root;

        for (char c : word.toCharArray()) {
            if (!node.containsKey(c)) {
                node.put(c, new NodeForAs());
            }
            node = node.get(c);
            node.increasePrefix();
            node.addSuggestion(word, frequencyMap);  // Pass the frequency map
        }
        node.increaseEnd();
    }

    public List<String> searchSuggestions(String prefix) {
        NodeForAs node = root;
        for (char c : prefix.toCharArray()) {
            if (!node.containsKey(c)) {
                return new ArrayList<>();  // Return empty list if prefix not found
            }
            node = node.get(c);
        }
        return node.getSuggestions();
    }
}

class NodeForAs {
    Map<Character, NodeForAs> links = new HashMap<>();
    boolean flag = false;
    int cntEndsWith = 0;
    int countPrefix = 0;
    List<String> suggestions = new ArrayList<>();

    public boolean containsKey(char c) {
        return links.containsKey(c);
    }

    public void put(char c, NodeForAs node) {
        links.put(c, node);
    }

    public NodeForAs get(char c) {
        return links.get(c);
    }

    public void increasePrefix() {
        countPrefix++;
    }

    public void increaseEnd() {
        cntEndsWith++;
    }

    public List<String> getSuggestions() {
        return suggestions;
    }

    public void addSuggestion(String word, Map<String, Integer> frequencyMap) {
        if (!suggestions.contains(word)) {
            suggestions.add(word);
        }

        // Sort by frequency in descending order, breaking ties lexicographically
        suggestions.sort((a, b) -> {
            int freqCompare = Integer.compare(frequencyMap.get(b), frequencyMap.get(a));
            return freqCompare != 0 ? freqCompare : a.compareTo(b);
        });

        // Keep only the top 3
        if (suggestions.size() > 3) {
            suggestions = suggestions.subList(0, 3);
        }
    }
}
