package leetcode;

public class _0680_ValidPalindromeII {
    static class Solution {
        public boolean validPalindrome(String s) {
            if (s == null) {
                return false;
            }

            if (s.length() == 0) {
                return true;
            }

            final char[] chars = s.toCharArray();

            int i = 0, j = chars.length - 1;

            while (i < j && chars[i] == chars[j]) {
                i++;
                j--;
            }

            if (isValid(chars, i + 1, j)) {
                return true;
            }

            if (isValid(chars, i, j - 1)) {
                return true;
            }

            return false;
        }

        private boolean isValid(char[] chars, int i, int j) {
            while (i < j) {
                if (chars[i] != chars[j]) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }
    }
}
