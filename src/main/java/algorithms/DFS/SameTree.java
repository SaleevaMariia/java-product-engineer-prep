package algorithms.DFS;

public class SameTree {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(
                1,
                new TreeNode(2),
                new TreeNode(3)
        );

        TreeNode q = new TreeNode(
                1,
                new TreeNode(2),
                new TreeNode(5)
        );

        System.out.println(isSameTree(p, q));

    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null) {
            return q == null;
        } else {
            if (q == null) return false;
        }

        boolean isLeft = isSameTree(p.left, q.left);
        boolean isRight = isSameTree(p.right, q.right);

        return (p.val == q.val) & isLeft & isRight;
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
