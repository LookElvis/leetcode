package DailyInterview;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/as-far-from-land-as-possible/
 * BFS
 * Created by Elvis on 2020/3/29.
 */
public class Day27 {
    public static void main(String[] args) {

    }

    public int maxDistance(int[][] grid) {
        Queue<int[]> queue = new ArrayDeque();
        int[] dx = {0, 0, 1, -1};
        int[] dy = {-1, 1, 0, 0};
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    queue.add(new int[] {i , j});
                }
            }
        }

        boolean hasOcean = false;
        int[] point = null;
        while (!queue.isEmpty()) {
            point = queue.poll();
            int x = point[0], y = point[1];
            int newX, newY;
            for (int i = 0; i < 4; i++) {
                // 取出队列的元素，将其四周的海洋入队。
                newX = x + dx[i];
                newY = y + dy[i];
                if (newX < 0 || newX >= grid.length || newY < 0 || newY >= grid[0].length || grid[newX][newY] != 0) {
                    continue;
                }
                hasOcean = true;
                // 直接修改原数组，因此就不需要额外的数组来标志是否访问
                // 并且加上访问点的值，存储的为实际上的路径长度
                grid[newX][newY] = grid[x][y] + 1;
                queue.add(new int[] {newX, newY});
            }
        }

        // 没有陆地或者没有海洋，返回-1
        if (point == null || !hasOcean) {
            return -1;
        }
        // 返回最后一次遍历到的地方
        // 最后扩散到的海洋就是最远的海洋
        // 并且这个海洋肯定是被离他最近的陆地给扩散到的
        return grid[point[0]][point[1]] - 1;
    }
}
