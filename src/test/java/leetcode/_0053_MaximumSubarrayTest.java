package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class _0053_MaximumSubarrayTest {
    @Test
    public void test_case1() {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int expected = 6;
        Assert.assertEquals(expected, new _0053_MaximumSubarray.Solution2().maxSubArray(nums));
    }

    @Test
    public void test_case2() {
        int[] nums = {-1};
        int expected = -1;
        Assert.assertEquals(expected, new _0053_MaximumSubarray.Solution2().maxSubArray(nums));
    }
}
