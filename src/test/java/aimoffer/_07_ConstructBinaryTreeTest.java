package aimoffer;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class _07_ConstructBinaryTreeTest {

    @Test
    public void test_case1() {
        final int[] preOrderArray = {1, 2, 4, 7, 3, 5, 6, 8};
        final int[] inOrderArray = {4, 7, 2, 1, 5, 3, 8, 6};

        _07_ConstructBinaryTree.TreeNode root = new _07_ConstructBinaryTree().reConstructBinaryTree(preOrderArray, inOrderArray);

        Assert.assertArrayEquals(preOrderArray, preOrderTraversal(root));

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

//    private int[] inOrderTraversal(_07_ConstructBinaryTree.TreeNode root) {
//
//    }
//
//    private int[] postOrderTraversal(_07_ConstructBinaryTree.TreeNode root) {
//
//    }

    interface Visitor {
        void visit(_07_ConstructBinaryTree.TreeNode node);
    }

    static class CollectorVisitor implements Visitor {

        private List<Integer> array = new ArrayList<>();

        @Override
        public void visit(_07_ConstructBinaryTree.TreeNode node) {
            array.add(node.val);
        }

        public int[] toIntArray() {
            final int[] ret = new int[array.size()];
            for (int i = 0; i < ret.length; i++) {
                ret[i] = array.get(i);
            }
            return ret;
        }
    }
}
