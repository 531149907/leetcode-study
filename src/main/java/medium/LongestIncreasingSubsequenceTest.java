package medium;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhouzhixuan
 */
public class LongestIncreasingSubsequenceTest {
    @Test
    public void test() {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};

        System.out.println(lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        int length = nums.length;

        if (length < 2) {
            return 1;
        }

        //定义： dp[i]=当遍历到数组第i-1个数字时，所包含的最长严格递增子序列的长度
        int[] dp = new int[length];
        Arrays.fill(dp, 1);

        int maxLength = 0;

        for (int i = 1; i < length; i++) {
            for (int j = 0; j < i; j++) {
                //找之前对比过的，并且是大于之前的数的
                if (nums[j] < nums[i]) {
                    //要么在之前数的基础序列上加上自已（1）的长度，要么就是自己的长度
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }

            maxLength = Math.max(dp[i], maxLength);
        }

        return maxLength;
    }
}
