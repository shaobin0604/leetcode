package aimoffer;

import org.junit.Assert;
import org.junit.Test;

public class _14_CuttingRopeTest {

    @Test
    public void test_case_1() {
        Assert.assertEquals(1, new _14_CuttingRope().integerBreak(2));
    }

    @Test
    public void test_case_2() {
        Assert.assertEquals(36, new _14_CuttingRope().integerBreak(10));
    }
}
