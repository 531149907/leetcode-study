package other.sort;

/**
 * 冒泡排序
 *
 * @author zhouzhixuan
 */
public class BubbleSortTest extends SortBase {
    @Override
    public Comparable[] sort(Comparable[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (less(array[j], array[i])) {
                    swap(array, i, j);
                }
            }
        }

        return array;
    }

    @Override
    public void test() {
        Integer[] array = new Integer[]{1, 456, 2, 3, 56, 8, 0, 44, 67, 3, 5, 9};

        sort(array);
        assert isSorted(array);

        show(array);
    }
}
