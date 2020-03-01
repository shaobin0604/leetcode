package leetcode;

import java.util.*;

public class _0103_BinaryTreeZigzagLevelOrderTraversal {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            if (root == null) {
                return Collections.emptyList();
            }

            List<List<Integer>> ans = new ArrayList<>();
            Queue<TreeNode> queue = new LinkedList<>();

            queue.offer(root);

            // even: 从左到右 odd: 从右到左
            int level = -1;

            while (!queue.isEmpty()) {
                level++;
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
                if ((level & 1) == 1) {
                    Collections.reverse(line);
                }
                ans.add(line);
            }

            return ans;
        }


    }
}
