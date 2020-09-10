package leetcode;

import java.util.HashMap;
import java.util.Map;

public class _0409_LongestPalindrome {
    static class Solution {
        public int longestPalindrome(String s) {
            Map<Character, Integer>  counts = new HashMap<>(26 * 2);
            for (int i = 0; i < s.length(); i++) {
                final char c = s.charAt(i);
                counts.put(c, counts.getOrDefault(c, 0) + 1);
            }

            int ans = 0;
            boolean hasOdd = false;
            for (Map.Entry<Character, Integer> entry : counts.entrySet()) {
                final Integer value = entry.getValue();
                if ((value & 1) == 1) {
                    if (hasOdd) {
                        ans += (value - 1);
                    } else {
                        ans += value;
                        hasOdd = true;
                    }
                } else {
                    ans += value;
                }
            }
            return ans;
        }
    }
}
