package leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class _0345_ReverseVowelsOfAString {
    static class Solution {
        public String reverseVowels(String s) {
            HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
            final char[] chars = s.toCharArray();

            int left = 0, right = chars.length - 1;

            while (left < right) {
                if (!vowels.contains(chars[left])) {
                    left++;
                } else if (!vowels.contains(chars[right])) {
                    right--;
                } else {
                    // swap left and right
                    char tmp = chars[left];
                    chars[left] = chars[right];
                    chars[right] = tmp;
                    left++;
                    right--;
                }
            }

            return new String(chars);
        }
    }
}
