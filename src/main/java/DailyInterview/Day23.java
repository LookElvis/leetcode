package DailyInterview;

/**
 * https://leetcode-cn.com/problems/surface-area-of-3d-shapes/submissions/
 * 先计算全部的表面积，再减掉上下和前后左右重叠部分
 * Created by Elvis on 2020/3/25.
 */
public class Day23 {
    public int surfaceArea(int[][] grid) {
        int count = 0;
        int min = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                count += grid[i][j] * 6;
                if (grid[i][j] != 0) {
                    min += (grid[i][j] - 1) * 2;
                    min += judge(grid, i, j, i - 1, j);
                    min += judge(grid, i, j, i + 1, j);
                    min += judge(grid, i, j, i, j - 1);
                    min += judge(grid, i, j, i, j + 1);
                }
            }
        }
        return count - min;
    }

    public int judge(int[][] grid, int i, int j, int m, int n) {
        if (m < 0 || m > grid.length - 1 || n < 0 || n > grid[i].length - 1) {
            return 0;
        }
        return Math.min(grid[i][j], grid[m][n]);
    }
}
