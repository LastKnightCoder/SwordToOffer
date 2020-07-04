public class TreeDepth {
    private static class BinaryTreeNode {
        BinaryTreeNode left;
        BinaryTreeNode right;
        int value;
        public BinaryTreeNode(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static int getTreeDepth(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = getTreeDepth(root.left);
        int rightDepth = getTreeDepth(root.right);

        return (leftDepth > rightDepth) ? (leftDepth + 1) : (rightDepth + 1);
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(8);
        root.right = new BinaryTreeNode(12);
        root.left.left = new BinaryTreeNode(7);
        root.left.right = new BinaryTreeNode(9);
        root.right.left = new BinaryTreeNode(11);
        root.right.right = new BinaryTreeNode(13);

        int depth = getTreeDepth(root);
        System.out.println(depth);
    }
}