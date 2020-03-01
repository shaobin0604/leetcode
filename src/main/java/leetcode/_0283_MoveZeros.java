package leetcode;

public class _0283_MoveZeros {
    static class Solution {
        public void moveZeroes(int[] nums) {
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    nums[index] = nums[i];
                    index++;
                }
            }

            for (int i = index; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }

    static class Solution2 {
        public void moveZeroes(int[] nums) {
            int index = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    int tmp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = tmp;
                    index++;
                }
            }
        }
    }
}
