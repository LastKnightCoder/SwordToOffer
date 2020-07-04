public class Test {
    private static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static BinaryTree constructBinaryTree(int[] preorder, int[] inorder) throws Exception{
        if (preorder == null || inorder == null) {
            throw new Exception("preorder or inorder is null");
        }

        return helpContructBinaryTree(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    private static BinaryTree helpContructBinaryTree(int[] preorder, int preStart, int preEnd,
                               int[] inorder, int inStart, int inEnd) throws Exception{

        BinaryTree root = new BinaryTree(preorder[preStart]);

        if (preStart == preEnd) {
            if (inStart == inEnd && preorder[preStart] == inorder[inStart]) {
                return root;
            } else {
                throw new Exception("wrong input");
            }
        }

        int inOrderRoot = inStart;
        for (; inOrderRoot <= inEnd; inOrderRoot++) {
            if (inorder[inOrderRoot] == root.value) {
                break;
            }
        }

        if (inOrderRoot > inEnd) {
            throw new Exception("wrong input");
        }

        int leftLength = inOrderRoot - inStart;
        int rightLength = inEnd - inOrderRoot;
        if (leftLength > 0) {
            root.left = helpContructBinaryTree(preorder, preStart + 1, preStart + leftLength,
                    inorder, inStart, inOrderRoot - 1);
        }
        if (rightLength > 0) {
            root.right = helpContructBinaryTree(preorder, preStart + leftLength + 1, preEnd,
                    inorder, inOrderRoot + 1, inEnd);
        }

        return root;

    }

    public static void printTree(BinaryTree root) {
        if (root != null) {
            System.out.println(root.value);
            printTree(root.left);
            printTree(root.right);
        }
    }

    public static void main(String[] args) throws Exception{
        int[] preorder = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] inorder = {4, 7, 2, 1, 5, 3, 8, 6};
        BinaryTree root = constructBinaryTree(preorder, inorder);

        printTree(root);
    }
}