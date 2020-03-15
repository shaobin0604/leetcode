package leetcode;

public class _0463_IslandPerimeter {
    static class Solution {
        public int islandPerimeter(int[][] grid) {
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == 1) {
                        return dfs(grid, i, j);
                    }
                }
            }
            return 0;
        }

        private int dfs(int[][] grid, int i, int j) {
            // 边界
            if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length) {
                return 1;
            }

            // 海洋
            if (grid[i][j] == 0) {
                return 1;
            }

            // 已经走过了
            if (grid[i][j] == 2) {
                return 0;
            }

            grid[i][j] = 2;

            return dfs(grid, i, j + 1) + dfs(grid, i - 1, j) + dfs(grid, i, j - 1) + dfs(grid, i + 1, j);
        }
    }
}
