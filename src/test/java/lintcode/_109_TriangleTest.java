package lintcode;

import org.junit.Assert;
import org.junit.Test;

public class _109_TriangleTest {

    @Test
    public void test_case_1() {
        final int[][] triangle = {
                {2},
                {3, 4},
                {6, 5, 7},
                {4, 1, 8, 3}
        };

        Assert.assertEquals(11, new _109_Triangle().minimumTotal(triangle));
    }

    @Test
    public void test_case_2() {
        final int[][] triangle = {
                {2},
                {3, 2},
                {6, 5, 7},
                {4, 4, 8, 1}
        };

        Assert.assertEquals(12, new _109_Triangle().minimumTotal(triangle));
    }
}
