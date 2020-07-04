import java.util.LinkedList;
import java.util.Queue;

public class PrintFromTopToBottom {
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

    public static void printFromTopToBottom(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        Queue<BinaryTreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            System.out.println(node.value);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(8);
        root.left = new BinaryTreeNode(8);
        root.right = new BinaryTreeNode(7);
        root.left.left = new BinaryTreeNode(9);
        root.left.right = new BinaryTreeNode(2);

        //      8
        //   8     7
        //9   2
        printFromTopToBottom(root);
    }
}