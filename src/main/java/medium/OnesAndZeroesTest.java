package medium;

import org.junit.Test;

/**
 * @author zhouzhixuan
 */
public class OnesAndZeroesTest {
    @Test
    public void test() {
        String[] strs = new String[]{"10", "0001", "111001", "1", "0"};
        int m = 5;
        int n = 3;

        System.out.println(findMaxForm(strs, m, n));
    }

    public int findMaxForm(String[] strs, int m, int n) {
        //定义：dp[i][j]表示当有i个0，j个1时strs中最大的子集的数量
        int[][] dp = new int[m + 1][n + 1];
        int numberOfOneInCurrentString = 0;
        int numberOdZeroInCurrentString = 0;

        for (String str : strs) {
            //计算当前字符串中0和1分别出现的次数
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    numberOdZeroInCurrentString++;
                } else {
                    numberOfOneInCurrentString++;
                }
            }

            for (int j = m; j >= numberOdZeroInCurrentString; j--) {
                for (int k = n; k >= numberOfOneInCurrentString; k--) {
                    //关系式（二维0/1背包问题【选 or 不选，不能选一半】）
                    //当有j个0和k个1时，如果不选那就是dp[j][k]，如果选那就是需要先减去当前str中的0、1个数后的dp[j - numberOdZeroInCurrentString][k - numberOfOneInCurrentString]再加上当前字符串的个数（1）
                    dp[j][k] = Math.max(dp[j][k], dp[j - numberOdZeroInCurrentString][k - numberOfOneInCurrentString] + 1);
                }
            }

            numberOdZeroInCurrentString = 0;
            numberOfOneInCurrentString = 0;
        }

        return dp[m][n];
    }
}
