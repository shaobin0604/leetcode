package leetcode;

import java.util.List;

public class _0524_LongestWordInDictionaryThroughDeleting {
    static class Solution {
        public String findLongestWord(String s, List<String> d) {
            String longestWord = "";
            for (String t : d) {
                int l1 = longestWord.length(), l2 = t.length();
                if (l2 < l1 || (l2 == l1 && longestWord.compareTo(t) < 0)) {
                    continue;
                }
                if (isSubsequence(s, t)) {
                    longestWord = t;
                }
            }
            return longestWord;
        }

        private boolean isSubsequence(String s, String t) {
            int i = 0, j = 0;
            int sLen = s.length(), tLen = t.length();
            while (i < sLen && j < tLen) {
                if (s.charAt(i) == t.charAt(j)) {
                    j++;
                }
                i++;
            }
            return j == tLen;
        }
    }
}
