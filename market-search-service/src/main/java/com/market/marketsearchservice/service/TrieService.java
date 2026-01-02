package com.market.marketsearchservice.service;


import com.market.marketsearchservice.repository.StockSymbolRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
@RequiredArgsConstructor
public class TrieService {

    private TrieNode root = new TrieNode();
    private final StockSymbolRepository repo;

    @PostConstruct
    public void buildTrie() {
        repo.findAll().forEach(s -> insert(s.getName()));
        System.out.println("Trie Loaded ✔");
    }

    public static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean end;
    }

    public void insert(String s) {
        TrieNode node = root;
        for(char c : s.toLowerCase().toCharArray()) {
            node.children.putIfAbsent(c, new TrieNode());
            node = node.children.get(c);
        }
        node.end = true;
    }

    public List<String> search(String prefix) {
        TrieNode node = root;
        prefix = prefix.toLowerCase();

        for(char c : prefix.toCharArray()) {
            if(!node.children.containsKey(c)) return List.of();
            node = node.children.get(c);
        }

        List<String> result = new ArrayList<>();
        dfs(node, new StringBuilder(prefix), result);
        return result;
    }

    private void dfs(TrieNode node, StringBuilder sb, List<String> res) {
        if (node.end) res.add(sb.toString());
        for(var e : node.children.entrySet()) {
            sb.append(e.getKey());
            dfs(e.getValue(), sb, res);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}