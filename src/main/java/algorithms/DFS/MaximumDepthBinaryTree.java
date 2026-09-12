package algorithms.DFS;

public class MaximumDepthBinaryTree {

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


        System.out.println(maxDepth(root));
    }

    public static int maxDepth(MaximumDepthBinaryTree.TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return 1 + Math.max(left, right);
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