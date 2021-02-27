package easy;

import org.junit.Test;

/**
 * @author zhouzhixuan
 */
public class ToeplitzMatrixTest {
    @Test
    public void test() {
        int[][] matrix = new int[][]{{1, 2, 3, 4}, {5, 1, 2, 3}, {9, 5, 1, 2}};
        System.out.println(isToeplitzMatrix(matrix));
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        int yMaxIndex = matrix.length - 1;
        int xMaxIndex = matrix[0].length - 1;

        if (yMaxIndex == 0 || xMaxIndex == 0) {
            return true;
        }

        int x = 1;
        for (int y = 1; y <= yMaxIndex; y++) {
            for (; x <= xMaxIndex; x++) {
                if (matrix[y][x] != matrix[y - 1][x - 1]) {
                    return false;
                }
            }
            x = 1;
        }

        return true;
    }
}
