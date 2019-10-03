package aimoffer;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

import aimoffer._07_ConstructBinaryTree.TreeNode;

public class _07_ConstructBinaryTreeTest {

    @Test
    public void test_case_1() {
        final int[] preOrderArray = {1, 2, 4, 7, 3, 5, 6, 8};
        final int[] inOrderArray = {4, 7, 2, 1, 5, 3, 8, 6};
        final int[] postOrderArray = {7, 4, 2, 5, 8, 6, 3, 1};
        final int[] levelArray = {1, 2, 3, 4, 5, 6, 7, 8};

        TreeNode root = new _07_ConstructBinaryTree().reConstructBinaryTree(preOrderArray, inOrderArray);

        Assert.assertArrayEquals(preOrderArray, preOrderTraversal(root));
        Assert.assertArrayEquals(inOrderArray, inOrderTraversal(root));
        Assert.assertArrayEquals(postOrderArray, postOrderTraversal(root));

        Assert.assertArrayEquals(preOrderArray, preOrderTraversalIter(root));
        Assert.assertArrayEquals(inOrderArray, inOrderTraversalIter(root));
        Assert.assertArrayEquals(inOrderArray, inOrderTraversalIterV2(root));
        Assert.assertArrayEquals(postOrderArray, postOrderTraversalIter(root));

        Assert.assertArrayEquals(levelArray, levelTraversal(root));
    }

    @Test
    public void test_case_2() {
        final int[] preOrderArray = {10, 6, 4, 8, 14, 12, 16};
        final int[] inOrderArray = {4, 6, 8, 10, 12, 14, 16};
        final int[] postOrderArray = {4, 8, 6, 12, 16, 14, 10};
        final int[] levelArray = {10, 6, 14, 4, 8, 12, 16};

        TreeNode root = new _07_ConstructBinaryTree().reConstructBinaryTree(preOrderArray, inOrderArray);

        Assert.assertArrayEquals(preOrderArray, preOrderTraversal(root));
        Assert.assertArrayEquals(inOrderArray, inOrderTraversal(root));
        Assert.assertArrayEquals(postOrderArray, postOrderTraversal(root));

        Assert.assertArrayEquals(preOrderArray, preOrderTraversalIter(root));
        Assert.assertArrayEquals(inOrderArray, inOrderTraversalIter(root));
        Assert.assertArrayEquals(inOrderArray, inOrderTraversalIterV2(root));
        Assert.assertArrayEquals(postOrderArray, postOrderTraversalIter(root));

        Assert.assertArrayEquals(levelArray, levelTraversal(root));
    }

    private int[] preOrderTraversalIter(TreeNode root) {
        final CollectorVisitor visitor = new CollectorVisitor();

        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            visitor.visit(node);
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

        return visitor.toIntArray();
    }

    private int[] inOrderTraversalIter(TreeNode root) {
        final CollectorVisitor visitor = new CollectorVisitor();

        Stack<TreeNode> stack = new Stack<>();

        TreeNode p = root;

        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }

            p = stack.pop();
            visitor.visit(p);
            p = p.right;
        }

        return visitor.toIntArray();
    }

    private int[] inOrderTraversalIterV2(TreeNode root) {
        final CollectorVisitor visitor = new CollectorVisitor();

        Stack<TreeNode> stack = new Stack<>();

        TreeNode p = root;

        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                visitor.visit(p);
                p = p.right;
            }
        }

        return visitor.toIntArray();
    }

    private int[] postOrderTraversalIter(TreeNode root) {
        final CollectorVisitor visitor = new CollectorVisitor();

        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;
        TreeNode last = null;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                TreeNode peek = stack.peek();
                if (peek.right != null && last != peek.right) {
                    p = peek.right;
                } else {
                    peek = stack.pop();
                    visitor.visit(peek);
                    last = peek;
                }
            }
        }

        return visitor.toIntArray();
    }

    private int[] levelTraversal(TreeNode root) {
        final CollectorVisitor visitor = new CollectorVisitor();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            visitor.visit(node);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }

        return visitor.toIntArray();
    }

    private int[] preOrderTraversal(_07_ConstructBinaryTree.TreeNode root) {
        final CollectorVisitor visitor = new CollectorVisitor();
        preOrderTraversalInternal(root, visitor);
        return visitor.toIntArray();
    }

    private void preOrderTraversalInternal(_07_ConstructBinaryTree.TreeNode node, Visitor visitor) {
        visitor.visit(node);

        if (node.left != null) {
            preOrderTraversalInternal(node.left, visitor);
        }

        if (node.right != null) {
            preOrderTraversalInternal(node.right, visitor);
        }
    }

    private int[] inOrderTraversal(_07_ConstructBinaryTree.TreeNode root) {
        final CollectorVisitor visitor = new CollectorVisitor();
        inOrderTraversalInternal(root, visitor);
        return visitor.toIntArray();
    }

    private int[] postOrderTraversal(_07_ConstructBinaryTree.TreeNode root) {
        final CollectorVisitor visitor = new CollectorVisitor();
        postOrderTraversalInternal(root, visitor);
        return visitor.toIntArray();
    }

    private void postOrderTraversalInternal(_07_ConstructBinaryTree.TreeNode node, Visitor visitor) {
        if (node.left != null) {
            postOrderTraversalInternal(node.left, visitor);
        }

        if (node.right != null) {
            postOrderTraversalInternal(node.right, visitor);
        }

        visitor.visit(node);
    }


    private void inOrderTraversalInternal(_07_ConstructBinaryTree.TreeNode node, Visitor visitor) {
        if (node.left != null) {
            inOrderTraversalInternal(node.left, visitor);
        }

        visitor.visit(node);

        if (node.right != null) {
            inOrderTraversalInternal(node.right, visitor);
        }
    }


    interface Visitor {
        void visit(_07_ConstructBinaryTree.TreeNode node);
    }

    static class CollectorVisitor implements Visitor {

        private List<Integer> array = new ArrayList<>();

        @Override
        public void visit(_07_ConstructBinaryTree.TreeNode node) {
            array.add(node.val);
        }

        int[] toIntArray() {
            final int[] ret = new int[array.size()];
            for (int i = 0; i < ret.length; i++) {
                ret[i] = array.get(i);
            }
            return ret;
        }
    }
}
