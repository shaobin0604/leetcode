package leetcode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

public class _0257_BinaryTreePaths {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public List<String> binaryTreePaths(TreeNode root) {
            List<String> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            backtrack(result, new ArrayList<>(), root);
            return result;
        }

        private void backtrack(List<String> result, ArrayList<String> path, TreeNode node) {
            path.add(String.valueOf(node.val));

            if (node.left == null && node.right == null) {
                result.add(String.join("->", path));
                path.remove(path.size() - 1);
                return;
            }

            if (node.left != null) {
                backtrack(result, path, node.left);
            }

            if (node.right != null) {
                backtrack(result, path, node.right);
            }

            path.remove(path.size() - 1);
        }
    }
}
