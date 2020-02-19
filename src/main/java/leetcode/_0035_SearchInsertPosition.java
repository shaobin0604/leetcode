package leetcode;

public class _0035_SearchInsertPosition {
    static class Solution {
        public int searchInsert(int[] nums, int target) {
            final int len = nums.length;
            if (len == 0) {
                return 0;
            }
            int low = 0;
            int high = len - 1;

            if (nums[len - 1] < target) {
                return len;
            }

            while (low < high) {
                int mid = (low + high) >>> 1;
                // 严格小于 target 的元素一定不是解
                if (nums[mid] < target) {
                    // 下一轮搜索区间是 [mid + 1, high]
                    low = mid + 1;
                } else {
                    // 下一轮搜索区间是 [low, mid]
                    high = mid;
                }
            }

            return low;
        }
    }
}
