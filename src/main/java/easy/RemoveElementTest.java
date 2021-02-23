package easy;

import org.junit.jupiter.api.Test;

/**
 * @author zhouzhixuan
 */
public class RemoveElementTest {
    @Test
    void test() {
        int[] nums = new int[]{2, 2};
        int val = 2;

        System.out.println(removeElement(nums, val));
    }

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j] = nums[i];
                j++;
            }
        }

        return j;
    }
}
