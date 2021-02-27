package other.sort;

/**
 * 选择排序
 * <p>
 * 首先，先找到数组中最小的元素，其次，将它和数组的第一个元素交换位置。
 * 再次，在剩下的元素中找到最小的元素，将它与数组的第二个元素交换，如此往复直到将整个数组排序，
 *
 * @author zhouzhixuan
 */
public class SelectSortTest extends SortBase {
    @Override
    public Comparable[] sort(Comparable[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (less(array[j], array[minIndex])) {
                    minIndex = j;
                }
            }
            swap(array, minIndex, i);
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
