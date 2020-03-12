package leetcode;

public class _1071_GreatestCommonDivisorOfStrings {
    static class Solution {
        public String gcdOfStrings(String str1, String str2) {
            if (!(str1 + str2).equals(str2 + str1)) {
                return "";
            }

            int len1 = str1.length();
            int len2 = str2.length();

            int len = len1 > len2 ? gcd(len1, len2) : gcd(len2, len1);

            return str1.substring(0, len);
        }

        // a should larger than b
        private int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }
    }
}
