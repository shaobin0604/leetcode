package leetcode;

import java.util.Arrays;

public class _0213_HouseRobberII {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0];
        }

        // 不偷最后一间
        final int p1 = rob2(Arrays.copyOfRange(nums, 0, nums.length - 1));
        // 不偷第一间
        final int p2 = rob2(Arrays.copyOfRange(nums, 1, nums.length));
        return Math.max(p1, p2);
    }

    private int rob2(int[] num) {
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
