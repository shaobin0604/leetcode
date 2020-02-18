package leetcode;


// https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/solution/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian--2/
public class _0235_LowestCommonAncestorOfABinarySearchTree {


    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if (root.val > p.val && root.val > q.val) {
                return lowestCommonAncestor(root.left, p, q);
            } else if (root.val < p.val && root.val < q.val) {
                return lowestCommonAncestor(root.right, p, q);
            } else {
                return root;
            }
        }
    }

    static class Solution2 {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            int pVal = p.val;
            int qVal = q.val;

            while (root != null) {
                if (pVal < root.val && qVal < root.val) {
                    root = root.left;
                } else if (pVal > root.val && qVal > root.val) {
                    root = root.right;
                } else {
                    // We have found the split point, i.e. the LCA node.
                    return root;
                }
            }
            return null;
        }
    }

}
