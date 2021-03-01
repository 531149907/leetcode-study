package medium;

import org.junit.Test;

/**
 * @author zhouzhixuan
 */
public class MaximumBinaryTreeTest {
    @Test
    public void test() {

    }

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return maxTree(nums, 0, nums.length - 1);
    }

    public TreeNode maxTree(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }

        int maxIndex = findMaxValueIndex(nums, l, r);
        TreeNode root = new TreeNode(nums[maxIndex]);
        root.left = maxTree(nums, l, maxIndex - 1);
        root.right = maxTree(nums, maxIndex + 1, r);
        return root;
    }

    public int findMaxValueIndex(int[] nums, int l, int r) {
        int max = nums[l];
        int index = l;

        for (int i = l; i <= r; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }

        return index;
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
