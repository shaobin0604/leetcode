package leetcode;

public class _0081_SearchInRotatedSortedArrayII {

    // https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii/solution/er-fen-cha-zhao-by-liweiwei1419/
    static class Solution {
        public boolean search(int[] nums, int target) {
            int n = nums.length;
            if (n == 0) {
                return false;
            }

            int left = 0;
            int right = n - 1;

            while (left < right) {
                int mid = (left + right) >>> 1;
                if (nums[left] < nums[mid]) {
                    // 左半部有序
                    if (nums[left] <= target && target <= nums[mid]) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                } else if (nums[left] > nums[mid]) {
                    // 右半部有序
                    if (nums[mid] < target && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                } else {
                    if (nums[left] == target) {
                        return true;
                    } else {
                        left = left + 1;
                    }
                }
            }

            return nums[left] == target;
        }
    }


}
