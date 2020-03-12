package leetcode;

import java.util.Arrays;

public class _0322_CoinChange {
    static class Solution {
        public int coinChange(int[] coins, int amount) {
            int[] dp = new int[amount + 1];
            Arrays.fill(dp, amount + 1);
            dp[0] = 0;
            for (int i = 1; i <= amount; i++) {
                for (int j = 0; j < coins.length; j++) {
                    if (coins[j] <= i) {
                        dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                    }
                }
            }

            // dp[i] == amount + 1 说明凑不出来
            return dp[amount] == amount + 1 ? -1 : dp[amount];
        }
    }
}
