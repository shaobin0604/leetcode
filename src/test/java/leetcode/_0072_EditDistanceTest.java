package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class _0072_EditDistanceTest {
    @Test
    public void test_case() {
        Assert.assertEquals(3, new _0072_EditDistance().minDistance("horse", "ros"));
        Assert.assertEquals(5, new _0072_EditDistance().minDistance("intention", "execution"));
    }
}
