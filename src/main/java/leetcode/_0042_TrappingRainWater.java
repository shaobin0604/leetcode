package leetcode;

public class _0042_TrappingRainWater {
    public int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int ans = 0;
        // 最两端的列不用考虑，因为一定不会有水。所以下标从 1 到 length - 2
        for (int i = 1; i < height.length - 1; i++) {
            int left = leftMax(height, i);
            int right = rightMax(height, i);

            ans += Math.max(Math.min(left, right) - height[i], 0);
        }

        return ans;
    }

    private int leftMax(int[] height, int pos) {
        int max = 0;
        for (int i = pos - 1; i >= 0; i--) {
            max = Math.max(height[i], max);
        }
        return max;
    }

    private int rightMax(int[] height, int pos) {
        int max = 0;
        for (int i = pos + 1; i < height.length; i++) {
            max = Math.max(height[i], max);
        }
        return max;
    }


    public int trap2(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }

        int ans = 0;

        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        for (int i = 1; i < height.length; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], height[i - 1]);
        }

        for (int i = height.length - 2; i >= 0; i--) {
            rightMax[i] = Math.max(rightMax[i + 1], height[i + 1]);
        }

        // 最两端的列不用考虑，因为一定不会有水。所以下标从 1 到 length - 2
        for (int i = 1; i < height.length - 1; i++) {
            int left = leftMax[i];
            int right = rightMax[i];

            ans += Math.max(Math.min(left, right) - height[i], 0);
        }

        return ans;
    }

    public int trap3(int[] height) {
        int len = height.length;
        // 特判
        if (len < 3) {
            return 0;
        }

        int res = 0;

        int leftMax = height[0];
        int rightMax = height[len - 1];

        // 注意初值的选取，前面做了特判，因此这里有效
        // 头和尾都不存雨水
        int left = 1;
        int right = len - 2;

        // 注意：这里是等于
        while (left <= right) {
            // 调试代码
            // System.out.println("left = " + left + " right = " + right + " leftMax = " + leftMax + " rightMax = " + rightMax+ " res = " + res );

            int minVal = Math.min(leftMax, rightMax);
            if (minVal == leftMax) {
                if (minVal > height[left]) {
                    res += minVal - height[left];
                }
                leftMax = Math.max(leftMax, height[left]);
                left++;
            } else {
                if (minVal > height[right]) {
                    res += minVal - height[right];
                }
                rightMax = Math.max(rightMax, height[right]);
                right--;
            }
        }
        return res;
    }
}
