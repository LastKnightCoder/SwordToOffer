public class Merge {
    private static class ListNode {
        public ListNode next;
        public int value;
        public ListNode(int value) {
            this.next = null;
            this.value = value;
        }
    }

    // public static ListNode merge(ListNode root1, ListNode root2) {
        // if (root1 == null) {
            // return root2;
        // }
        // if (root2 == null) {
            // return root1;
        // }
        // ListNode mergeRoot = null;
        // if (root1.value <= root2.value) {
            // mergeRoot = root1;
            // mergeRoot.next = merge(root1.next, root2);
        // } else {
            // mergeRoot = root2;
            // mergeRoot.next = merge(root1, root2.next);
        // }

        // return mergeRoot;
    // }
    public static ListNode merge(ListNode root1, ListNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        ListNode root = null;
        ListNode p1 = root1;
        ListNode p2 = root2;
        if (p1.value <= p2.value) {
            root = p1;
            p1 = p1.next;
        } else {
            root = p2;
            p2 = p2.next;
        }
        ListNode cur = root;
        while (p1 != null && p1 != null) {
            if (p1.value <= p2.value) {
                cur.next = p1;
                cur = cur.next;
                p1 = p1.next;
            } else {
                cur.next = p2;
                cur = cur.next;
                p2 = p2.next;
            }
        }

        if (p1 == null) {
            cur.next = p2;
        }
        if (p2 == null) {
            cur.next = p1;
        }

        return root;
    }



    public static ListNode generateListFromArray(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }
        ListNode root = new ListNode(array[0]);
        ListNode cur = root;
        for (int i = 1; i < array.length; i++) {
            cur.next = new ListNode(array[i]);
            cur = cur.next;
        }

        return  root;
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
        ListNode root1 = generateListFromArray(new int[]{1, 2, 4, 7, 8});
        ListNode root2 = generateListFromArray(new int[]{3, 5, 6, 9, 10});
        ListNode root = merge(root1, root2);
        printList(root);
    }
}