package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _0039_CombinationSum {
    static class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();
            backtrack(result, stack, 0, candidates, 0, target);
            return result;
        }

        private void backtrack(List<List<Integer>> result, Stack<Integer> selection, int start, int[] candidates, int sum, int target) {
            if (sum == target) {
                result.add(new ArrayList<>(selection));
                return;
            }

            // 只选后面的元素，消除重复
            for (int i = start; i < candidates.length; i++) {
                if (candidates[i] + sum <= target) {
                    selection.push(candidates[i]);
                    backtrack(result, selection, i, candidates, sum + candidates[i], target);
                    selection.pop();
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum(new int[] {2, 3, 6, 7}, 7));
    }
}
