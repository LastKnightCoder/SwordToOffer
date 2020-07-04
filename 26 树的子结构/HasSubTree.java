public class HasSubTree {
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

    public static boolean hasSubTree(BinaryTreeNode root, BinaryTreeNode subRoot) {
        boolean result = false;
        if (root != null && subRoot != null) {
            if (root.value == subRoot.value) {
                result = DoesTree1HaveTree2(root, subRoot);
            }
            if (!result) {
                result = hasSubTree(root.left, subRoot);
            }
            if (!result) {
                result = hasSubTree(root.right, subRoot);
            }
        }
        return result;
    }

    private static boolean DoesTree1HaveTree2(BinaryTreeNode root, BinaryTreeNode subRoot) {
        if (subRoot == null) { 
            return true;
        }
        if (root == null) {
            return false;
        }

        if (root.value != subRoot.value) {
            return false;
        }

        return DoesTree1HaveTree2(root.left, subRoot.left) && 
               DoesTree1HaveTree2(root.right, subRoot.right);
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(8);
        root.left = new BinaryTreeNode(8);
        root.right = new BinaryTreeNode(7);
        root.left.left = new BinaryTreeNode(9);
        root.left.right = new BinaryTreeNode(2);

        BinaryTreeNode subRoot = new BinaryTreeNode(8);
        subRoot.left = new BinaryTreeNode(9);
        subRoot.right = new BinaryTreeNode(2);

        System.out.println(hasSubTree(root, subRoot));
    }
}