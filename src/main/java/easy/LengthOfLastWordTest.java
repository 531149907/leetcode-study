package easy;

import org.junit.Test;

/**
 * @author zhouzhixuan
 */
public class LengthOfLastWordTest {
    @Test
    public void test() {
        String s = "a ";
        System.out.println(lengthOfLastWord(s));
    }

    public int lengthOfLastWord(String s) {
        s = s.trim();

        if (s.isEmpty()) {
            return 0;
        }

        int length = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                length++;
            }else{
               break;
            }
        }

        return length;
    }
}
