package aimoffer;

import java.util.PriorityQueue;

public class _40_GetLeastNumbers {
    static class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            // 大堆顶
            PriorityQueue<Integer> queue = new PriorityQueue<>(k + 1, (o1, o2) -> o2 - o1);
            for (int i = 0; i < arr.length; i++) {
                queue.offer(arr[i]);
                if (i >= k) {
                    queue.poll();
                }
            }
            int[] ans = new int[k];
            for (int i = 0; i < k && !queue.isEmpty(); i++) {
                ans[i] = queue.poll();
            }
            return ans;
        }
    }
}
