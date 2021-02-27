package other.tree;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author zhouzhixuan
 */
@Getter
@Setter
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

    public static TreeNode buildTree(int[] preOrderTravel, int[] midOrderTravel) {
        if (preOrderTravel.length == 0) {
            return null;
        }

        if (midOrderTravel.length == 0) {
            return null;
        }

        TreeNode root = new TreeNode(preOrderTravel[0]);
        root.left = buildTree();
        root.right = buildTree();
    }
}