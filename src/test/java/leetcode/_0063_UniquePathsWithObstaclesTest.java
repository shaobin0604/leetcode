package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class _0063_UniquePathsWithObstaclesTest {
    @Test
    public void test_case_1() {
        Assert.assertEquals(2, new _0063_UniquePathsWithObstacles().uniquePathsWithObstacles(new int[][]{
                {0, 0, 0,},
                {0, 1, 0,},
                {0, 0, 0,},
        }));
    }

    @Test
    public void test_case_2() {
        Assert.assertEquals(0, new _0063_UniquePathsWithObstacles().uniquePathsWithObstacles(new int[][]{
                {0, 1,},
        }));
    }
}
