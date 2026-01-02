package com.market.marketsearchservice.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TrieNode {

    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfWord;

    public TrieNode(){

    }

    public void insert(TrieNode root, String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            current.children.putIfAbsent(ch, new TrieNode());
            current = current.children.get(ch);
        }
        current.isEndOfWord = true;
    }


    public boolean search(TrieNode root, String word) {
        TrieNode current = root;
        for (char ch : word.toCharArray()) {
            if (!current.children.containsKey(ch)) return false;
            current = current.children.get(ch);
        }
        return current.isEndOfWord;
    }


    public List<String> startsWith(TrieNode root, String prefix) {
        List<String> results = new ArrayList<>();
        TrieNode current = root;

        for (char ch : prefix.toCharArray()) {
            if (!current.children.containsKey(ch)) return results;
            current = current.children.get(ch);
        }
        dfs(current, new StringBuilder(prefix), results);
        return results;
    }

    private void dfs(TrieNode node, StringBuilder path, List<String> results) {
        if (node.isEndOfWord) results.add(path.toString());
        for (char c : node.children.keySet()) {
            path.append(c);
            dfs(node.children.get(c), path, results);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
