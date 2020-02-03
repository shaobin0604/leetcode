package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _0216_CombinationSumIII {
    static class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<List<Integer>> result = new ArrayList<>();
            Stack<Integer> path = new Stack<>();
            backtrack(result, path, 1, k, n);
            return result;
        }

        private void backtrack(List<List<Integer>> result, Stack<Integer> path, int start, int k, int n) {
            if (n == 0 && k == 0) {
                result.add(new ArrayList<>(path));
                return;
            }

            if (n == 0 || k == 0) {
                return;
            }

            for (int i = start; i <= 9; i++) {
                if (i <= n) {
                    path.push(i);
                    backtrack(result, path, i + 1, k - 1, n - i);
                    path.pop();
                }
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combinationSum3(3, 7));
        System.out.println(new Solution().combinationSum3(3, 9));
    }
}
