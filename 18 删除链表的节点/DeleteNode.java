public class DeleteNode {

    private static class ListNode {
        ListNode next;
        int value;

        public ListNode(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static ListNode deleteNode(ListNode root, ListNode toBeDeletedNode) {
        if (root == null || toBeDeletedNode == null) {
            return root;
        }
        if (toBeDeletedNode.next != null) {
            toBeDeletedNode.value = toBeDeletedNode.next.value;
            ListNode deleteNext = toBeDeletedNode.next;
            toBeDeletedNode.next = deleteNext.next;
            deleteNext = null;
        } else {
            ListNode cur = root;
            if (cur == toBeDeletedNode) {
                root = null;
                toBeDeletedNode = null;
                return root;
            }
            while(cur.next != toBeDeletedNode) {
                cur = cur.next;
            }
            cur.next = null;
            toBeDeletedNode = null;
        }

        return root;
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
        root.next.next = new ListNode(3);
        root.next.next.next = new ListNode(4);
        root.next.next.next.next = new ListNode(5);
        printList(root); // 1->2->3->4->5

        root = deleteNode(root, root.next.next.next.next);
        printList(root); // 1->2->3->4

        root = deleteNode(root, root);
        printList(root); // 2->3->4

        root = deleteNode(root, root.next);
        printList(root); // 2->4

        root = deleteNode(root, root.next);
        printList(root); // 2

        root = deleteNode(root, root);
        printList(root); // 
    }
}