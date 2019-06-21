package Trie;

import java.util.TreeMap;

public class MapSum {
    /**
     * Implement a MapSum class with insert, and sum methods.
     *
     * For the method insert, you'll be given a pair of (string, integer).
     * The string represents the key and the integer represents the value.
     * If the key already existed, then the original key-value pair will be overridden to the new one.
     *
     * For the method sum, you'll be given a string representing the prefix,
     * and you need to return the sum of all the pairs' value whose key starts with the prefix.
     *
     * Input: insert("apple", 3), Output: Null
     * Input: sum("ap"), Output: 3
     * Input: insert("app", 2), Output: Null
     * Input: sum("ap"), Output: 5
     */


    /**
     * Initialize your data structure here.
     */

    private Node root;

    private class Node {
        TreeMap<Character, Node> next;
        int value;

        Node() {
            this.value = 0;
            next = new TreeMap<>();
        }
    }

    public MapSum() {
        root = new Node();
    }

    public void insert(String key, int val) {
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (!cur.next.containsKey(c)) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        cur.value = val;
    }

    public int sum(String prefix) {
        //找到前缀
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!cur.next.containsKey(c)) {
                return 0;
            }
            cur = cur.next.get(c);
        }
        return sum(cur);
        //计算所有以该前缀为前缀的单词的value和
    }

    private int sum(Node node) {
        int result = node.value;
        for (Character ch : node.next.keySet()) {
            result += sum(node.next.get(ch));
        }
        return result;
    }
}
