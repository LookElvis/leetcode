package DailyInterview.Day21_40;

/**
 * https://leetcode-cn.com/problems/edit-distance/
 * 动态规划，增删改字符
 * Created by Elvis on 2020/4/6.
 */
public class Day35 {
    public static void main(String[] args) {
        Day35 day35 = new Day35();
        String word1 = "distance";
        String word2 = "springbok";;
        System.out.println(day35.minDistance(word1, word2));
    }

    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        //某个字符串长度为0，则结果为另一个字符串的长度
        if (len1 == 0 || len2 == 0) return Math.max(len1, len2);

        //dp[i][j]代表word1(0-i)转化成word2(0-j)所需要的次数
        int[][] dp = new int[len1 + 1][len2 + 1];

        //初始化dp数组,第一横行和第一纵列
        for (int i = 1; i <= len1; i++) {
            dp[i][0] = i;
        }
        for (int i = 1; i <= len2; i++) {
            dp[0][i] = i;
        }

        //动态规划
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[len1][len2];
    }
}
