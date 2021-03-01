package easy;

import org.junit.Test;

/**
 * @author zhouzhixuan
 */
public class BalancedBinaryTreeTest {
    @Test
    public void test() {
        TreeNode node = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3)));
        System.out.println(isBalanced(node));
    }

    public boolean isBalanced(TreeNode root) {
        return heightForTree(root) != -1;
    }

    public int heightForTree(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftHeight = heightForTree(node.left);
        int rightHeight = heightForTree(node.right);

        if (Math.abs(leftHeight - rightHeight) >= 2 || leftHeight == -1 || rightHeight == -1) {
            return -1;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }


    public static final class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
