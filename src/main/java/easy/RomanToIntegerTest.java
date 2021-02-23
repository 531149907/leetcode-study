package easy;

import org.junit.jupiter.api.Test;

import java.util.Map;

/**
 * @author zhouzhixuan
 */
public class RomanToIntegerTest {
    @Test
    void test() {
        String s = "DCXXI";
        System.out.println(romanToInt(s));
    }

    public int romanToInt(String s) {
        int length = s.length();

        if (length == 1) {
            return getValue(s.charAt(0));
        }

        int i = 0;
        int sum = 0;
        char currentChar;
        char nextChar;
        int currentValue;
        int nextValue;

        while (true) {
            if (i >= length) {
                return sum;
            } else if (i + 1 == length) {
                sum += getValue(s.charAt(i));
                return sum;
            } else {
                currentChar = s.charAt(i);
                currentValue = getValue(currentChar);
                nextChar = s.charAt(i + 1);
                nextValue = getValue(nextChar);
            }

            if (currentValue >= nextValue) {
                sum += currentValue;
                i++;
            } else {
                switch (currentChar) {
                    case 'I':
                        if (nextChar == 'V' || nextChar == 'X') {
                            sum += nextValue - currentValue;
                        }
                        break;
                    case 'X':
                        if (nextChar == 'L' || nextChar == 'C') {
                            sum += nextValue - currentValue;
                        }
                        break;
                    case 'C':
                        if (nextChar == 'D' || nextChar == 'M') {
                            sum += nextValue - currentValue;
                        }
                        break;
                    default:
                }
                i += 2;
            }
        }
    }

    private int getValue(char c) {
        switch (c) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
