package leetcode;

public class _0011_ContainerWithMostWater {
    static class Solution {
        public int maxArea(int[] height) {
            int maxArea = 0;
            for (int i = 0; i < height.length - 1; i++) {
                for (int j = i + 1; j < height.length; j++) {
                    maxArea = Math.max(maxArea, Math.min(height[i], height[j]) * (j - i));
                }
            }
            return maxArea;
        }
    }

    // 双指针
    static class Solution2 {
        public int maxArea(int[] height) {
            int maxArea = 0;
            int lo = 0;
            int hi = height.length - 1;
            while (lo < hi) {
                maxArea = Math.max(maxArea, Math.min(height[lo], height[hi]) * (hi - lo));

                if (height[lo] < height[hi]) {
                    lo++;
                } else {
                    hi--;
                }
            }


            return maxArea;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
