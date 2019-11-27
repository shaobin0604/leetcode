package leetcode;

public class _0198_HouseRobber {
    public int rob(int[] nums) {
        if (nums == null) {
            return 0;
        }

        final int n = nums.length;
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return nums[0];
        }

        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            // 做选择：是否抢劫 nums[i]
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[n - 1];
    }

    public int rob2(int[] num) {
        int prevMax = 0;
        int currMax = 0;
        for (int x : num) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }
        return currMax;
    }
}
