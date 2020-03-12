package leetcode;

import java.util.Arrays;

public class _0016_3SumClosest {
    static class Solution {
        public int threeSumClosest(int[] nums, int target) {
            Arrays.sort(nums);
            int sub = Integer.MAX_VALUE; //保存和 target 的差值
            int sum = 0; //保存当前最接近 target 的三个数的和
            for (int i = 0; i < nums.length; i++) {
                int lo = i + 1;
                int hi = nums.length - 1;
                while (lo < hi) {
                    if (Math.abs(nums[i] + nums[lo] + nums[hi] - target) < sub) {
                        sum = nums[i] + nums[lo] + nums[hi];
                        sub = Math.abs(sum - target);
                    }

                    if (nums[i] + nums[lo] + nums[hi] > target) {
                        hi--;
                    } else {
                        lo++;
                    }
                }
            }
            return sum;
        }
    }

    // 暴力三重循环解
    static class Solution2 {
        public int threeSumClosest(int[] nums, int target) {
            int sub = Integer.MAX_VALUE; //保存和 target 的差值
            int sum = 0; //保存当前最接近 target 的三个数的和
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++)
                    for (int k = j + 1; k < nums.length; k++) {
                        if (Math.abs((nums[i] + nums[j] + nums[k] - target)) < sub) {
                            sum = nums[i] + nums[j] + nums[k];
                            sub = Math.abs(sum - target);
                        }
                    }
            }
            return sum;
        }
    }
}
