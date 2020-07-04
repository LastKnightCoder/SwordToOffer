public class ReverseList {
    private static class ListNode {
        public ListNode next;
        public int value;
        public ListNode(int value) {
            this.next = null;
            this.value = value;
        }
    }

    public static ListNode reverseList(ListNode root) {
        ListNode reverseRoot = null;
        ListNode curNode = root;
        ListNode preNode = null;
        while (curNode != null) {
            ListNode nextNode = curNode.next;
            if (nextNode == null) {
                reverseRoot = curNode;
            }
            curNode.next = preNode;
            preNode = curNode;
            curNode = nextNode;
        }
        return reverseRoot;
    }

    public static ListNode reverseListRecursion(ListNode root) {
        if (root.next == null) {
            return root;
        }
        ListNode last = reverseListRecursion(root.next);
        root.next.next = root;
        root.next = null;
        return last;

    }

    public static void printList(ListNode root) {
        while (root != null) {
            if (root.next != null) {
                System.out.print(root.value + "->");
            } else {
                System.out.println(root.value);
            }
            root = root.next;
        }
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new  ListNode(3);
        printList(root);
        // root = reverseList(root);
        root = reverseListRecursion(root);
        printList(root);
    }
}