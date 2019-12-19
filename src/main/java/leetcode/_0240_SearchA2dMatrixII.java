package leetcode;

public class _0240_SearchA2dMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1) {
            return false;
        }

        final int row = matrix.length;
        final int col = matrix[0].length;

        // 选定右上角为初始位置
        int i = 0, j = col - 1;

        while (i < row && j >= 0) {
            if (target == matrix[i][j]) {
                return true;
            } else if (target < matrix[i][j]) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1) {
            return false;
        }

        final int row = matrix.length;
        final int col = matrix[0].length;

        // 选定左下角为初始位置
        int i = row - 1, j = 0;

        while (i >= 0 && j < col) {
            if (target == matrix[i][j]) {
                return true;
            } else if (target < matrix[i][j]) {
                i--;
            } else {
                j++;
            }
        }
        return false;
    }
}
