package leetcode;

import java.util.Arrays;

public class _0645_SetMismatch {
    static class Solution {
        public int[] findErrorNums(int[] nums) {
            int dup = -1;
            int miss = -1;
            final int n = nums.length;
            for (int i = 0; i < n; i++) {
                int index = Math.abs(nums[i]) - 1;
                if (nums[index] < 0) {
                    dup = Math.abs(nums[i]);
                } else {
                    nums[index] *= -1;
                }
            }

            for (int i = 0; i < n; i++) {
                if (nums[i] > 0) {
                    miss = i + 1;
                }
            }
            return new int[]{dup, miss};
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findErrorNums(new int[]{1, 2, 2, 4})));
    }
}
