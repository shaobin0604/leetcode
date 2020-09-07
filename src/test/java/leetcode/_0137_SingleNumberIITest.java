package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class _0137_SingleNumberIITest {
    @Test
    public void test1() throws Exception {
        Assert.assertEquals(3, new _0137_SingleNumberII().singleNumber(new int[]{2, 2, 3, 2}));
    }

    @Test
    public void test2() throws Exception {
        Assert.assertEquals(99, new _0137_SingleNumberII().singleNumber(new int[]{0, 1, 0, 1, 0, 1, 99}));
    }
}
