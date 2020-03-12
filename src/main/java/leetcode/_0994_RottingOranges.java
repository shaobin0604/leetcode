package leetcode;

import java.util.LinkedList;
import java.util.Queue;

public class _0994_RottingOranges {
    static class Solution {
        static class Position {
            final int i;
            final int j;

            public Position(int i, int j) {
                this.i = i;
                this.j = j;
            }
        }

        public int orangesRotting(int[][] grid) {
            final int m = grid.length;

            if (m < 1) {
                return -1;
            }

            final int n = grid[0].length;

            Queue<Position> queue = new LinkedList<>();
            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 2) {
                        queue.offer(new Position(i, j));
                    } else if (grid[i][j] == 1) {
                        count++;
                    }
                }
            }

            int ans = 0;

            while (count > 0 && !queue.isEmpty()) {
                int size = queue.size();
                for (int k = 0; k < size; k++) {
                    Position bad = queue.poll();
                    int i = bad.i;
                    int j = bad.j;

                    // left
                    if (j - 1 >= 0 && grid[i][j - 1] == 1) {
                        grid[i][j - 1] = 2;
                        queue.offer(new Position(i, j - 1));
                        count--;
                    }

                    // up
                    if (i - 1 >= 0 && grid[i - 1][j] == 1) {
                        grid[i - 1][j] = 2;
                        queue.offer(new Position(i - 1, j));
                        count--;
                    }

                    // right
                    if (j + 1 < n && grid[i][j + 1] == 1) {
                        grid[i][j + 1] = 2;
                        queue.offer(new Position(i, j + 1));
                        count--;
                    }

                    // down
                    if (i + 1 < m && grid[i + 1][j] == 1) {
                        grid[i + 1][j] = 2;
                        queue.offer(new Position(i + 1, j));
                        count--;
                    }
                }
                ans++;
            }

            return count > 0 ? -1 : ans;
        }

    }

    public static void main(String[] args) {
        System.out.println(new Solution().orangesRotting(new int[][]
                {{1, 2}}
        ));
        System.out.println(new Solution().orangesRotting(new int[][]
                {{0}}
        ));
        System.out.println(new Solution().orangesRotting(new int[][]
                {{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}
        ));
        System.out.println(new Solution().orangesRotting(new int[][]
                {{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}
        ));
        System.out.println(new Solution().orangesRotting(new int[][]
                {{0, 2}}
        ));
    }
}
