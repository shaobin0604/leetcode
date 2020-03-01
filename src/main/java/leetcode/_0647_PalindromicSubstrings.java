package leetcode;

public class _0647_PalindromicSubstrings {
    static class Solution {
        public int countSubstrings(String s) {
            int count = 0;
            final int length = s.length();

            if (length < 2) {
                return length;
            }

            final char[] chars = s.toCharArray();
            for (int i = 0; i < length; i++) {
                count += expandPalindrome(chars, i, i);
                count += expandPalindrome(chars, i, i + 1);
            }
            return count;
        }

        private int expandPalindrome(char[] s, int i, int j) {
            int len = s.length;
            int left = i;
            int right = j;
            int count = 0;

            while (left >= 0 && right < len && s[left] == s[right]) {
                left--;
                right++;
                count++;
            }

            return count;
        }
    }
}
