package DailyInterview;

/**
 * https://leetcode-cn.com/problems/max-area-of-island/
 * Created by Elvis on 2020/3/15.
 */
public class Day13 {
    public static void main(String[] args) {

    }

    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, findLand(grid, i, j));
                }
            }
        }
        return res;
    }

    public int findLand(int[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] != 1) {
            return 0;
        }
        grid[i][j] = 2;
        return findLand(grid, i - 1, j) +
                findLand(grid, i + 1, j) +
                findLand(grid, i, j - 1) +
                findLand(grid, i, j + 1) + 1;
    }
}
