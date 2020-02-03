package leetcode;

public class _0079_WordSearch {
    static class Solution {
        public boolean exist(char[][] board, String word) {
            if (board == null || board.length == 0) {
                return false;
            }

            final int row = board.length;
            final int col = board[0].length;

            boolean[][] visited = new boolean[row][col];

            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (backtrack(board, row, col, i, j, visited, 0, word)) {
                        return true;
                    }
                }
            }

            return false;
        }

        private boolean backtrack(char[][] board, int row, int col, int i, int j, boolean[][] visited, int index, String word) {
            if (i < 0 || i >= row || j < 0 || j >= col || visited[i][j] || board[i][j] != word.charAt(index)) {
                return false;
            }

            if (index == word.length() - 1) {
                return true;
            }

            visited[i][j] = true;

            if (backtrack(board, row, col, i, j + 1, visited, index + 1, word)
                    || backtrack(board, row, col, i + 1, j, visited, index + 1, word)
                    || backtrack(board, row, col, i, j - 1, visited, index + 1, word)
                    || backtrack(board, row, col, i - 1, j, visited, index + 1, word)) {
                return true;
            }

            visited[i][j] = false;

            return false;
        }
    }
}
