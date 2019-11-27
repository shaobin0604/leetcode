package leetcode;

public class _0746_MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length < 2) {
            return 0;
        }
        final int n = cost.length;
        final int[] dp = new int[n];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for (int i = 2; i < n; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }

        return Math.min(dp[n - 1], dp[n - 2]);
    }

    public int minCostClimbingStairs2(int[] cost) {
        if (cost == null || cost.length < 2) {
            return 0;
        }
        final int n = cost.length;
        int f;
        int f2 = cost[0];
        int f1 = cost[1];
        for (int i = 2; i < n; i++) {
            f = Math.min(f1, f2) + cost[i];
            f2 = f1;
            f1 = f;
        }

        return Math.min(f1, f2);
    }

}
