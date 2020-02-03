package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _0089_GrayCode {
    // 时间复杂度过大，放弃
    static class Solution {
        public List<Integer> grayCode(int n) {
            List<Integer> result = new ArrayList<>();
            final int length = (int) Math.pow(2, n);
            Stack<Integer> path = new Stack<>();
            boolean[] used = new boolean[length];
            backtrack(result, 0, length, used, path);
            return result;
        }

        private boolean backtrack(List<Integer> result, int depth, int length, boolean[] used, Stack<Integer> path) {
            if (depth == length) {
                result.addAll(path);
                return true;
            }

            // 选择 [0, power(2, n) - 1]
            for (int i = 0; i < length; i++) {
                if (used[i]) {
                    continue;
                }

                if (depth > 0 && !isValid(path.peek(), i)) {
                    continue;
                }

                used[i] = true;
                path.push(i);
                if (backtrack(result, depth + 1, length, used, path)) {
                    return true;
                } else {
                    path.pop();
                    used[i] = false;
                }
            }
            return false;
        }

        private boolean isValid(int prev, int candidate) {
            int xor = prev ^ candidate;
            return count1bit(xor) == 1;
        }

        private int count1bit(int num) {
            int count = 0;
            while (num > 0) {
                num = num & (num - 1);
                count++;
            }
            return count;
        }
    }

    static class Solution2 {

        public List<Integer> grayCode(int n) {
            List<Integer> gray = new ArrayList<Integer>();
            gray.add(0); //初始化 n = 0 的解
            for (int i = 0; i < n; i++) {
                int add = 1 << i; //要加的数
                //倒序遍历，并且加上一个值添加到结果中
                for (int j = gray.size() - 1; j >= 0; j--) {
                    gray.add(gray.get(j) + add);
                }
            }
            return gray;
        }
    }

    public static void main(String[] args) {
       System.out.println(new Solution().grayCode(4));
    }
}
