package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _0078_Subsets {
    static class Solution {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> subsets = new ArrayList<>();
            List<Integer> tempSubset = new ArrayList<>();
            for (int size = 0; size <= nums.length; size++) {
                backtracking(0, tempSubset, subsets, size, nums); // 不同的子集大小
            }
            return subsets;
        }

        private void backtracking(int start, List<Integer> tempSubset, List<List<Integer>> subsets,
                                  final int size, final int[] nums) {

            if (tempSubset.size() == size) {
                subsets.add(new ArrayList<>(tempSubset));
                return;
            }
            for (int i = start; i < nums.length; i++) {
                tempSubset.add(nums[i]);
                backtracking(i + 1, tempSubset, subsets, size, nums);
                tempSubset.remove(tempSubset.size() - 1);
            }
        }
    }

    static class Solution2 {
        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> subsets = new ArrayList<>();

            Stack<Integer> stack = new Stack<>();

            backtracking(0, stack, subsets, nums);

            return subsets;
        }

        private void backtracking(int depth, Stack<Integer> stack, List<List<Integer>> subsets, final int[] nums) {

            if (depth == nums.length) {
                subsets.add(new ArrayList<>(stack));
                return;
            }

            // 不选
            backtracking(depth + 1, stack, subsets, nums);

            // 选
            stack.push(nums[depth]);
            backtracking(depth + 1, stack, subsets, nums);
            stack.pop();
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().subsets(new int[] {1, 2, 3}));
    }
}
