public class NextNode {
    private static class BinaryTree {
        int value;
        BinaryTree parent;
        BinaryTree left;
        BinaryTree right;
        public BinaryTree(int value) {
            this.value = value;
        }
    }

    public static BinaryTree findNext(BinaryTree node) {
        if (node == null) {
            return null;
        }

        if (node.right != null) {
            BinaryTree next = node.right;
            while (next.left != null) {
                next = next.left;
            }
            return next;
        } else if (node.parent != null) {
            if (node == node.parent.left) {
                return node.parent;
            } else {
                while (node.parent != null) {
                    if (node == node.parent.left) {
                        return node.parent;
                    }
                    node = node.parent;
                }
                return null;
            }
        } else {
            return null;
        }

    }
}