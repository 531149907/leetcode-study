package other.sort;

/**
 * 希尔排序
 * <p>
 * 基于插入排序的快速排序。
 * 先将整个待排记录序列分割成若干子序列，对每个子序列内部都执行插入排序，待整个序列中的记录“基本有序”时，再对全体记录进行一次直接插入排序。
 *
 * @author zhouzhixuan
 */
public class ShellSortTest extends SortBase {
    @Override
    public Comparable[] sort(Comparable[] array) {
        int length = array.length;

        if (length == 0 || length == 1) {
            return array;
        }

        for (int gap = length / 2; gap > 0; gap = gap / 2) {
            for (int i = 0; i < length; i++) {
                int j = i;
                while (j + gap < length) {

                    if (less(array[j + gap], array[j])) {
                        swap(array, j, j + gap);
                    }

                    j = j + gap;
                }
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
