import java.util.Stack;

public class PrintZhi {
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

    public static void printZhi(BinaryTreeNode root) {
        if (root == null) {
            return;
        }
        Stack<BinaryTreeNode> stack1 = new Stack<>();
        Stack<BinaryTreeNode> stack2 = new Stack<>();

        stack1.push(root);
        int level = 1;

        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (level % 2 == 1) {
                BinaryTreeNode node = stack1.pop();
                System.out.print(node.value + "\t");
                if (node.left != null) {
                    stack2.push(node.left);
                }
                if (node.right != null) {
                    stack2.push(node.right);
                }
                if (stack1.isEmpty()) {
                    System.out.println();
                    level++;
                }
            } else {
                BinaryTreeNode node = stack2.pop();
                System.out.print(node.value + "\t");
                if (node.right != null) {
                    stack1.push(node.right);
                }
                if (node.left != null) {
                    stack1.push(node.left);
                }
                if (stack2.isEmpty()) {
                    System.out.println();
                    level++;
                }
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
        //       8
        //   8      7
        // 9   2 7    3
        printZhi(root);
    }
}