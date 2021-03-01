package other.tree;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * @author zhouzhixuan
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public final class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        this.value = x;
    }

    public static void preOrderTravel(TreeNode root) {
        if (root == null) {
            return;
        }

        System.out.println("pre: " + root.value);
        preOrderTravel(root.left);
        preOrderTravel(root.right);
    }

    public static void midOrderTravel(TreeNode root) {
        if (root == null) {
            return;
        }

        midOrderTravel(root.left);
        System.out.println("pre: " + root.value);
        midOrderTravel(root.right);
    }

    public static void lastOrderTravel(TreeNode root) {
        if (root == null) {
            return;
        }

        lastOrderTravel(root.left);
        lastOrderTravel(root.right);
        System.out.println("pre: " + root.value);
    }

    public static TreeNode buildTree(List<Integer> preOrder, List<Integer> midOrder) {
        if(preOrder.isEmpty()){
            return null;
        }

        TreeNode treeNode = new TreeNode(preOrder.get(0));

        if (midOrder.size() == 1) {
            return treeNode;
        }

        int splitIndex = -1;

        for (int i = 0; i < midOrder.size(); i++) {
            if (midOrder.get(i) == treeNode.value) {
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
}