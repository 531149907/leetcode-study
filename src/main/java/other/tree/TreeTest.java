package other.tree;

import org.junit.Test;

import java.util.Arrays;
import java.util.stream.Collectors;

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
        int[] preOrder = new int[]{1, 2, 4, 3, 5, 7, 6};
        int[] midOrder = new int[]{4, 2, 1, 5, 7, 3, 6};

        TreeNode node = TreeNode.buildTree(Arrays.stream(preOrder).boxed().collect(Collectors.toList()), Arrays.stream(midOrder).boxed().collect(Collectors.toList()));
        TreeNode.preOrderTravel(node);
    }
}
