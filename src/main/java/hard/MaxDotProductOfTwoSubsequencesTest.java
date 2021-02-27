package hard;

import org.junit.Test;

/**
 * @author zhouzhixuan
 */
public class MaxDotProductOfTwoSubsequencesTest {
    @Test
    public void test() {
        int[] nums1 = new int[]{2, 1, -2, 5};
        int[] nums2 = new int[]{3, 0, -6};

        System.out.println(maxDotProduct(nums1, nums2));
    }

    public int maxDotProduct(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;

        int[][] dp = new int[len1 + 1][len2 + 1];
        int max = Integer.MIN_VALUE;

        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                max = Math.max(max, dp[i - 1][j - 1] + nums1[i - 1] * nums2[j - 1]);

                //选i不选j
                dp[i][j] = Math.max(dp[i][j], dp[i][j - 1]);
                //选j不选i
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);
                //选i选i
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + nums1[i - 1] * nums2[j - 1]);
                //不选i不选j
                dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1]);
            }
        }

        return max;
    }
}
