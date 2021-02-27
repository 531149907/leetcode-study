package easy;

import org.junit.Test;

/**
 * @author zhouzhixuan
 */
public class RemoveDuplicatesFromSortedArrayTest {
    @Test
    public void test() {
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};

        System.out.println(removeDuplicates(nums));
    }

    public int removeDuplicates(int[] nums) {
        int current = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[current]) {
                nums[++current] = nums[i];
            }
        }

        return ++current;
    }
}
