import java.util.LinkedList;
import java.util.Queue;

public class Serialize {
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

    private static int index = 0;

    public static void serialize(BinaryTreeNode root, StringBuilder stringBuilder) {
        if (root == null) {
            stringBuilder.append("$,");
            return;
        }
        stringBuilder.append(root.value + ",");
        serialize(root.left, stringBuilder);
        serialize(root.right, stringBuilder);
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

    public static BinaryTreeNode deserialize(StringBuilder stringBuilder) {
        String[] str = stringBuilder.toString().split(",");
        BinaryTreeNode root = null;
        index = 0;
        return deserialize(str, root);
    }

    private static BinaryTreeNode deserialize(String[] str, BinaryTreeNode root) {
        if (!str[index].equals("$")) {
            root = new BinaryTreeNode(new Integer(str[index++]));
            root.left = deserialize(str, root.left);
            root.right = deserialize(str, root.right);
        } else {
            index++;
        }
        return root;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(8);
        root.left = new BinaryTreeNode(8);
        root.right = new BinaryTreeNode(7);
        root.left.left = new BinaryTreeNode(9);
        root.left.right = new BinaryTreeNode(2);
        root.right.left = new BinaryTreeNode(7);
        root.right.right = new BinaryTreeNode(3);

        printWithLevel(root);

        StringBuilder str = new StringBuilder();
        serialize(root, str);

        BinaryTreeNode reRoot = deserialize(str);
        printWithLevel(reRoot);
    }
}