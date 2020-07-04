public class DeleteDuplicationNode {

    private static class ListNode {
        ListNode next;
        int value;
        public ListNode(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static void deleteDuplicationNode(ListNode root) {
        if (root == null) {
            return;
        }

        ListNode cur = root;
        while(cur.next != null) {
            if (cur.value == cur.next.value) {
                ListNode curNext = cur.next;
                cur.next = curNext.next;
                curNext = null;
            } else {
                cur = cur.next;
            }
        }
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
        root.next = new ListNode(1);
        root.next.next = new ListNode(2);
        root.next.next.next = new ListNode(2);
        root.next.next.next.next = new ListNode(2);
        root.next.next.next.next.next = new ListNode(3);

        printList(root); // 1->1->2->2->2->3

        deleteDuplicationNode(root); // 1->2->3

        printList(root);
    }
}