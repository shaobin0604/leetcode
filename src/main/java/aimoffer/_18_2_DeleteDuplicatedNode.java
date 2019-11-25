package aimoffer;

import java.util.LinkedList;
import java.util.List;

public class _18_2_DeleteDuplicatedNode {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        public static ListNode asList(int... vals) {
            ListNode head = null;
            for (int i = vals.length - 1; i >= 0; i--) {
                ListNode node = new ListNode(vals[i]);
                node.next = head;
                head = node;
            }
            return head;
        }

        public static Integer[] toIntegerArray(ListNode head) {
            if (head == null) {
                return new Integer[0];
            }
            List<Integer> list = new LinkedList<>();
            while (head != null) {
                list.add(head.val);
                head = head.next;
            }
            return list.toArray(new Integer[0]);
        }
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }

        ListNode next = pHead.next;
        if (pHead.val == next.val) {
            while (next != null && next.val == pHead.val) {
                next = next.next;
            }
            return deleteDuplication(next);
        } else {
            pHead.next = deleteDuplication(next);
            return pHead;
        }
    }
}
