package other.sort;

/**
 * 插入排序
 * <p>
 * 为了给插入的元素腾出空间，我们需要将其余所有元素在插入之前都向右移动一位
 *
 * @author zhouzhixuan
 */
public class InsertionSortTest extends SortBase {
    @Override
    public Comparable[] sort(Comparable[] array) {
        for (int i = 0; i < array.length; i++) {
            int j = i;
            while (j > 0 && less(array[j], array[j - 1])) {
                swap(array, j - 1, j);
                j--;
            }
        }

        return array;
    }

    @Override
    public void test() {
        Integer[] array = new Integer[]{1, 456, 2, 3, 56, 8, 0, 44, 67, 3, 5, 9};

        sort(array);
        show(array);

        assert isSorted(array);
    }
}
