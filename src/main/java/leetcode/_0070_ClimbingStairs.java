package leetcode;

public class _0070_ClimbingStairs {
    public int climbStairs(int n) {
        if (n < 1) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <=n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int climbStairsRecursive(int n) {
        if (n < 1) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        }
        return climbStairsRecursive(n - 1) + climbStairsRecursive(n - 2);
    }
}
