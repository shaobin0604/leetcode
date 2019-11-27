package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class _0746_MinCostClimbingStairsTest {

    @Test
    public void test_case_1() {
        Assert.assertEquals(15, new _0746_MinCostClimbingStairs().minCostClimbingStairs(new int[] {10, 15, 20}));
        Assert.assertEquals(6, new _0746_MinCostClimbingStairs().minCostClimbingStairs(new int[] {1, 100, 1, 1, 1, 100, 1, 1 , 100, 1}));
    }
}
