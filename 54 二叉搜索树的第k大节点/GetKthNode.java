public class GetKthNode {
    private static int count;

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

    public static BinaryTreeNode getKthNode(BinaryTreeNode root, int k) {
        if (root == null || k <= 0) {
            return null;
        }
        count = k;
        return getKthNode(root);
    }

    private static BinaryTreeNode getKthNode(BinaryTreeNode root) {
        BinaryTreeNode target = null;
        if (root.left != null) {
            target = getKthNode(root.left);
        }
        
        if (target == null) {
            if (count == 1) {
                target = root;
            }
            count--;
        }

        if (target == null && root.right != null) {
            target = getKthNode(root.right);
        }

        return target;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(8);
        root.right = new BinaryTreeNode(12);
        root.left.left = new BinaryTreeNode(7);
        root.left.right = new BinaryTreeNode(9);
        root.right.left = new BinaryTreeNode(11);
        root.right.right = new BinaryTreeNode(13);

        BinaryTreeNode target = getKthNode(root, 2);
        System.out.println(target != null ? target.value : "null");
    }
}