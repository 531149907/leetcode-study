package medium;

import org.junit.jupiter.api.Test;

/**
 * @author zhouzhixuan
 */
public class UniquePathsTest {
    @Test
    void test() {
        int m = 3;
        int n = 7;

        System.out.println(uniquePaths(m, n));
    }

    public int uniquePaths(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }

        //定义: dp[i][j] 表示走到坐标为(i，j)时的不同路径
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //关系式: 由走到第(i,j-1)与(i-1,j)的不同路径数量再加上右移或下移走到第(i,j)个坐标
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
            }
        }

        return dp[m - 1][n - 1];
    }
}
