package medium;

import org.junit.Test;

/**
 * @author zhouzhixuan
 */
public class GreatestSumDivisibleByThreeTest {
    @Test
    public void test() {
        int[] nums = new int[]{4, 1, 7, 2, 4, 3, 5};

        System.out.println(maxSumDivThree(nums));
    }

    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[3];
        dp[nums[0] % 3] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int dp0 = dp[0];
            int dp1 = dp[1];
            int dp2 = dp[2];

            int index = (dp0 + nums[i]) % 3;
            dp[index] = Math.max(dp[index], dp0 + nums[i]);

            index = (dp1 + nums[i]) % 3;
            dp[index] = Math.max(dp[index], dp1 + nums[i]);

            index = (dp2 + nums[i]) % 3;
            dp[index] = Math.max(dp[index], dp2 + nums[i]);
        }

        return dp[0];
    }
}
