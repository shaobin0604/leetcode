package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class _0047_PermutationsII {
    static class Solution {
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();

            if (nums == null || nums.length == 0) {
                return result;
            }

            boolean[] visited = new boolean[nums.length];
            Stack<Integer> path = new Stack<>();
            Arrays.sort(nums);
            performPermute(result, visited, path, nums);
            return result;
        }

        private void performPermute(List<List<Integer>> result, boolean[] visited, Stack<Integer> path, int[] nums) {
            if (path.size() == nums.length) {
                result.add(new ArrayList<>(path));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (visited[i]) {
                    continue;
                }

                if (i > 0 && nums[i] == nums[i - 1] && visited[i - 1]) {
                    continue;
                }

                visited[i] = true;
                path.push(nums[i]);
                performPermute(result, visited, path, nums);
                path.pop();
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().permuteUnique(new int[]{1, 1, 2}));
    }
}
