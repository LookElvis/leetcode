package Easy.E101_200;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit.
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/solution/
 * Created by liuxiang on 2018/10/14.
 */
public class E122_Best_Time_to_Buy_and_Sell_StockII {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int max = maxProfit1(prices);
        System.out.println(max);
    }

    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        // i-0代表未持有，i-1代表持有
        int dp_i0 = 0;
        int dp_i1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int t = dp_i0;
            dp_i0 = Math.max(dp_i0, dp_i1 + prices[i]);
            dp_i1 = Math.max(dp_i1, t - prices[i]);
        }
        return dp_i0;
    }

    public static int maxProfit1(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int totalPrice = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                totalPrice += prices[i] - prices[i-1];
            }
        }
        return totalPrice;
    }
}
