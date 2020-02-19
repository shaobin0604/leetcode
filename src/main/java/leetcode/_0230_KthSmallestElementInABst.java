package leetcode;

public class _0230_KthSmallestElementInABst {

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {

        private int count;
        private int val;

        public int kthSmallest(TreeNode root, int k) {
            dfs(root, k);
            return val;
        }

        private void dfs(TreeNode node, int k) {
            if (node == null || count == k) {
                return;
            }
            dfs(node.left, k);

            if (++count == k) {
                val = node.val;
                return;
            }

            dfs(node.right, k);
        }
    }
}
