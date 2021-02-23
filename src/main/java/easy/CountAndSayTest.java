package easy;

import org.junit.jupiter.api.Test;

/**
 * @author zhouzhixuan
 */
public class CountAndSayTest {
    @Test
    void test() {
        int n = 6;
        System.out.println(countAndSay(n));
    }

    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String last = countAndSay(n - 1);
        StringBuilder builder = new StringBuilder();
        int currentTimes = 1;
        int length = last.toCharArray().length;

        for (int i = 0; i < length; i++) {
            if (i == length - 1) {
                builder.append(currentTimes).append(last.charAt(i));
                break;
            }

            if (last.charAt(i) != last.charAt(i + 1)) {
                builder.append(currentTimes).append(last.charAt(i));
                currentTimes = 1;
            } else {
                currentTimes++;
            }
        }

        return builder.toString();
    }
}
