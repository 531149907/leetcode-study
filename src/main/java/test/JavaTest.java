package test;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author zhouzhixuan
 */
public class JavaTest {
    @Test
    public void test1() {
        int[] array = new int[]{1, 2, 3, 4};
        modifyArray(array, 2, 3);
        System.out.println(Arrays.toString(array));
    }

    private void modifyArray(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void test2() {
        int gap = 1;
        int result = gap / 2;
        System.out.println(gap);
    }
}
