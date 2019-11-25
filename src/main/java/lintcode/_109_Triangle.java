package lintcode;

import java.util.Map;

public class _109_Triangle {
    /**
     * @param triangle: a list of lists of integers
     * @return: An integer, minimum path sum
     */
    public int minimumTotal(int[][] triangle) {
        // write your code here

        final int row = triangle.length;
        final int col = triangle[row - 1].length;
        // dp[i][j] 表示到达 triangle[i][j] 的最小值
        int[][] dp = new int[row][col];

        dp[0][0] = triangle[0][0];
        for (int i = 1; i < row; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                  dp[i][j] = dp[i - 1][j] + triangle[i][j];
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int j = 0; j < col; j++) {
            min = Math.min(min, dp[row - 1][j]);
        }
        return min;
    }
}
