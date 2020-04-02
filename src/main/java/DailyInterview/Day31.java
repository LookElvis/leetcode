package DailyInterview;

/**
 * https://leetcode-cn.com/problems/game-of-life/
 * Created by Elvis on 2020/4/2.
 */
public class Day31 {
    public void gameOfLife(int[][] board) {
        int count;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                count = countAlive(board, i, j);
                if (board[i][j] == 1 && (count < 2 || count > 3)) {
                    // 2代表活->死
                    board[i][j] = 2;
                } else if (board[i][j] == 0 && count == 3) {
                    // 3代表死->活
                    board[i][j] = 3;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                // 还原
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                } else if (board[i][j] == 3) {
                    board[i][j] = 1;
                }
            }
        }
    }

    public int countAlive(int[][] board, int i, int j) {
        // 计算四个方向
        return judge(board, i - 1, j) + judge(board, i + 1, j)
                + judge(board, i, j - 1) + judge(board, i, j + 1)
                + judge(board, i - 1, j - 1) + judge(board, i + 1, j + 1)
                + judge(board, i - 1, j + 1) + judge(board, i + 1, j - 1);
    }

    public int judge(int[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length) return 0;
        if (board[i][j] == 1 || board[i][j] == 2) return 1;
        return 0;
    }
}
