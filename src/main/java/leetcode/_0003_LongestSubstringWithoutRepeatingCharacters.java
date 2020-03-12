package leetcode;

import java.util.HashSet;
import java.util.Set;

public class _0003_LongestSubstringWithoutRepeatingCharacters {

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            int n = s.length();
            int ans = 0;
            int i = 0, j = 0;
            Set<Character> chars = new HashSet<>();
            while (i < n && j < n) {
                if (chars.contains(s.charAt(j))) {
                    chars.remove(s.charAt(i));
                    i++;
                } else {
                    chars.add(s.charAt(j));
                    j++;
                    ans = Math.max(ans, j - i);
                }
            }
            return ans;
        }
    }

    // 动态规划 超过内存限制
    static class Solution2 {
        public int lengthOfLongestSubstring(String s) {
            final char[] chars = s.toCharArray();
            final int n = chars.length;

            // dp[i][j] 以 i 开头，j 结尾的子串是否不重复
            boolean[][] dp = new boolean[n][n];

            for (int i = 0; i < n; i++) {
                dp[i][i] = true;
            }

            for (int i = 0; i < n - 1; i++) {
                for (int j = i + 1; j < n; j++) {
                    if (dp[i][j - 1]) {
                        dp[i][j] = !contains(chars, i, j - 1, chars[j]);
                    } else {
                        dp[i][j] = false;
                    }
                }
            }

            int max = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i; j < n; j++) {
                    if (dp[i][j]) {
                        max = Math.max(max, j - i + 1);
                    }
                }
            }
            return max;
        }

        private boolean contains(char[] chars, int i, int j, char s) {
            while (i <= j) {
                if (chars[i] == s) {
                    return true;
                }
                i++;
            }
            return false;
        }
    }
}
