package Trie;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        if (board == null || word == null) {
            return false;
        }
        if (word.length() == 0) {
            return true;
        }
        char[] letters = word.toCharArray();
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                if (exist(board, row, column, letters, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean exist(char[][] board, int row, int column, char[] letters, int index) {
        if (board[row][column] != letters[index]) {
            return false;
        }
        char save = board[row][column];
        board[row][column] = 0;
        if ((index == letters.length - 1) ||
                (row > 0 && exist(board, row - 1, column, letters, index + 1)) ||
                (column > 0 && exist(board, row, column - 1, letters, index + 1)) ||
                (row < board.length - 1 && exist(board, row + 1, column, letters, index + 1)) ||
                (column < board[0].length - 1 && exist(board, row, column + 1, letters, index + 1))) {
            return true;
        }
        board[row][column] = save;
        return false;
    }
}
