package leetcode;

public class _0309_BestTimeToBuyAndSellStockWithCoolDown {

    static class Solution {
        // 不限制交易次数
        public int maxProfit(int[] prices) {
            final int n = prices.length;

            if (n == 0) {
                return 0;
            }

            int[][] dp = new int[n][2];

            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    dp[0][0] = 0;
                    dp[0][1] = -prices[0];
                } else if (i == 1) {
                    dp[1][0] = Math.max(dp[0][0], dp[0][1] + prices[1]);
                    dp[1][1] = Math.max(dp[0][1], -prices[1]);
                } else {
                    dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                    dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i]);
                }
            }
            return dp[n - 1][0];
        }

    }
}
