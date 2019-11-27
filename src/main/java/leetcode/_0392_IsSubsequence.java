package leetcode;

public class _0392_IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        int i = 0, j = 0;
        int sLen = s.length();
        int tLen = t.length();
        while (i < sLen && j < tLen) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == sLen;
    }

}
