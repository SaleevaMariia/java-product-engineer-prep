package algorithms.DFS;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeInorderTraversal {
    static List<Integer> result = new ArrayList<>();


    public static void main(String[] args) {

        TreeNode root = new TreeNode(
                1,
                new TreeNode(
                        2,
                        new TreeNode(4),
                        new TreeNode(
                                5,
                                new TreeNode(6),
                                new TreeNode(7)
                        )
                ),
                new TreeNode(
                        3,
                        null,
                        new TreeNode(
                                8,
                                new TreeNode(9),
                                null
                        )
                )
        );

        System.out.println(inorderTraversal(root));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        if (root == null){
            System.out.println("root is null, return");
            return result;
        }
        System.out.println("enter node " + root.val);

        System.out.println("go left from " + root.val);
        inorderTraversal(root.left);

        System.out.println("add " + root.val);
        result.add(root.val);

        System.out.println("go right from " + root.val);
        inorderTraversal(root.right);

        System.out.println("return from node " + root.val);
        return result;
    }

    public static class TreeNode {
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
