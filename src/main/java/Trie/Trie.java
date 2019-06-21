package Trie;

import java.util.TreeMap;

public class Trie {

    private Node root;
    private int size;

    private class Node {
        boolean isWord;
        TreeMap<Character, Node> next;

        Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

        Node() {
            this(false);
            next = new TreeMap<>();
        }
    }

    public Trie() {
        this.root = new Node();
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.next.containsKey(c)) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    public void addRecursive(String word) {
        addRecursive(root, word, 0);
    }

    private void addRecursive(Node node, String word, int index) {
        if (index == word.length()) {
            node.isWord = true;
            size++;
            return;
        }
        char c = word.charAt(index);
        if (!node.next.containsKey(c)) {
            node.next.put(c, new Node());
        }
        index++;
        addRecursive(node.next.get(c), word, index);
    }

    public boolean contains(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!cur.next.containsKey(c)) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return cur.isWord;
    }

    public boolean containsRecursive(String word) {
        return containsRecursive(root, word, 0);
    }

    private boolean containsRecursive(Node node, String word, int index) {
        if (index == word.length()) {
            return node.isWord;
        }
        char c = word.charAt(index);
        if (!node.next.containsKey(c)) {
            return false;
        }
        node = node.next.get(c);
        index++;
        return containsRecursive(node, word, index);
    }

    public boolean isPrefix(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!cur.next.containsKey(c)) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }

    public boolean isPrefixRecursive(String prefix) {
        return isPrefixRecursive(root, prefix, 0);
    }

    private boolean isPrefixRecursive(Node node, String prefix, int index) {
        if (index == prefix.length()) {
            return true;
        }
        char c = prefix.charAt(index);
        if (!node.next.containsKey(c)) {
            return false;
        }
        node = node.next.get(c);
        index++;
        return isPrefixRecursive(node, prefix, index);
    }
}
