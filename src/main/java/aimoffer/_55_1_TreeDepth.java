package aimoffer;

public class _55_1_TreeDepth {
    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public int getTreeDepth(TreeNode node) {
        if (node == null) {
            return 0;
        }

        return 1 + Math.max(getTreeDepth(node.left), getTreeDepth(node.right));
    }
}
