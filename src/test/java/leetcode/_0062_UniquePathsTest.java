package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class _0062_UniquePathsTest {
    @Test
    public void test_case_1() {
        Assert.assertEquals(3, new _0062_UniquePaths().uniquePaths(3, 2));
    }

    @Test
    public void test_case_2() {
        Assert.assertEquals(28, new _0062_UniquePaths().uniquePaths(7, 3));
    }
}
