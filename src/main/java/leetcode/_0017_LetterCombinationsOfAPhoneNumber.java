package leetcode;

import java.util.ArrayList;
import java.util.List;

public class _0017_LetterCombinationsOfAPhoneNumber {

    // https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/solution/dian-hua-hao-ma-de-zi-mu-zu-he-by-leetcode/
    static class Solution {
        private static final String[] KEY_MAP = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        public List<String> letterCombinations(String digits) {
            List<String> result = new ArrayList<>();
            StringBuilder path = new StringBuilder(digits.length());
            backtrack(result, digits.length(), 0, digits, path);
            return result;
        }

        private void backtrack(List<String> result, int length, int depth, String digits, StringBuilder path) {
            if (length == depth) {
                result.add(path.toString());
                return;
            }

            String options = KEY_MAP[digits.charAt(depth) - '0'];
            for (int i = 0; i < options.length(); i++) {
                final char c = options.charAt(i);
                path.append(c);
                backtrack(result, length, depth + 1, digits, path);
                path.setLength(path.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("23"));
    }
}
