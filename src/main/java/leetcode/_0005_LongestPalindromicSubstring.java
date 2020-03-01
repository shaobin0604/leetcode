package leetcode;

public class _0005_LongestPalindromicSubstring {
    static class Solution {
        public String longestPalindrome(String s) {
            final char[] chars = s.toCharArray();
            if (chars.length == 0) {
                return "";
            }

            final int len = chars.length;
            String longestPalindrome = s.substring(0, 1);

            for (int i = 0; i < len; i++) {
                String oddStr = expandPalindrome(chars, i, i);
                String evenStr = expandPalindrome(chars, i, i + 1);

                String maxStr = oddStr.length() > evenStr.length() ? oddStr : evenStr;
                if (maxStr.length() > longestPalindrome.length()) {
                    longestPalindrome = maxStr;
                }
            }
            return longestPalindrome;
        }

        private String expandPalindrome(char[] s, int i, int j) {
            int len = s.length;
            int left = i;
            int right = j;

            while (left >= 0 && right < len && s[left] == s[right]) {
                left--;
                right++;
            }

            return new String(s, left+ 1, right - left - 1);
        }
    }
}
