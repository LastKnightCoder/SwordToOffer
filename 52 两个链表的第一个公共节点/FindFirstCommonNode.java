public class FindFirstCommonNode {
    private static class ListNode {
        ListNode next;
        int value;
        public ListNode(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static ListNode findFirstCommonNode(ListNode root1, ListNode root2) {
        if (root1 == null || root2 == null) {
            return null;
        }

        int length1 = getListLength(root1);
        int length2 = getListLength(root2);

        ListNode ahead = root1;
        ListNode after = root2;

        if (length2 - length1 > 0) {
            ahead = root2;
            after = root1;
        }

        for (int i = 0; i < Math.abs(length2 - length1); i++) {
            ahead = ahead.next;
        }

        while (ahead != null && after != null) {
            if (ahead == after) {
                return ahead;
            }
            ahead = ahead.next;
            after = after.next;
        }

        return null;
    }
    
    private static int getListLength(ListNode root) {
        ListNode cur = root;
        int length = 0;
        while (cur != null) {
            length++;
            cur = cur.next;
        }

        return length;
    }

    public static void main(String[] args) {
        ListNode root1 = new ListNode(2);
        root1.next = new ListNode(3);
        root1.next.next = new ListNode(6);

        ListNode root2 = new ListNode(5);
        root2.next = root1.next.next;

        ListNode commonNode = findFirstCommonNode(root1, root2);

        System.out.println(commonNode != null ? commonNode.value : "null");
    }
}