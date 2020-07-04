public class SymmetricalTree {
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

    public static boolean isSymmetrical(BinaryTreeNode root) {
        return isSymmetrical(root, root);
    }

    private static boolean isSymmetrical(BinaryTreeNode root1, BinaryTreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }

        if (root1 == null || root2 == null) {
            return false;
        }

        if (root1.value != root2.value) { 
            return false;
        }

        return isSymmetrical(root1.left, root2.right) && isSymmetrical(root1.right, root2.left);
    }
    
    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(8);
        root.left = new BinaryTreeNode(6);
        root.right = new BinaryTreeNode(10);
        root.left.left = new BinaryTreeNode(5);
        root.left.right = new BinaryTreeNode(7);
        root.right.left = new BinaryTreeNode(9);
        root.right.right = new BinaryTreeNode(11);
        boolean isSymme = isSymmetrical(root);
        System.out.println(isSymme);
    }
}