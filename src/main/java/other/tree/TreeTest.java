package other.tree;

import org.junit.Test;

/**
 * @author zhouzhixuan
 */
public class TreeTest {
    @Test
    public void travelTest() {
        TreeNode n1 = new TreeNode(7);
        TreeNode n2 = new TreeNode(8, new TreeNode(10), new TreeNode(11));
        TreeNode n3 = new TreeNode(4, n1, n2);
        TreeNode n4 = new TreeNode(9, new TreeNode(12), null);
        TreeNode n5 = new TreeNode(5, n4, null);
        TreeNode n6 = new TreeNode(2, n3, n5);
        TreeNode n7 = new TreeNode(3, new TreeNode(6), null);
        TreeNode root = new TreeNode(1, n6, n7);

        TreeNode.lastOrderTravel(root);
    }


    @Test
    public void rebuildTest() {
        int[] midOrder = new int[]{7, 4, 10, 8, 11, 2, 12, 9, 5, 1, 6, 3};
        int[] lastOrder = new int[]{7, 10, 11, 8, 4, 12, 9, 5, 2, 6, 3, 1};


    }
}
