package Medium;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
 * Created by Elvis on 2020/4/9.
 */
public class M714_Best_Time_To_Buy_And_Sell_Stock_With_Transaction_Fee {
    public int maxProfit(int[] prices, int fee) {
        int[][] dp = new int[prices.length][2];
        // i-0代表未持有，i-1代表持有
        int dp_i0 = 0;
        int dp_i1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int t = dp_i0;
            dp_i0 = Math.max(dp_i0, dp_i1 + prices[i]);
            dp_i1 = Math.max(dp_i1, t - prices[i] - fee);
        }
        return dp_i0;
    }
}
