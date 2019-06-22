package Trie;

import java.util.TreeMap;

public class WordDictionary {

    private Node root;

    private class Node {
        boolean isWord;
        TreeMap<Character, Node> next;

        Node() {
            this.isWord = false;
            next = new TreeMap<>();
        }
    }


    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new Node();
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        Node cur = root;
        //noinspection Duplicates
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.next.containsKey(c)) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
        }
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
     */
    public boolean search(String word) {
        return search(root, word, 0);
    }

    private boolean search(Node node, String word, int index) {
        if (index == word.length()) {
            return node.isWord;
        }
        char c = word.charAt(index);
        if (isLetter(c)) {//如果是字母
            if (!node.next.containsKey(c)) {
                return false;
            }
            node = node.next.get(c);
            index++;
            return search(node, word, index);
        } else {//如果是.
            for (Character ch : node.next.keySet()) {
                index++;
                if (search(node.next.get(ch), word, index)) {
                    return true;
                }
                index--;
            }
        }
        return false;
    }

    private boolean isLetter(char c) {
        return c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z';
    }

}
