package leetcode;

import java.util.*;

public class _0429_NAryTreeLevelOrderTraversal {
    // Definition for a Node.
    static class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    static class Solution {
        public List<List<Integer>> levelOrder(Node root) {
            if (root == null) {
                return Collections.emptyList();
            }

            List<List<Integer>> ans = new ArrayList<>();
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                final int size = queue.size();
                List<Integer> line = new ArrayList<>(size);
                for (int i = 0; i < size; i++) {
                    final Node node = queue.poll();
                    if (node != null) {
                        line.add(node.val);
                        for (Node child : node.children) {
                            if (child != null) {
                                queue.offer(child);
                            }
                        }
                    }
                }
                ans.add(line);
            }

            return ans;
        }
    }
}
