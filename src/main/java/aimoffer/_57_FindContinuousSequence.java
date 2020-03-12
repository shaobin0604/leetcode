package aimoffer;

import java.util.ArrayList;
import java.util.List;

public class _57_FindContinuousSequence {
    static class Solution {
        public int[][] findContinuousSequence(int target) {
            List<int[]> ans = new ArrayList<>();
            int lo = 1;
            int hi = 2;
            int max = target / 2 + 1;
            while (lo < hi && hi <= max) {
                int sum = (lo + hi) * (hi - lo + 1) / 2;
                if (sum == target) {
                    ans.add(toArray(lo, hi));
                    lo++;
                } else if (sum < target) {
                    hi++;
                } else {
                    lo++;
                }
            }

            int[][] ret = new int[ans.size()][];
            for (int i = 0; i < ret.length; i++) {
                ret[i] = ans.get(i);
            }
            return ret;
        }

        private int[] toArray(int start, int end) {
            int[] ans = new int[end - start + 1];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = start + i;
            }
            return ans;
        }
    }
}
