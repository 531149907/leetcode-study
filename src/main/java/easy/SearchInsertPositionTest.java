package easy;

import org.junit.jupiter.api.Test;

/**
 * @author zhouzhixuan
 */
public class SearchInsertPositionTest {
    @Test
    void test() {
        int[] nums = new int[]{1, 3, 5, 6};
        int target = 0;

        System.out.println(searchInsert(nums, target));
    }

    public int searchInsert(int[] nums, int target) {
        if (target < nums[0]) {
            return 0;
        }

        if (nums.length == 1) {
            return nums[0] == target ? 0 : 1;
        }

        for (int i = 0; i <= nums.length; i++) {
            if (i == nums.length) {
                return nums.length;
            }

            if (nums[i] == target) {
                return i;
            }

            if (i + 1 < nums.length && nums[i] < target && nums[i + 1] > target) {
                return i + 1;
            }
        }

        return 0;
    }
}
