package leetcode;

public class _0122_BestTimeToBuyAndSellStock2 {

    static class Solution {

        public int maxProfit(int[] prices) {
            int profit = 0;
            int i = 1;
            while (i < prices.length) {
                if (prices[i] > prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
                i++;
            }
            return profit;
        }
    }

    static class Solution2 {
        public int maxProfit(int[] prices) {
            int i = 0;
            int valley = prices[0];
            int peak = prices[0];
            int maxprofit = 0;
            while (i < prices.length - 1) {
                while (i < prices.length - 1 && prices[i] >= prices[i + 1])
                    i++;
                valley = prices[i];
                while (i < prices.length - 1 && prices[i] <= prices[i + 1])
                    i++;
                peak = prices[i];
                maxprofit += peak - valley;
            }
            return maxprofit;
        }
    }

    static class Solution3 {
        public int maxProfit(int[] prices) {
            if (prices.length == 0) {
                return 0;
            }

            int dp0 = 0, dp1 = -prices[0];

            for (int i = 1; i < prices.length; i++) {
                dp0 = Math.max(dp0, dp1 + prices[i]);
                dp1 = Math.max(dp1, dp0 - prices[i]);
            }

            return dp0;
        }
    }
}
