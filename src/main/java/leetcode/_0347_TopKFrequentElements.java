package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _0347_TopKFrequentElements {
    static class Solution {
        public List<Integer> topKFrequent(int[] nums, int k) {
            List<Integer> result = new ArrayList<>();

            // key: num, value: count
            Map<Integer, Integer> frequent = new HashMap<>();
            for (int num : nums) {
                frequent.put(num, frequent.getOrDefault(num, 0) + 1);
            }

            List<Integer>[] bucket = new List[nums.length + 1];
            for (Map.Entry<Integer, Integer> entry : frequent.entrySet()) {
                final Integer key = entry.getKey();
                final Integer value = entry.getValue();
                if (bucket[value] == null) {
                    bucket[value] = new ArrayList<>();
                }
                bucket[value].add(key);
            }

            for (int i = bucket.length - 1; i >=0 && result.size() < k; i--) {
                if (bucket[i] != null) {
                    result.addAll(bucket[i]);
                }
            }
            if (result.size() > k) {
                return result.subList(0, k - 1);
            } else {
                return result;
            }
        }
    }
}
