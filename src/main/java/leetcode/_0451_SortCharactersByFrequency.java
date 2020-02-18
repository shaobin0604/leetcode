package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0451_SortCharactersByFrequency {
    static class Solution {
        public String frequencySort(String s) {

            // key: num, value: count
            Map<Character, Integer> frequent = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                final char c = s.charAt(i);
                frequent.put(c, frequent.getOrDefault(c, 0) + 1);
            }

            List<Character>[] bucket = new List[s.length() + 1];
            for (Map.Entry<Character, Integer> entry : frequent.entrySet()) {
                final char key = entry.getKey();
                final Integer value = entry.getValue();
                if (bucket[value] == null) {
                    bucket[value] = new ArrayList<>();
                }
                bucket[value].add(key);
            }

            char[] result = new char[s.length()];
            int index = 0;
            for (int i = bucket.length - 1; i > 0; i--) {
                if (bucket[i] != null) {
                    for (char c : bucket[i]) {
                        for (int j = 0; j < i; j++) {
                            result[index++] = c;
                        }
                    }
                }
            }
            return new String(result);
        }
    }
}
