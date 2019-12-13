package aimoffer;

public class _47_MaxValueOfGifts {
    public int getMost(int[][] board) {
        // write code here
        final int row = board.length, col = board[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = board[0][0];
        for (int i = 1; i < row; i++) {
            dp[i][0] = dp[i - 1][0] + board[i][0];
        }
        for (int j = 1; j < col; j++) {
            dp[0][j] = dp[0][j - 1] + board[0][j];
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + board[i][j];
            }
        }
        return dp[row - 1][col - 1];
    }
}
