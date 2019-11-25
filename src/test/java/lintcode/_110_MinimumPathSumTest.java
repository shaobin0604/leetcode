package lintcode;

import org.junit.Assert;
import org.junit.Test;

public class _110_MinimumPathSumTest {
    @Test
    public void test_case_1() {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1},
        };

        Assert.assertEquals(7, new _110_MinimumPathSum().minPathSum(grid));
    }

    @Test
    public void test_case_2() {
        int[][] grid = {
                {1, 3, 2},
        };

        Assert.assertEquals(6, new _110_MinimumPathSum().minPathSum(grid));
    }
}

