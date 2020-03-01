package leetcode;

public class _0101_SymmetricTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public boolean isSymmetric(TreeNode root) {
            if (root == null) return true;
            return match(root.left, root.right);
        }

        private boolean match(TreeNode l, TreeNode r) {
            if (l == null && r == null) return true;
            if (l == null || r == null) return false;
            return l.val == r.val &&
                    match(l.left, r.right) &&
                    match(l.right, r.left);
        }
    }
}
