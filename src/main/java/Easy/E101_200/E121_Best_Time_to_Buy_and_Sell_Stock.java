package Easy.E101_200;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i
 * design an algorithm to find the maximum profit.
 * https://leetcode.com/submissions/detail/182595636/
 * Created by liuxiang on 2018/10/14.
 */
public class E121_Best_Time_to_Buy_and_Sell_Stock {
    public static void main(String[] args) {
        int[] prices = {4,6,7,1,5,3,6,4};
        int max = maxProfit(prices);
        System.out.println(max);
    }

    public static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        // i-0代表未持有，i-1代表持有
        int dp_i0 = 0;
        int dp_i1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            dp_i0 = Math.max(dp_i0, dp_i1 + prices[i]);
            dp_i1 = Math.max(dp_i1, -prices[i]);
        }
        return dp_i0;
    }

    public static int maxProfit1(int[] prices) {
        int max = -1;
        for (int i = 0; i < prices.length-1; i++) {
            for (int j = i+1; j < prices.length; j++) {
                max = Math.max(max, prices[j] - prices[i]);
            }
        }
        return max>=0?max:0;
    }
}
