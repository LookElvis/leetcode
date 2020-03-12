package DailyInterview;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/coin-change/submissions/
 * Created by Elvis on 2020/3/8.
 */
public class Day6 {
    public static void main(String[] args) {
        Day6 day6 = new Day6();
        int[] coins = new int[]{2, 5};
        int amount = 11;
        int res = day6.coinChange(coins, amount);
        System.out.println(res);
    }

    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}
