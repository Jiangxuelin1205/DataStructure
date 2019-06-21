package TrieTest;

import org.junit.Assert;
import org.junit.Test;
import Trie.Trie;

public class TrieTest {

    @Test
    public void add() {
        Trie trie = new Trie();
        trie.add("split");
    }

    @Test
    public void size() {
        Trie trie = new Trie();
        trie.add("split");
        Assert.assertEquals(trie.size(), 1);
    }

    @Test
    public void add_recursive_and_contains() {
        Trie trie = new Trie();
        trie.addRecursive("split");
        Assert.assertTrue(trie.contains("split"));
    }

    @Test
    public void add_recursive_dont_contains() {
        Trie trie = new Trie();
        trie.addRecursive("split");
        Assert.assertFalse(trie.contains("spli"));
    }


    @Test
    public void contains() {
        Trie trie = new Trie();
        trie.add("split");
        Assert.assertTrue(trie.contains("split"));
    }

    @Test
    public void doesnt_contain() {
        Trie trie = new Trie();
        trie.add("split");
        Assert.assertFalse(trie.contains("pan"));
    }

    @Test
    public void contains_recursive() {
        Trie trie = new Trie();
        trie.add("split");
        Assert.assertTrue(trie.containsRecursive("split"));
    }

    @Test
    public void doesnt_contains_recursive() {
        Trie trie = new Trie();
        trie.add("split");
        Assert.assertFalse(trie.containsRecursive("pan"));
    }

    @Test
    public void is_prefix() {
        Trie trie = new Trie();
        trie.add("pan");
        Assert.assertTrue(trie.isPrefix("pan"));
    }

    @Test
    public void is_not_prefix() {
        Trie trie = new Trie();
        trie.add("pan");
        Assert.assertFalse(trie.isPrefix("pant"));
    }

    @Test
    public void is_prefix_recursive() {
        Trie trie = new Trie();
        trie.add("pan");
        Assert.assertTrue(trie.isPrefixRecursive("pan"));
    }

    @Test
    public void is_not_prefix_recursive() {
        Trie trie = new Trie();
        trie.add("pan");
        Assert.assertFalse(trie.isPrefixRecursive("pant"));
    }

}
