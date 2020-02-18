package leetcode;

public class _0714_BestTimeToBuyAndSellStockWithTransactionFee {

    static class Solution {
        // 不限制交易次数
        public int maxProfit(int[] prices, int fee) {
            final int n = prices.length;
            int[][] dp = new int[n][2];

            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    dp[i][0] = 0;
                    dp[i][1] = -prices[i] - fee;
                } else {
                    dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
                    dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i] - fee);
                }
            }
            return dp[n - 1][0];
        }

    }

    static class Solution2 {
        private static class Node {
            int profit;

            // -1 买入，0 持有，1 售出
            int operation;

            Node parent;

            public Node(int profit, int operation, Node parent) {
                this.profit = profit;
                this.operation = operation;
                this.parent = parent;
            }
        }

        // 不限制交易次数
        public int maxProfit(int[] prices, int fee) {
            final int n = prices.length;
            Node[][] dp = new Node[n][2];

            for (int i = 0; i < n; i++) {
                if (i == 0) {
                    dp[i][0] = new Node(0, 0, null);
                    dp[i][1] = new Node(-prices[i] - fee, -1, null);
                } else {
                    if (dp[i - 1][0].profit > dp[i - 1][1].profit + prices[i]) {
                        dp[i][0] = new Node(dp[i - 1][0].profit, 0, dp[i - 1][0]);
                    } else {
                        dp[i][0] = new Node(dp[i - 1][1].profit + prices[i], 1, dp[i - 1][1]);
                    }

                    if (dp[i - 1][1].profit > dp[i - 1][0].profit - prices[i] - fee) {
                        dp[i][1] = new Node(dp[i - 1][1].profit, 0, dp[i - 1][1]);
                    } else {
                        dp[i][1] = new Node(dp[i - 1][0].profit - prices[i] - fee, -1, dp[i - 1][0]);
                    }
                }
            }

            Node node = dp[n - 1][0];
            int i = n - 1;
            while (node != null && i >= 0) {
                System.out.printf("price[%d] = %d, operation: %d\n", i, prices[i], node.operation);
                i--;
                node = node.parent;
            }

            return dp[n - 1][0].profit;
        }

    }

    public static void main(String[] args) {
        new Solution2().maxProfit(new int[] {1, 3, 2, 8, 4, 9}, 2);
    }
}
