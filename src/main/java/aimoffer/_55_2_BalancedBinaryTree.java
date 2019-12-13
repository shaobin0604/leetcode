package aimoffer;

public class _55_2_BalancedBinaryTree {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }

        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (Math.abs(left - right) > 1) {
            return false;
        }

        return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(getDepth(root.left), getDepth(root.right));
    }
}
