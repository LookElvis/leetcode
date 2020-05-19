package DailyInterview;

/**
 * https://leetcode-cn.com/problems/valid-palindrome-ii/
 * Created by Elvis on 2020/5/19.
 */
public class Day73 {
    public static void main(String[] args) {

    }

    public boolean validPalindrome1(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
        }
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1] >= len - 1;
    }

    public int maxProduct1(int[] nums) {
        int len = nums.length;
        int[] max = new int[len];
        int[] min = new int[len];
        int res = nums[0];
        max[0] = nums[0];
        min[0] = nums[0];
        for (int i = 1; i < len; i++) {
            max[i] = Math.max(nums[i] * max[i - 1], Math.max(nums[i], nums[i] * min[i - 1]));
            min[i] = Math.min(nums[i] * max[i - 1], Math.min(nums[i], nums[i] * min[i - 1]));
            res = Math.max(res, max[i]);
        }
        return res;
    }
}
