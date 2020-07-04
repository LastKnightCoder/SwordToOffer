import java.util.Stack;

public class FindPath {
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

    public static void findPath(BinaryTreeNode root, int expectedSum) {
        if (root == null) {
            return;
        }
        Stack<Integer> path = new Stack<>();
        int currentSum = 0;
        findPath(root, expectedSum, path, currentSum);
    }

    private static void findPath(BinaryTreeNode root, int expectedSum, Stack<Integer> path, int currentSum) {
        currentSum += root.value;
        path.push(root.value);

        boolean isLeaf = root.left == null && root.right == null;

        if (currentSum == expectedSum && isLeaf) {
            for (int i = 0; i < path.size(); i++) {
                if (i == path.size() - 1) {
                    System.out.println(path.get(i));
                } else {
                    System.out.print(path.get(i) + "->");
                }
            }
        }

        if (root.left != null) {
            findPath(root.left, expectedSum, path, currentSum);
        }
        if (root.right != null) {
            findPath(root.right, expectedSum, path, currentSum);
        }

        path.pop();
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(5);
        root.right = new BinaryTreeNode(12);
        root.left.left = new BinaryTreeNode(4);
        root.left.right = new BinaryTreeNode(7);

        findPath(root, 22);
    }
}