package leetcode;

import java.util.Arrays;

public class _0123_BestTimeToBuyAndSellStock3 {

    static class Solution {

        public int maxProfit(int[] prices) {
            if (prices.length == 0) {
                return 0;
            }

            int k = 2;

            int[][][] dp = new int[prices.length][k + 1][2];

            for (int i = 0; i < prices.length; i++) {
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

            printDpTable(dp);

            return dp[prices.length - 1][k][0];
        }

        private void printDpTable(int[][][] dp) {
            for (int i = 0; i < dp.length; i++) {
                for (int j = 0; j < dp[i].length; j++) {
                    for (int k = 0; k < dp[i][j].length; k++) {
                        System.out.printf("dp[%d][%d][%d] = %d\n", i, j ,k, dp[i][j][k]);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new Solution().maxProfit(new int[] {7,6,4,3,1});
    }
}
