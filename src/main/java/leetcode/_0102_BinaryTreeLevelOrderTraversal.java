package leetcode;

import java.util.*;
import java.util.function.Consumer;

public class _0102_BinaryTreeLevelOrderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }

            List<List<Integer>> ans = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();

            queue.offer(root);

            while (!queue.isEmpty()) {
                final int size = queue.size();
                List<Integer> line = new ArrayList<>(size);
                for (int i = 0; i < size; i++) {
                    final TreeNode node = queue.poll();
                    if (node != null) {
                        line.add(node.val);

                        if (node.left != null) {
                            queue.offer(node.left);
                        }

                        if (node.right != null) {
                            queue.offer(node.right);
                        }
                    }
                }
                ans.add(line);
            }

            return ans;
        }
    }
}
