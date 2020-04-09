package Medium;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/
 * Created by Elvis on 2020/4/9.
 */
public class M309_Best_Time_To_Buy_And_Sell_Stock_With_Cooldown {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        // i-0代表未持有，i-1代表持有
        int dp_i0 = 0;
        int dp_i1 = Integer.MIN_VALUE;
        int dp_i20 = 0;
        for (int i = 0; i < prices.length; i++) {
            int t = dp_i0;
            dp_i0 = Math.max(dp_i0, dp_i1 + prices[i]);
            dp_i1 = Math.max(dp_i1, dp_i20 - prices[i]);
            dp_i20 = t;
        }
        return dp_i0;
    }
}
