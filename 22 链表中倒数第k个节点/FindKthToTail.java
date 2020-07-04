public class FindKthToTail {
    private static class ListNode {
        public ListNode next;
        public int value;

        public ListNode(int value) {
            this.next = null;
            this.value = value;
        }
    }

    public static ListNode findKthToTail(ListNode root, int k) {
        if (root == null || k <= 0) {
            return null;
        }

        ListNode ahead = root;
        ListNode after = root;

        for (int i = 0; i < k - 1; i++) {
            if (ahead.next == null) {
                return null;
            }
            ahead = ahead.next;
        }

        while(ahead.next != null) {
            ahead = ahead.next;
            after = after.next;
        }

        return after;
    }

    public static void main(String[] args) {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);

        ListNode result = findKthToTail(root, 2);

        System.out.println(result != null ? result.value : "null");
    }
}