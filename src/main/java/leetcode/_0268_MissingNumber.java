package leetcode;

public class _0268_MissingNumber {
    static class Solution {
        public int missingNumber(int[] nums) {
            int n = nums.length;
            int actualSum = 0;
            int expectedSum = 0;
            for (int i = 0; i < n; i++) {
                actualSum += nums[i];
                expectedSum += i;
            }
            expectedSum += n;

            return expectedSum - actualSum;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.missingNumber(new int[]{3, 0, 1}));
        System.out.println(s.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
    }
}
