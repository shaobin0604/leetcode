package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0022_GenerateParentheses {
    static class Solution {
        public List<String> generateParenthesis(int n) {
            List<String> result = new ArrayList<>();
            backtrack(result, 0, 0, n, "");
            return result;
        }

        private void backtrack(List<String> result, int open, int close, int n, String str) {
            if (open == close && close == n) {
                result.add(str);
                return;
            }

            if (open < n) {
                backtrack(result, open + 1, close, n, str + "(");
            }

            if (close < open) {
                backtrack(result, open, close + 1, n, str + ")");
            }

        }
    }

    public static void main(String[] args) {
        final Solution solution = new Solution();

        System.out.println(solution.generateParenthesis(3));
    }
}
