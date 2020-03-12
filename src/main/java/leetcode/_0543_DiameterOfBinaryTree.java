package leetcode;

public class _0543_DiameterOfBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    // https://leetcode-cn.com/problems/diameter-of-binary-tree/solution/er-cha-shu-de-zhi-jing-by-leetcode-solution/
    static class Solution {
        int max = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            getDepth(root);
            return max;
        }

        private int getDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }

            int l = getDepth(root.left);
            int r = getDepth(root.right);

            max = Math.max(max, l + r);

            return Math.max(l, r) + 1;
        }
    }
}
