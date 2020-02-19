package leetcode;

public class _0154_FindMinimumInRotatedSortedArrayII {
    static class Solution {
        public int findMin(int[] nums) {
            int n = nums.length;
            int left = 0;
            int right = n - 1;
            while (left < right) {
                int mid = (left + right) >>> 1;

                if (nums[mid] < nums[right]) {
                    right = mid;
                } else if (nums[mid] > nums[right]) {
                    left = mid + 1;
                } else {
                    right--;
                }
            }
            return nums[left];
        }
    }
}
