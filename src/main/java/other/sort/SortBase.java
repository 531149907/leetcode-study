package other.sort;

import org.junit.Test;

/**
 * @author zhouzhixuan
 */
public abstract class SortBase {
    public abstract Comparable[] sort(Comparable[] array);

    @Test
    public abstract void test();

    protected boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    protected void swap(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    protected void show(Comparable[] a) {
        StringBuilder builder = new StringBuilder();
        builder.append("[");

        for (Comparable comparable : a) {
            builder.append(comparable).append(", ");
        }

        String result = builder.toString();
        int commaLastIndex = result.lastIndexOf(",");

        System.out.println(result.substring(0, commaLastIndex) + "]");
    }

    protected boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }
}
