package easy;

import org.junit.jupiter.api.Test;

import java.util.Stack;

/**
 * @author zhouzhixuan
 */
public class ValidParenthesesTest {
    @Test
    void test() {
        String s = "{}[({[]})]";
        System.out.println(isValid(s));
    }

    public boolean isValid(String s) {
        int length = s.length();

        if (length % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            switch (s.charAt(i)) {
                case ')':
                    if (stack.isEmpty() || '(' != stack.pop()) {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || '[' != stack.pop()) {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || '{' != stack.pop()) {
                        return false;
                    }
                    break;
                default:
                    stack.push(s.charAt(i));
            }
        }

        return stack.isEmpty();
    }
}
