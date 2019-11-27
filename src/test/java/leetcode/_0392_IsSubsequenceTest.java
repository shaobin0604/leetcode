package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class _0392_IsSubsequenceTest {
    @Test
    public void test_case_1() {
        Assert.assertTrue(new _0392_IsSubsequence().isSubsequence("abc", "ahbgdc"));
    }

    @Test
    public void test_case_2() {
        Assert.assertFalse(new _0392_IsSubsequence().isSubsequence("axc", "ahbgdc"));
    }
}
