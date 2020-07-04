public class Convert {
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

    public static BinaryTreeNode convert(BinaryTreeNode root) {
        BinaryTreeNode preNode = null;
        convert(root, preNode);
        BinaryTreeNode convertRoot = preNode;
        while (convertRoot.left != null && convertRoot != null) {
            convertRoot = convertRoot.left;
        }
        return convertRoot;
    }

    private static void convert(BinaryTreeNode root, BinaryTreeNode preNode) {
        if (root == null) {
            return;
        }

        BinaryTreeNode cur = root;

        if (cur.left != null) {
            convert(cur.left, preNode);
        }

        cur.left = preNode;
        if (preNode != null) {
            preNode.right = cur;
        }
        preNode = cur;

        if (cur.right != null) {
            convert(cur.right, preNode);
        }
    }
}