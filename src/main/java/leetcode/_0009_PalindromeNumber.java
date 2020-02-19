package leetcode;

public class _0009_PalindromeNumber {
    static class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0 || x % 10 == 0 && x != 0) {
                return false;
            }

            int reverseNum = 0;

            while (x > reverseNum) {
                reverseNum = reverseNum * 10 + x % 10;
                x = x / 10;
            }

            // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
            // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
            // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
            return x == reverseNum || x == reverseNum / 10;
        }
    }
}
