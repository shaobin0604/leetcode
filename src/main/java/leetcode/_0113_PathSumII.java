package leetcode;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _0113_PathSumII {
    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public List<List<Integer>> pathSum(@NotNull TreeNode root, int sum) {
            List<List<Integer>> ans = new ArrayList<>();
            dfs(ans, root, new Stack<>(), sum);
            return ans;
        }

        private void dfs(List<List<Integer>> ans, @NotNull TreeNode root, Stack<Integer> path, int sum) {
            path.push(root.val);
            if (root.left == null && root.right == null) {
                if (root.val == sum) {
                    ans.add(new ArrayList<>(path));
                }
                path.pop();
                return;
            }

            if (root.left != null) {
                dfs(ans, root.left, path, sum - root.val);
            }

            if (root.right != null) {
                dfs(ans, root.right, path, sum - root.val);
            }

            path.pop();
        }
    }
}
