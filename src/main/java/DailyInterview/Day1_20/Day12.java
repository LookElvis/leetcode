package DailyInterview.Day1_20;

/**
 * https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-by-leetcode-soluti/
 * Created by Elvis on 2020/3/14.
 */
public class Day12 {
    public static void main(String[] args) {

    }

    public int lengthOfLIS(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int res = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
            res = Math.max(res, dp[i]);
        }
        // for (int i = 0; i < dp.length; i++) {
        //     System.out.println(dp[i]);
        // }
        return res;
    }
}
