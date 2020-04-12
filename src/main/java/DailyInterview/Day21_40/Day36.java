package DailyInterview.Day21_40;

/**
 * Created by Elvis on 2020/4/7.
 */
public class Day36 {
    public static void main(String[] args) {

    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int t;
        for (int i = 0; i < n / 2; i++) {
            for (int j = 0; j < (n + 1) / 2; j++) {
                t = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = t;
            }
        }
    }
}
