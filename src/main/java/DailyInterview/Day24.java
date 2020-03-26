package DailyInterview;

/**
 * https://leetcode-cn.com/problems/available-captures-for-rook/submissions/
 * Created by Elvis on 2020/3/26.
 */
public class Day24 {
    public int numRookCaptures(char[][] board) {
        int count = 0;
        boolean isFound = false;
        for (int i = 0; i < board.length; i++) {
            if (isFound) {
                break;
            }
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'R') {
                    count = calNum(board, i, j);
                    isFound = true;
                    // System.out.println(i + " " + j);
                    break;
                }
            }
        }
        return count;
    }

    public int calNum(char[][] board, int i, int j) {
        int count = 0;
        for (int m = j - 1; m >= 0; m--) {
            if (board[i][m] == 'p') {
                count++;
                break;
            }
            if (board[i][m] == 'B') {
                break;
            }
        }
        for (int m = j + 1; m < board.length; m++) {
            if (board[i][m] == 'p') {
                count++;
                break;
            }
            if (board[i][m] == 'B') {
                break;
            }
        }
        for (int n = i - 1; n >= 0; n--) {
            if (board[n][j] == 'p') {
                count++;
                break;
            }
            if (board[n][j] == 'B') {
                break;
            }
        }
        for (int n = i + 1; n < board[i].length; n++) {
            if (board[n][j] == 'p') {
                count++;
                break;
            }
            if (board[n][j] == 'B') {
                break;
            }
        }
        return count;
    }
}
