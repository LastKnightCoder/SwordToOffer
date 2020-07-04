import java.util.LinkedList;
import java.util.Queue;

public class PrintWithLevel {
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

    public static void printWithLevel(BinaryTreeNode root) {
        if (root == null) {
            return;
        }

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int nextLevel = 0;
        int toBePrinted = 1;

        while (!queue.isEmpty()) {
            BinaryTreeNode node = queue.poll();
            System.out.print(node.value + "\t");
            toBePrinted--;

            if (node.left != null) {
                queue.offer(node.left);
                nextLevel++;
            }
            if (node.right != null) {
                queue.offer(node.right);
                nextLevel++;
            }

            if (toBePrinted == 0) {
                System.out.println();
                toBePrinted = nextLevel;
                nextLevel = 0;
            }
        }
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(8);
        root.left = new BinaryTreeNode(8);
        root.right = new BinaryTreeNode(7);
        root.left.left = new BinaryTreeNode(9);
        root.left.right = new BinaryTreeNode(2);
        root.right.left = new BinaryTreeNode(7);
        root.right.right = new BinaryTreeNode(3);
        //      8
        //   8    7
        // 9   2
        printWithLevel(root);
    }
}