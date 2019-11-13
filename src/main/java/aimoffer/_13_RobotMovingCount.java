package aimoffer;

import java.util.Scanner;

public class _13_RobotMovingCount {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final int row = scanner.nextInt();
        final int col = scanner.nextInt();
        final int threshold = scanner.nextInt();

        System.out.println(new _13_RobotMovingCount().movingCount(threshold, row, col));
    }

    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] mark = new boolean[rows][cols];
        return backtracking(threshold, rows, cols, mark, 0, 0);
    }

    private int backtracking(int threshold, int rows, int cols, boolean[][] mark, int row, int col) {
        int count = 0;

        if (row >= 0 && row < rows && col >= 0 && col < cols && !mark[row][col] && (getSum(row) + getSum(col)) <= threshold) {
            mark[row][col] = true;
            count = 1 + backtracking(threshold, rows, cols, mark, row, col + 1)
                    + backtracking(threshold, rows, cols, mark, row + 1, col)
                    + backtracking(threshold, rows, cols, mark, row, col - 1)
                    + backtracking(threshold, rows, cols, mark, row - 1, col);
        }

        return count;
    }

    private static int getSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
