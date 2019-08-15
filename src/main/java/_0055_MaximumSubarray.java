// https://zh.wikipedia.org/wiki/%E6%9C%80%E5%A4%A7%E5%AD%90%E6%95%B0%E5%88%97%E9%97%AE%E9%A2%98
public class _0055_MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int currSum = 0;
        int maxSum = nums[0];       //全负情况，返回最大数

        int begin = 0;
        int end = 0;

        for (int j = 0; j < nums.length; j++) {
            if (nums[j] > currSum + nums[j]) {
                currSum = nums[j];
                begin = j;
            } else {
                currSum += nums[j];
            }

            if (currSum > maxSum) {
                maxSum = currSum;
                end = j;
            }
        }

        System.out.println("begin: " + begin + ", end: " + end);

        return maxSum;
    }
}
