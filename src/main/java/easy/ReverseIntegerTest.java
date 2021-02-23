package easy;

import org.junit.jupiter.api.Test;

/**
 * @author zhouzhixuan
 */
public class ReverseIntegerTest {
    @Test
    void test() {
        int x = 1001;
        System.out.println(reverse(x));
    }

    public int reverse(int x) {
        long n = 0;

        while (x != 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }

        return (int) n == n ? (int) n : 0;
    }
}
