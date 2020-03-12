package DailyInterview;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Elvis on 2020/3/4.
 */
public class Day2 {
    public static void main(String[] args) {
        Day2 day2 = new Day2();
        int[][] grid = new int[][] {
                {0, 2}
//                {2, 1, 1},
//                {0, 1, 1},
//                {1, 0, 1}
        };
        int res = day2.orangesRotting(grid);
        System.out.println(res);
    }

    Queue<Node> queue = new ArrayDeque<>();
    public int orangesRotting(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new Node(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            Node tmp;
            boolean isColor = false;
            for (int i = 0; i < size; i++) {
                tmp = queue.poll();
                if (color(grid, tmp.x + 1, tmp.y) | color(grid, tmp.x - 1, tmp.y) |
                        color(grid, tmp.x, tmp.y + 1) | color(grid, tmp.x, tmp.y - 1)) {
                    isColor = true;
                }
            }

//            for (int i = 0; i < grid.length; i++) {
//                for (int j = 0; j < grid[i].length; j++) {
//                    System.out.print(grid[i][j] + " ");
//                }
//                System.out.println();
//            }
//            System.out.println();

            if (isColor) {
                count++;
            } else {
                break;
            }
        }

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }

        return count;
    }

    public boolean color(int[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[i].length && grid[i][j] == 1) {
            grid[i][j] = 2;
            queue.add(new Node(i, j));
            return true;
        } else {
            return false;
        }
    }

    class Node {
        public int x;
        public int y;
        public Node (int i, int j) {
            this.x = i;
            this.y = j;
        }
    }
}
