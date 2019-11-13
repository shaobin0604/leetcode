package aimoffer;

public class _12_PathInMatrix {

    public boolean hasPath(char[] array, int rows, int cols, char[] str) {
        boolean[] marked = new boolean[rows * cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (backtracking(array, rows, cols, str, marked, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtracking(char[] array, int rows, int cols, char[] str, boolean[] marked, int pathLen, int row, int col) {
        if (pathLen == str.length) {
            return true;
        }

        final int index = row * cols + col;
        if (row < 0 || row >= rows || col < 0 || col >= cols || marked[index] || array[index] != str[pathLen]) {
            return false;
        }

        marked[index] = true;
        if (backtracking(array, rows, cols, str, marked, pathLen + 1, row, col + 1)
                || backtracking(array, rows, cols, str, marked, pathLen + 1, row + 1, col)
                || backtracking(array, rows, cols, str, marked, pathLen + 1, row, col - 1)
                || backtracking(array, rows, cols, str, marked, pathLen + 1, row - 1, col)) {
            return true;
        }
        marked[index] = false;
        return false;
    }
}
