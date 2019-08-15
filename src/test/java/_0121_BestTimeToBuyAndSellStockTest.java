import org.junit.Assert;
import org.junit.Test;

public class _0121_BestTimeToBuyAndSellStockTest {
    @Test
    public void test_case1() {
        int[] prices = {7, 1, 5, 3, 6, 4};
        int expected = 5;
        Assert.assertEquals(expected, new _0121_BestTimeToBuyAndSellStock().maxProfit(prices));
    }

    @Test
    public void test_case2() {
        int[] prices = {10, 2, 9, 1, 2, 1, 3, 1};
        int expected = 7;
        Assert.assertEquals(expected, new _0121_BestTimeToBuyAndSellStock().maxProfit(prices));
    }
}
