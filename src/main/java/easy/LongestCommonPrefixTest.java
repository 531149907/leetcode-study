package easy;

import org.junit.jupiter.api.Test;

/**
 * @author zhouzhixuan
 */
public class LongestCommonPrefixTest {
    @Test
    void test() {
        String[] strs = new String[]{"ab", "a"};
        System.out.println(longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        if (strs.length == 1) {
            return strs[0];
        }

        int maxCommonLength = strs[0].length();
        char[] maxCommonPrefix = new char[200];

        for (int i = 0; i < maxCommonLength; i++) {
            maxCommonPrefix[i] = strs[0].charAt(i);
        }

        int length;
        int subIndex;
        for (int i = 1; i < strs.length; i++) {
            length = strs[i].length();
            maxCommonLength = Math.min(length, maxCommonLength);

            for (subIndex = 0; subIndex < maxCommonLength; subIndex++) {
                if (maxCommonPrefix[subIndex] != strs[i].charAt(subIndex)) {
                    if (subIndex == 0) {
                        return "";
                    }
                    maxCommonLength = subIndex;
                }
            }
        }

        if (maxCommonLength == 0) {
            return "";
        }

        return new String(maxCommonPrefix, 0, maxCommonLength);
    }
}
