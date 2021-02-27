package easy;

import org.junit.Test;

/**
 * @author zhouzhixuan
 */
public class PalindromeNumberTest {
    @Test
    public void test() {
        int x = 1221;
        System.out.println(isPalindrome(x));
    }

    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }

        if (x < 0 || x % 10 == 0) {
            return false;
        }

        int[] numbers = new int[10];
        int remain = x;
        int numberSize = 0;

        do {
            numbers[numberSize] = remain % 10;
            remain = remain / 10;
            numberSize++;
        } while (remain != 0);

        int y = numberSize - 1;
        for (int j = 0; j < numberSize / 2; j++) {
            if (numbers[j] != numbers[y]) {
                return false;
            }
            y--;
        }

        return true;
    }
}
