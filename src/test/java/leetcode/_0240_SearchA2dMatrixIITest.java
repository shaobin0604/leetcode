package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class _0240_SearchA2dMatrixIITest {

    private static final int[][] MATRIX = new int[][]{
            {1, 4, 7, 11, 15},
            {2, 5, 8, 12, 19},
            {3, 6, 9, 16, 22},
            {10, 13, 14, 17, 24},
            {18, 21, 23, 26, 30}
    };

    @Test
    public void test_case() {

        Assert.assertTrue(new _0240_SearchA2dMatrixII().searchMatrix(MATRIX, 5));
        Assert.assertTrue(new _0240_SearchA2dMatrixII().searchMatrix(MATRIX, 1));
        Assert.assertTrue(new _0240_SearchA2dMatrixII().searchMatrix(MATRIX, 15));
        Assert.assertTrue(new _0240_SearchA2dMatrixII().searchMatrix(MATRIX, 30));
        Assert.assertTrue(new _0240_SearchA2dMatrixII().searchMatrix(MATRIX, 18));

        Assert.assertFalse(new _0240_SearchA2dMatrixII().searchMatrix(MATRIX, 20));
        Assert.assertFalse(new _0240_SearchA2dMatrixII().searchMatrix(MATRIX, 31));
    }

    @Test
    public void test_case_2() {

        Assert.assertTrue(new _0240_SearchA2dMatrixII().searchMatrix2(MATRIX, 5));
        Assert.assertTrue(new _0240_SearchA2dMatrixII().searchMatrix2(MATRIX, 1));
        Assert.assertTrue(new _0240_SearchA2dMatrixII().searchMatrix2(MATRIX, 15));
        Assert.assertTrue(new _0240_SearchA2dMatrixII().searchMatrix2(MATRIX, 30));
        Assert.assertTrue(new _0240_SearchA2dMatrixII().searchMatrix2(MATRIX, 18));

        Assert.assertFalse(new _0240_SearchA2dMatrixII().searchMatrix2(MATRIX, 20));
        Assert.assertFalse(new _0240_SearchA2dMatrixII().searchMatrix2(MATRIX, 31));
    }
}
