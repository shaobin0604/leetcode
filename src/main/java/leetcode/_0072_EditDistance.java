package leetcode;

import org.jetbrains.annotations.NotNull;

public class _0072_EditDistance {
    public int minDistance(@NotNull String word1, @NotNull String word2) {
        final int len1 = word1.length(), len2 = word2.length();
        // dp[i][j] 表示的是子问题 word1(0..i), word2(0..j) 的答案
        final int[][] dp = new int[len1 + 1][len2 + 1];
        // 这里有一个初始化，就是当一个字符串是空串的时候，转化只能通过添加元素或是删除元素来达成，那这里状态数组中存的值其实是和非空字符串的字符数量保持一致。
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = i;
        }

        for (int j = 1; j <= len2; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1])) + 1;
                }
            }
        }
        return dp[len1][len2];
    }
}
