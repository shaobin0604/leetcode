package aimoffer;

import java.util.Arrays;

public class _07_ConstructBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length != in.length || pre.length <= 0) {
            return null;
        }

        return reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode reConstructBinaryTree(int[] preOrderArray, int preOrderBegin, int preOrderEnd, int[] inOrderArray, int inOrderBegin, int inOrderEnd) {
        // 前序遍历的第一个元素为根节点
        final int rootValue = preOrderArray[preOrderBegin];
        TreeNode root = new TreeNode(rootValue);
        if (preOrderBegin == preOrderEnd) {
            if (inOrderBegin == inOrderEnd && preOrderArray[preOrderBegin] == inOrderArray[inOrderBegin]) {
                return root;
            } else {
                throw new IllegalArgumentException("please check input");
            }
        }

        final int inOrderRootIndex = findIndex(inOrderArray, rootValue, inOrderBegin, inOrderEnd);
        final int leftLength = inOrderRootIndex - inOrderBegin;
        final int leftPreOrderEnd = preOrderBegin + leftLength;
        if (leftLength > 0) {
            root.left = reConstructBinaryTree(preOrderArray, preOrderBegin + 1, leftPreOrderEnd,
                    inOrderArray, inOrderBegin, inOrderRootIndex - 1);
        }

        if (leftLength < preOrderEnd - preOrderBegin) {
            root.right = reConstructBinaryTree(preOrderArray, leftPreOrderEnd + 1, preOrderEnd,
                    inOrderArray, inOrderRootIndex + 1, inOrderEnd);
        }

        return root;
    }

    private int findIndex(int[] array, int value, int begin, int end) {
        int index = begin;
        while (index <= end) {
            if (array[index] == value) {
                return index;
            }
            index++;
        }
        throw new IllegalArgumentException("please check input, cannot find value: " + value + " in " + Arrays.toString(array));
    }

}
