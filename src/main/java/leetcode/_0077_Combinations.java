package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _0077_Combinations {

    static class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> result = new ArrayList<>();
            Stack<Integer> path = new Stack<>();
            backtrack(result, path, 1, n, k);
            return result;
        }

        private void backtrack(List<List<Integer>> result, Stack<Integer> path, int start, int n, int k) {
            if (path.size() == k) {
                result.add(new ArrayList<>(path));
                return;
            }

            // i <= n
            for (int i = start; i <= n - (k - path.size()) + 1; i++) {
                path.push(i);
                backtrack(result, path, i + 1, n, k);
                path.pop();
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().combine(4, 2));
    }
}
