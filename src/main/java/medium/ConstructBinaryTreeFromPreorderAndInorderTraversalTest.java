package medium;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhouzhixuan
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversalTest {
    @Test
    public void test() {

    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(Arrays.stream(preorder).boxed().collect(Collectors.toList()), Arrays.stream(inorder).boxed().collect(Collectors.toList()));
    }

    public TreeNode buildTree(List<Integer> preOrder, List<Integer> midOrder) {
        if(preOrder.isEmpty()){
            return null;
        }

        TreeNode treeNode = new TreeNode(preOrder.get(0));

        if (midOrder.size() == 1) {
            return treeNode;
        }

        int splitIndex = -1;

        for (int i = 0; i < midOrder.size(); i++) {
            if (midOrder.get(i) == treeNode.val) {
                splitIndex = i;
                break;
            }
        }

        List<Integer> pre1 = preOrder.subList(1, splitIndex + 1);
        List<Integer> mid1 = midOrder.subList(0, splitIndex);

        List<Integer> pre2 = preOrder.subList(splitIndex + 1, preOrder.size());
        List<Integer> mid2 = midOrder.subList(splitIndex + 1, midOrder.size());

        treeNode.left = buildTree(pre1, mid1);
        treeNode.right = buildTree(pre2, mid2);

        return treeNode;
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
