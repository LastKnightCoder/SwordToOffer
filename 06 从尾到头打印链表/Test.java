import java.util.Stack;

public class Test {

    private static class ListNode {
        private int value;
        private ListNode next;

        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }

        public ListNode(int value) {
            this(value, null);
        }
    }

    public static void printListReverse(ListNode root) {
        Stack<Integer> stack = new Stack<>();
        ListNode cur = root;
        while (cur != null) {
            stack.push(cur.value);
            cur = cur.next;
        }

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }

    public static void printListReverse2(ListNode root) {
        if (root == null) {
            return;
        }
        printListReverse2(root.next);
        System.out.println(root.value);
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        printListReverse2(root);
    }
}