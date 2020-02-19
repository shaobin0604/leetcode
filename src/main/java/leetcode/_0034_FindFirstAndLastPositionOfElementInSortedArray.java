package leetcode;

public class _0034_FindFirstAndLastPositionOfElementInSortedArray {
    static class Solution {
        public int[] searchRange(int[] nums, int target) {
            int len = nums.length;
            if (len == 0) {
                return new int[]{-1, -1};
            }

            int left = 0;
            int right = len - 1;

            // 查找左边界
            // “开始位置”：如果看到 mid 这个位置的数值等于目标值，不能确定它一定是“开始位置”，
            // 但是只要 nums[mid] 小于目标值，mid 以及 mid 的左边肯定不是“开始位置”，mid 的右边（不包括 mid ）有可能是“开始位置”，
            // mid 的右边的数“大于等于” target，因此“开始位置”是大于等于 target 的第 1 个数的索引；
            while (left < right) {
                int mid = (left + right) >>> 1;
                if (nums[mid] < target) {
                    // [mid + 1, right]
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            int first = nums[left] == target ? left : -1;

            if (first == -1) {
                return new int[]{-1, -1};
            }

            left = 0;
            right = len - 1;

            // 查找右边界
            // “结束位置”：如果看到 mid 这个位置的数值等于目标值，不能确定它一定是“结束位置”，
            // 但是只要 nums[mid] 大于目标值，mid 以及 mid 的右边肯定不是“结束位置”，mid 的左边（不包括 mid ）有可能是“结束位置”，
            // mid 的左边的数“小于等于” target，因此“结束位置”是小于等于 target 的最后 1 个数的索引。
            while (left < right) {
                int mid = (left + right + 1) >>> 1;
                if (nums[mid] > target) {
                    // [left, mid - 1]
                    right = mid - 1;
                } else {
                    left = mid;
                }
            }

            int last = left;

            return new int[]{first, last};
        }
    }
}
