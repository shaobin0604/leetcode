package leetcode;

import org.jetbrains.annotations.NotNull;

public class _0063_UniquePathsWithObstacles {
    public int uniquePathsWithObstacles(@NotNull int[][] obstacleGrid) {
        final int n = obstacleGrid.length, m = obstacleGrid[0].length;
        // dp[i][j] 表示终点为 (i, j) 路径数量
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 && j == 0) {
                    if (obstacleGrid[i][j] == 1) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = 1;
                    }
                } else if (i == 0) {
                    if (obstacleGrid[i][j - 1] == 1 || obstacleGrid[i][j] == 1) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = dp[i][j - 1];
                    }
                } else if (j == 0) {
                    if (obstacleGrid[i - 1][j] == 1 || obstacleGrid[i][j] == 1) {
                        dp[i][j] = 0;
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                } else {
                    if (obstacleGrid[i][j - 1] == 1 && obstacleGrid[i - 1][j] == 1  || obstacleGrid[i][j] == 1) {
                        dp[i][j] = 0;
                    } else if (obstacleGrid[i][j - 1] == 1 ) {
                        dp[i][j] = dp[i - 1][j];
                    } else if (obstacleGrid[i - 1][j] == 1) {
                        dp[i][j] = dp[i][j - 1];
                    } else {
                        dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                    }
                }
            }
        }
        return dp[n - 1][m - 1];
    }
}
