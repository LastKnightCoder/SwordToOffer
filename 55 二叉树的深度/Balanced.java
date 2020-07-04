import java.util.HashMap;
import java.util.Map;

public class Balanced {
    public static int depth;
    public static int leftDepth;
    public static int rightDepth;
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

    public static int getTreeDepth(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftDepth = getTreeDepth(root.left);
        int rightDepth = getTreeDepth(root.right);

        return (leftDepth > rightDepth) ? (leftDepth + 1) : (rightDepth + 1);
    }

//    public static boolean isBalanced(BinaryTreeNode root) {
//        if (root == null) {
//            return true;
//        }
//
//        int left = getTreeDepth(root.left);
//        int right = getTreeDepth(root.right);
//
//        int diff = left - right;
//
//        if (Math.abs(diff) > 1) {
//            return false;
//        }
//
//        return isBalanced(root.left) && isBalanced(root.right);
//    }

    public static boolean isBalanced(BinaryTreeNode root) {
        Map<BinaryTreeNode, Integer> depthMap = new HashMap<>();
        return isBalanced(root, depthMap);
    }

    public static boolean isBalanced(BinaryTreeNode root, Map<BinaryTreeNode, Integer> depthMap) {
        if (root == null) {
            depthMap.put(root, 0);
            return true;
        }

        if (isBalanced(root.left, depthMap) && isBalanced(root.right, depthMap)) {
            int leftDepth = depthMap.get(root.left);
            int rightDepth = depthMap.get(root.right);

            if (Math.abs(leftDepth - rightDepth) <= 1) {
                int depth = leftDepth > rightDepth ? leftDepth + 1 : rightDepth + 1;
                depthMap.put(root, depth);
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(10);
        root.left = new BinaryTreeNode(8);
        root.right = new BinaryTreeNode(12);
        root.left.left = new BinaryTreeNode(7);
        root.left.right = new BinaryTreeNode(9);
        root.right.left = new BinaryTreeNode(11);
        root.right.right = new BinaryTreeNode(13);
        root.left.left.left = new BinaryTreeNode(5);
        root.left.left.left.left = new BinaryTreeNode(3);

        boolean isBanlance = isBalanced(root);
        System.out.println(isBanlance);
    }
}