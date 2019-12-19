package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class _0042_TrappingRainWaterTest {
    @Test
    public void test_case() {
        Assert.assertEquals(6, new _0042_TrappingRainWater().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        Assert.assertEquals(6, new _0042_TrappingRainWater().trap2(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        Assert.assertEquals(6, new _0042_TrappingRainWater().trap3(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
