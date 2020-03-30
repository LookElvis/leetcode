package Medium;

/**
 * https://leetcode-cn.com/problems/longest-palindromic-subsequence/
 * Created by Elvis on 2020/3/30.
 */
public class M516_Longest_Palindromic_Subsequence {
    // 最长公共回文串，dp[i][j]代表字符串[i,j]中的最长公共回文串
    // i从len开始往前遍历，j从i往后找，如果i和j的字符相等则[i+1,j-1]+1
    // 如果不相等则取[i+1,j]和[i,j-1]的最大值
    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];

        for (int i = len - 1; i >= 0; i--) {
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][len - 1];
    }
}
