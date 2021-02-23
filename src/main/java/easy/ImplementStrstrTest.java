package easy;

import org.junit.jupiter.api.Test;

/**
 * @author zhouzhixuan
 */
public class ImplementStrstrTest {
    @Test
    void test() {
        String haystack = "dddeer";
        String needle = "de";

        System.out.println(strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0) {
            return 0;
        }

        if (needle.length() > haystack.length()) {
            return -1;
        }

        if (needle.equals(haystack)) {
            return 0;
        }

        for (int i = 0; i < haystack.toCharArray().length; i++) {
            if (haystack.charAt(i) != needle.charAt(0)) {
                continue;
            }

            if (haystack.toCharArray().length - i < needle.toCharArray().length) {
                return -1;
            }

            int subHaystackIndex = 0;
            boolean success = true;

            for (int j = 0; j < needle.toCharArray().length; j++) {
                if (needle.charAt(j) != haystack.charAt(i + subHaystackIndex)) {
                    success = false;
                    break;
                }
                subHaystackIndex++;
            }

            if (success) {
                return i;
            }
        }

        return -1;
    }
}
