package leetcode;

public class _0004_MedianOfTwoSortedArrays {
    static class Solution {
        // 合并两个数组解法，时间复杂度不复合要求
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int m = nums1.length;
            int n = nums2.length;
            int[] nums = new int[m + n];

            int i = 0;
            int j = 0;

            for (int k = 0; k < nums.length; k++) {
                if (i >= m) {
                    System.arraycopy(nums2, j, nums, k, n - j);
                    break;
                }

                if (j >= n) {
                    System.arraycopy(nums1, i, nums, k, m - i);
                    break;
                }

                if (nums1[i] < nums2[j]) {
                    nums[k] = nums1[i];
                    i++;
                } else {
                    nums[k] = nums2[j];
                    j++;
                }
            }

            if ((nums.length & 1) != 0) {
                // odd
                return nums[nums.length >>> 1];
            } else {
                // even
                int high = nums[nums.length >>> 1];
                int low = nums[(nums.length >>> 1) - 1];
                return low + (high - low)/2.0;
            }
        }
    }
}
