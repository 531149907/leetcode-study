package easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhouzhixuan
 * @date 2021/2/21
 */
public class TwoSumTest {
    @Test
    void test() {
        int[] nums = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));

        nums = new int[]{3, 3};
        target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>(nums.length);

        for (int i = 0; i < nums.length; i++) {
            if (!numsMap.containsKey(target - nums[i])) {
                numsMap.put(nums[i], i);
            } else {
                return new int[]{i, numsMap.get(target - nums[i])};
            }
        }

        return new int[]{};
    }
}
