package com.LeetCode.prefix;

public class Trie {
    TrieNode root;

    public Trie(){
        root = new TrieNode();
    }

    public void insert(String key){
        TrieNode curr = root;

        for (char c: key.toCharArray()){
            if(curr.children[c - 'a'] == null){
                curr.children [c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEndOfWord = true;
    }

    public boolean search(String key){
        TrieNode curr = root;

        for (char c: key.toCharArray()){
            if(curr.children[c - 'a'] == null){
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return curr.isEndOfWord;
    }

    public boolean isPrefix(String key){
        TrieNode curr = root;

        for (char c: key.toCharArray()){
            if(curr.children[c - 'a'] == null){
                return false;
            }
            curr = curr.children[c - 'a'];
        }
        return true;
    }

    public static void main(String[] args) {
        Trie tr = new Trie();
        String[] words = {"and", "ant", "do", "dad"};

        for (String str : words){
            tr.insert(str);
        }

        String[] searchKeys = {"do", "gee", "bat"};
        for (String str : searchKeys){
            System.out.println(tr.search(str));
        }
        System.out.println();
        String[] prefixes = {"ge","ba", "do", "de"};
        for (String str: prefixes){
            System.out.println(tr.isPrefix(str));
        }
    }
}
