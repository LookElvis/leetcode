package DailyInterview;

/**
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 * Created by Elvis on 2020/4/8.
 */
public class Day37 {
    public static void main(String[] args) {
        Day37 day37 = new Day37();
        int m = 16;
        int n = 8;
        int k = 4;
        System.out.println(day37.movingCount(m, n, k));
    }

    public int count = 0;
    public int movingCount(int m, int n, int k) {
        int[][] arr = new int[m][n];
        dfs(arr, 0, 0, k);
        return count;
    }

    public void dfs(int[][] arr, int i, int j, int k) {
        if (i >= 0 && i < arr.length && j >= 0 && j < arr[i].length && arr[i][j] == 0 && isLegal(i, j, k)) {
            count++;
            arr[i][j] = 1;
            dfs(arr, i - 1, j, k);
            dfs(arr, i + 1, j, k);
            dfs(arr, i, j - 1, k);
            dfs(arr, i, j + 1, k);
        }
    }

    public boolean isLegal(int i, int j, int k) {
//        System.out.print(i + " " + j  + " ");
        int cnt = 0;
        while (i > 0) {
            cnt += i % 10;
            i /= 10;
        }
        while (j > 0) {
            cnt += j % 10;
            j /= 10;
        }
//        System.out.println(cnt);
        return cnt > k ? false : true;
    }
}
