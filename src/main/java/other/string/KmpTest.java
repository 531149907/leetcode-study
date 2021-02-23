package other.string;

import org.junit.jupiter.api.Test;

/**
 * @author zhouzhixuan
 */
public class KmpTest {
    @Test
    void test() {
        String text = "abcbcab";
        String pattern = "ca";

        System.out.println(kmp(text, pattern));
    }

    private int kmp(String text, String pattern) {
        int textLength = text.length();
        int patternLength = pattern.length();
        int[] next = nextArray(pattern);
        int patternIndex = 0;

        // 开始对text逐位遍历
        for (int i = 0; i < textLength; i++) {

            // 如果正在比对的pattern下标不为0（说明i下标对应的字符和patternIndex对应的字符至少首字母已经匹配成功）
            // 如果对比时发现i对应的字符与patternIndex对应的字符匹配失败，
            // 那么利用next数组，将正在进行匹配的patternIndex往回退，退到patternIndex-1代表的字符表示的最大长度字符串而不是重新开始
            // 如果patternIndex等于0说明退化到了重头开始匹配
            while (patternIndex > 0 && pattern.charAt(patternIndex) != text.charAt(i)) {
                patternIndex = next[patternIndex - 1];
            }

            //如果i对应的字符和patternIndex对应的字符匹配成功了，patternIndex后移
            if (pattern.charAt(patternIndex) == text.charAt(i)) {
                patternIndex++;
            }

            //如果patternIndex等于pattern的长度，说明匹配完成了，返回的差值就是开始的下标
            if (patternIndex == patternLength) {
                return i - patternLength + 1;
            }
        }

        return -1;
    }

    private int[] nextArray(String pattern) {
        int index;
        int maxCommonLength;
        int patternLength = pattern.length();

        int[] next = new int[patternLength];
        next[0] = 0;

        //开始逐位遍历
        for (index = 1, maxCommonLength = 0; index < patternLength; index++) {

            //如果maxCommonLength大于0，并且当前字符与maxCommonLength推荐的下一个字符（pattern[maxCommonLength]）不一样，说明推荐的值太大了，减小（往左边走）
            //最小减到maxCommonLength为0，即推荐的字符串为p的首位（p[0]）时，没得再小了，可以安全退出while，相当于重头开始匹配
            while (maxCommonLength > 0 && pattern.charAt(index) != pattern.charAt(maxCommonLength)) {
                maxCommonLength = next[maxCommonLength - 1];
            }

            //说明maxCommonLength推荐的下一个字符和当前字符匹配，maxCommonLength往右+1（开始期待下一个字符的到来）
            if (pattern.charAt(index) == pattern.charAt(maxCommonLength)) {
                maxCommonLength++;
            }

            //存储当前下标的maxCommonLength
            next[index] = maxCommonLength;
        }

        return next;
    }
}
