package TrieTest;

import Trie.WordDictionary;
import org.junit.Assert;
import org.junit.Test;

public class WordDictionaryTest {
    @Test
    public void addWord(){
        WordDictionary dictionary=new WordDictionary();
        dictionary.addWord("split");
        Assert.assertTrue(dictionary.search("split"));
    }

    @Test
    public void search(){
        WordDictionary dictionary=new WordDictionary();
        dictionary.addWord("split");
        Assert.assertTrue(dictionary.search("spli."));
    }

    @Test
    public void dot_search(){
        WordDictionary dictionary=new WordDictionary();
        dictionary.addWord("bad");
        dictionary.addWord("dad");
        dictionary.addWord("mad");
        Assert.assertFalse(dictionary.search("spli."));
        Assert.assertFalse(dictionary.search("pad"));
        Assert.assertTrue(dictionary.search("bad"));
        Assert.assertTrue(dictionary.search(".ad"));
        Assert.assertTrue(dictionary.search("b.."));
        Assert.assertFalse(dictionary.search("b..."));
        Assert.assertFalse(dictionary.search("b."));
    }

    @Test
    public void empty_search(){
        WordDictionary dictionary=new WordDictionary();
        dictionary.addWord("bad");
        dictionary.addWord("dad");
        dictionary.addWord("mad");
        Assert.assertFalse(dictionary.search(""));

    }

    @Test
    public void example_test(){
        WordDictionary dictionary=new WordDictionary();
        dictionary.addWord("at");
        dictionary.addWord("and");
        dictionary.addWord("an");
        dictionary.addWord("and");
        Assert.assertFalse(dictionary.search("a"));
        Assert.assertFalse(dictionary.search(".at"));
        dictionary.addWord("bat");
        Assert.assertTrue(dictionary.search(".at"));
        Assert.assertTrue(dictionary.search("an."));
        Assert.assertFalse(dictionary.search("a.d."));
        Assert.assertFalse(dictionary.search("b."));
        Assert.assertFalse(dictionary.search("a.d."));
        Assert.assertFalse(dictionary.search("."));
    }
}
