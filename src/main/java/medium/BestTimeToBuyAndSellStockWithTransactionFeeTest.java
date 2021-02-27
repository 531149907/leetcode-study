package medium;

import org.junit.jupiter.api.Test;

/**
 * @author zhouzhixuan
 */
public class BestTimeToBuyAndSellStockWithTransactionFeeTest {
    @Test
    void test() {
        int[] prices = new int[]{1, 3, 2, 8, 4, 9};
        int fee = 2;

        System.out.println(maxProfit(prices, fee));
    }

    public int maxProfit(int[] prices, int fee) {
        int length = prices.length;

        if (length == 1) {
            return 0;
        }

        //定义dp[i][0]表示第i天手上无股票时的利润，定义dp[i][1]表示为第i天手上有股票时的利润
        int[][] dp = new int[length][2];
        dp[0][1] = -prices[0];

        for (int i = 1; i < length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[length - 1][0];
    }
}
