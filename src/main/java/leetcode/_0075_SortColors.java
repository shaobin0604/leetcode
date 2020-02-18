package leetcode;

public class _0075_SortColors {
    static class Solution {
        public void sortColors(int[] nums) {
            int p0 = 0, p = 0, p2 = nums.length - 1;
            while (p <= p2) {
                if (nums[p] == 2) {
                    swap(nums, p, p2);
                    p2--;
                } else if (nums[p] == 0) {
                    swap(nums, p, p0);
                    p++;
                    p0++;
                } else {
                    p++;
                }
            }
        }

        private void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }
    }
}
