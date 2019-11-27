package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class _1143_LongestCommonSubsequenceTest {
    @Test
    public void test_case() {
        Assert.assertEquals(3, new _1143_LongestCommonSubsequence().longestCommonSubsequence("abcde", "ace"));

        Assert.assertEquals(3, new _1143_LongestCommonSubsequence().longestCommonSubsequence("abc", "abc"));

        Assert.assertEquals(0, new _1143_LongestCommonSubsequence().longestCommonSubsequence("abc", "def"));
    }
}
