package TrieTest;

import Trie.WordSearch;
import org.junit.Assert;
import org.junit.Test;

public class WordSearchTest {

    @Test
    public void does_exist() {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        WordSearch wordSearch = new WordSearch();
        Assert.assertTrue(wordSearch.exist(board, "ABCCED"));
    }

    @Test
    public void non_exist() {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        WordSearch wordSearch = new WordSearch();
        Assert.assertFalse(wordSearch.exist(board, "ABCB"));
    }
}
