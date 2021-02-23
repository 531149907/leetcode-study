package easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author zhouzhixuan
 */
public class PlusOneTest {
    @Test
    void test() {
        int[] digits = new int[]{3, 3};

        System.out.println(Arrays.toString(plusOne(digits)));
    }

    public int[] plusOne(int[] digits) {
        int length = digits.length;

        for (int i = length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }
        }

        int[] result = new int[length + 1];
        result[0] = 1;
        return result;
    }
}
