public class MirrorTree {
    private static class BinaryTreeNode {
        private BinaryTreeNode left;
        private BinaryTreeNode right;
        int value;
        public BinaryTreeNode(int value) {
            this.left = null;
            this.right = null;
            this.value = value;
        }
    }

    public static BinaryTreeNode mirrorTree(BinaryTreeNode root) {
        if (root == null) {
            return null;
        }

        BinaryTreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        if (root.left != null) {
            root.left = mirrorTree(root.left);
        }
        if (root.right != null) {
            root.right = mirrorTree(root.right);
        }

        return root;
    }

    public static void printTree(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.value);
        printTree(root.left);
        printTree(root.right);
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(8);
        root.left = new BinaryTreeNode(6);
        root.right = new BinaryTreeNode(10);
        root.left.left = new BinaryTreeNode(5);
        root.left.right = new BinaryTreeNode(7);
        root.right.left = new BinaryTreeNode(9);
        root.right.right = new BinaryTreeNode(11);

        root = mirrorTree(root);

        printTree(root);
    }
}