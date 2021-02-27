package medium;

import org.junit.jupiter.api.Test;

/**
 * @author zhouzhixuan
 */
public class KnightDialerTest {
    @Test
    void test() {
        int n = 3;
        System.out.println(knightDialer(n));
    }

    public int knightDialer(int n) {
        if (n == 1) {
            return 10;
        }

        //定义dp[i][j]表示当当前为i数字时j步的号码数
        long[][] dp = new long[10][n+1];
        for (int i = 0; i < 10; i++) {
            dp[i][0] = 0;
            dp[i][1] = 1;
        }

        int mod = 1000000000 + 7;

        for (int i = 2; i <= n; i++) {
            dp[0][i] = (dp[4][i - 1] + dp[6][i - 1]) % mod;
            dp[1][i] = (dp[8][i - 1] + dp[6][i - 1]) % mod;
            dp[2][i] = (dp[7][i - 1] + dp[9][i - 1]) % mod;
            dp[3][i] = (dp[4][i - 1] + dp[8][i - 1]) % mod;
            dp[4][i] = (dp[0][i - 1] + dp[9][i - 1] + dp[3][i - 1]) % mod;
            dp[6][i] = (dp[1][i - 1] + dp[7][i - 1] + dp[0][i - 1]) % mod;
            dp[7][i] = (dp[2][i - 1] + dp[6][i - 1]) % mod;
            dp[8][i] = (dp[1][i - 1] + dp[3][i - 1]) % mod;
            dp[9][i] = (dp[2][i - 1] + dp[4][i - 1]) % mod;
        }

        long sum = 0;
        for (int i = 0; i < 10; i++) {
            sum = (sum + dp[i][n]) % mod;
        }

        return (int)sum;
    }
}
