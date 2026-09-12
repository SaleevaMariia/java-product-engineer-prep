package algorithms.DFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class InvertTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                4,
                new TreeNode(
                        2,
                        new TreeNode(1),
                        new TreeNode(3)
                ),
                new TreeNode(
                        7,
                        new TreeNode(6),
                        new TreeNode(9)
                )
        );


        printTreeAsArray(invertTree(root));


    }

    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        invertTree(root.left);
        invertTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
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

    public static void printTreeAsArray(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }

        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                result.add(null);
            } else {
                result.add(node.val);

                queue.add(node.left);
                queue.add(node.right);
            }
        }

        // Убираем лишние null в конце массива
        while (!result.isEmpty() && result.get(result.size() - 1) == null) {
            result.remove(result.size() - 1);
        }

        System.out.println(result);
    }

}
