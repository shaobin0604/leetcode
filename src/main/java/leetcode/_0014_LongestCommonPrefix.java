package leetcode;

public class _0014_LongestCommonPrefix {
    static class Solution {
        public String longestCommonPrefix(String[] strs) {
            if (strs.length == 0) {
                return "";
            }

            int i = 0;
            outer:
            while (true) {
                if (i == strs[0].length()) {
                    break;
                }

                char c = strs[0].charAt(i);
                for (int j = 1; j < strs.length; j++) {
                    if (i == strs[j].length() || strs[j].charAt(i) != c) {
                        break outer;
                    }
                }
                i++;
            }
            return strs[0].substring(0, i);
        }
    }
}
