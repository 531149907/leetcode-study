package easy;


import org.junit.Test;

/**
 * @author zhouzhixuan
 */
public class AddBinaryTest {
    @Test
    public void test() {
        String a = "1111";
        String b = "1111";

        System.out.println(addBinary(a, b));
    }

    public String addBinary(String a, String b) {
        if (a == null || a.length() == 0) {
            return b;
        }

        if (b == null || b.length() == 0) {
            return a;
        }

        int aLength = a.length();
        int bLength = b.length();

        if (aLength > bLength) {
            StringBuilder bBuilder = new StringBuilder(b);
            for (int i = 0; i < aLength - bLength; i++) {
                bBuilder.insert(0, '0');
            }
            b = bBuilder.toString();
        }

        if (aLength < bLength) {
            StringBuilder aBuilder = new StringBuilder(a);
            for (int i = 0; i < bLength - aLength; i++) {
                aBuilder.insert(0, '0');
            }
            a = aBuilder.toString();
        }

        StringBuilder builder = new StringBuilder();
        boolean shouldCarry = false;
        int index = Math.max(aLength, bLength) - 1;

        while (index != -1) {
            if (shouldCarry) {
                if (a.charAt(index) == '0' && b.charAt(index) == '0') {
                    shouldCarry = false;
                    builder.append('1');
                } else if (a.charAt(index) == '1' && b.charAt(index) == '1') {
                    builder.append('1');
                } else {
                    builder.append('0');
                }
            } else {
                if (a.charAt(index) == b.charAt(index)) {
                    if (a.charAt(index) == '1') {
                        shouldCarry = true;
                    }
                    builder.append('0');
                } else {
                    builder.append('1');
                }
            }

            index--;
        }

        return (shouldCarry ? '1' : "") + builder.reverse().toString();
    }
}
