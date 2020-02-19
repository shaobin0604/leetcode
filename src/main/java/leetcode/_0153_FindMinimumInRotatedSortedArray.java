package leetcode;

public class _0153_FindMinimumInRotatedSortedArray {
    // https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/solution/er-fen-fa-fen-zhi-fa-python-dai-ma-java-dai-ma-by-/
    static class Solution {
        public int findMin(int[] nums) {
            int n = nums.length;
            int left = 0;
            int right = n - 1;
            while (left < right) {
                int mid = (left + right) >>> 1;

                if (nums[mid] < nums[right]) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return nums[left];
        }
    }
}
