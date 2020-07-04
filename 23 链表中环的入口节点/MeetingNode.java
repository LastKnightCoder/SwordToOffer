public class MeetingNode {
    private static class ListNode {
        public ListNode next;
        public int value;
        public ListNode(int value) {
            this.next = null;
            this.value = value;
        }
    }

    public static ListNode meetingNode(ListNode root) {
        if (root == null) {
            return null;
        }

        ListNode slow = root.next;
        if (slow == null) {
            return null;
        } 
        ListNode fast = slow.next;

        while (slow != null && fast != null) {
            if (slow == fast) {
                return fast;
            }

            slow = slow.next;
            fast = fast.next;
            if (fast != null) {
                fast = fast.next;
            }
        }

        return null;
    }

    public static ListNode entryNodeOfLoop(ListNode root) {
        ListNode meetingNode = meetingNode(root);
        if (meetingNode == null) {
            return null;
        }
        int count = 1;
        ListNode loopNode = meetingNode;
        while (loopNode.next != meetingNode) {
            count++;
            loopNode = loopNode.next;
        }

        ListNode ahead = root;
        ListNode after = root;

        for (int i = 0; i < count; i++) {
            ahead = ahead.next;
        }

        while (ahead != after) {
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
        root.next.next.next.next = new ListNode(5);
        root.next.next.next.next.next = new ListNode(6);
        root.next.next.next.next.next.next = root.next.next;
        ListNode entryNode = entryNodeOfLoop(root);

        System.out.println(entryNode != null ? entryNode.value : "null"); // 1
    }
}