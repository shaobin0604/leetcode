package leetcode;

import org.junit.Assert;
import org.junit.Test;

import leetcode._0122_BestTimeToBuyAndSellStock2;

public class _0122_BestTimeToBuyAndSellStock2Test {
    @Test
    public void test_case1() {
        int[] input = {7, 1, 5, 3, 6, 4};
        int expected = 7;
        Assert.assertEquals(expected, new _0122_BestTimeToBuyAndSellStock2.Solution().maxProfit(input));
    }

    @Test
    public void test_case2() {
        int[] input = {1, 2, 3, 4, 5};
        int expected = 4;
        Assert.assertEquals(expected, new _0122_BestTimeToBuyAndSellStock2.Solution().maxProfit(input));
    }

    @Test
    public void test_case3() {
        int[] input = {7, 6, 4, 3, 1};
        int expected = 0;
        Assert.assertEquals(expected, new _0122_BestTimeToBuyAndSellStock2.Solution().maxProfit(input));
    }

    @Test
    public void test_case4() {
        int[] input = {1, 7, 2, 3, 6, 7, 6, 7};
        int expected = 12;
        Assert.assertEquals(expected, new _0122_BestTimeToBuyAndSellStock2.Solution().maxProfit(input));
    }
}
