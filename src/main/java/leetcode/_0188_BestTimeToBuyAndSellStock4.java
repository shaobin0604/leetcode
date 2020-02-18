package leetcode;

public class _0188_BestTimeToBuyAndSellStock4 {

    static class Solution {

        public int maxProfit(int k, int[] prices) {
            final int n = prices.length;
            if (n == 0) {
                return 0;
            }

            if (k > n / 2) {
                return maxProfit_k_inf(prices);
            }

            int[][][] dp = new int[n][k + 1][2];

            for (int i = 0; i < n; i++) {
                for (int j = k; j >= 1; j--) {
                    if (i == 0) {
                        dp[i][j][0] = 0;
                        dp[i][j][1] = -prices[i];
                    } else {
                        dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                        dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
                    }
                }
            }

            return dp[n - 1][k][0];
        }

        // 不限制交易次数
        private int maxProfit_k_inf(int[] prices) {
            final int n = prices.length;
            int[][] dp = new int[n][2];

            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    dp[i][0] = 0;
                    dp[i][1] = -prices[i];
                } else {
                    dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                    dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
                }
            }
            return dp[n - 1][0];
        }
    }
}
