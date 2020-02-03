package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class _0040_CombinationSumII {
    static class Solution {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Stack<Integer> path = new Stack<>();
            Arrays.sort(candidates);
            backtrack(result, path, 0, candidates, target);
            return result;
        }

        private void backtrack(List<List<Integer>> result, Stack<Integer> path, int start, int[] candidates, int target) {
            if (target == 0) {
                result.add(new ArrayList<>(path));
                return;
            }

            if (target < 0) {
                return;
            }

            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }

                if (candidates[i] <= target) {
                    path.push(candidates[i]);
                    backtrack(result, path, i + 1, candidates, target - candidates[i]);
                    path.pop();
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum2(new int[] {10,1,2,7,6,1,5}, 8));
        System.out.println(new Solution().combinationSum2(new int[] {2,5,2,1,2}, 5));
    }
}
