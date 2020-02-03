package leetcode;

import org.junit.Assert;
import org.junit.Test;

public class _0125_ValidPalindromeTest {
    @Test
    public void should_true() {
        Assert.assertTrue(new _0125_ValidPalindrome.Solution().isPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test
    public void should_false() {
        Assert.assertFalse(new _0125_ValidPalindrome.Solution().isPalindrome("race a car"));
    }
}
