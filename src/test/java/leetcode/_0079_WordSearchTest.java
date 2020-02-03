package leetcode;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class _0079_WordSearchTest {

    private _0079_WordSearch.Solution solution;
    private static final char[][] BOARD = new char[][]{
            {'A', 'B', 'C', 'E'},
            {'S', 'F', 'C', 'S'},
            {'A', 'D', 'E', 'E'},
    };

    @Before
    public void setup() {
        solution = new _0079_WordSearch.Solution();
    }

    @Test
    public void test_case_1() {
        Assert.assertTrue(solution.exist(BOARD, "ABCCED"));
    }

    @Test
    public void test_case_2() {
        Assert.assertTrue(solution.exist(BOARD, "SEE"));
    }

    @Test
    public void test_case_3() {
        Assert.assertFalse(solution.exist(BOARD, "ABCB"));
    }
}
