public class Clone {
    private static class ComplexListNode {
        ComplexListNode next;
        ComplexListNode sibling;
        int value;

        public ComplexListNode(int value) {
            this.value = value;
        }
    }

    public static ComplexListNode clone(ComplexListNode root) {
        cloneNodes(root);
        siblingNodes(root);
        return reconnect(root);
    }

    private static void cloneNodes(ComplexListNode root) {
        ComplexListNode cur = root;
        while (cur != null) {
            ComplexListNode cloneNode = new ComplexListNode(cur.value);
            cloneNode.next = cur.next;
            cur.next = cloneNode;
            cur = cloneNode.next;
        }
    }

    private static void siblingNodes(ComplexListNode root) {
        ComplexListNode cur = root;
        while (cur != null) {
            if (cur.sibling != null) {
                cur.next.sibling = cur.sibling.next;
            }
            cur = cur.next.next;
        }
    }

    private static ComplexListNode reconnect(ComplexListNode root) {
        ComplexListNode cur = root;
        ComplexListNode cloneRoot = null;
        ComplexListNode curClone = null;
        if (cur != null) {
            cloneRoot = cur.next;
        }
        while (cur != null) {
            curClone = cur.next;
            cur = cur.next.next;
            curClone = curClone.next;
        }
        return cloneRoot;
    }
}