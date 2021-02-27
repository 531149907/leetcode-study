package other.sort;

/**
 * 归并排序
 * <p>
 * 可以递归地将一个数组分为两半分别排序，最后将结果归并起来
 * 该算法采用经典的分治（divide-and-conquer）策略（分治法将问题分(divide)成一些小的问题然后递归求解，
 * 而治(conquer)的阶段则将分的阶段得到的各答案"修补"在一起，即分而治之)。
 *
 * @author zhouzhixuan
 */
public class MergeSortTest extends SortBase {
    @Override
    public Comparable[] sort(Comparable[] array) {
        int length = array.length;
        Comparable[] result = new Comparable[length];

        for (int blockSize = 1; blockSize < length * 2; blockSize = blockSize * 2) {
            for (int startIndex = 0; startIndex < length; startIndex = startIndex + blockSize * 2) {
                int low = startIndex;
                int mid = Math.min((startIndex + blockSize), length);
                int high = Math.min(startIndex + 2 * blockSize, length);

                //两个块的起始下标及结束下标
                int start1 = low, end1 = mid;
                int start2 = mid, end2 = high;

                //开始对两个block进行归并排序
                while (start1 < end1 && start2 < end2) {
                    result[low++] = less(array[start1], array[start2]) ? array[start1++] : array[start2++];
                }

                while (start1 < end1) {
                    result[low++] = array[start1++];
                }

                while (start2 < end2) {
                    result[low++] = array[start2++];
                }
            }
            Comparable[] temp = array;
            array = result;
            result = temp;
        }

        return array;
    }

    private Comparable[] aux;

    public void sort1(Comparable[] array, int low, int high) {
        if (high <= low) {
            return;
        }

        int middle = low + (high - low) / 2;
        sort1(array, low, middle);
        sort1(array, middle, low);
        merge(array, low, middle, high);
    }

    public void merge(Comparable[] array, int low, int middle, int high) {
        int i = low;
        int j = middle + 1;

        if (high + 1 - low >= 0) {
            System.arraycopy(array, low, aux, low, high + 1 - low);
        }

        for (int k = low; k <= high; k++) {
            if (i > middle) {
                array[k] = aux[j++];
                break;
            }

            if (j > high) {
                array[k] = aux[i++];
                break;
            }

            if (less(aux[j], aux[i])) {
                array[k] = aux[j++];
                break;
            }

            array[k] = aux[i++];
        }
    }

    @Override
    public void test() {
        Integer[] array = new Integer[]{1, 456, 2, 3, 56, 8, 0, 44, 67, 3, 5};

        sort(array);
        assert isSorted(array);

        show(array);
    }
}
