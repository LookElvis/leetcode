package Interview;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
 * Created by Elvis on 2020/3/9.
 */
public class Day7 {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else {
                maxProfit = Math.max(maxProfit, prices[i] - min);
            }
        }
        return maxProfit;
    }

}
