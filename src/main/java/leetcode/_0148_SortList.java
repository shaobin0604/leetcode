package leetcode;

public class _0148_SortList {

    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public ListNode sortList(ListNode head) {
            // 1. cut list
            if (head == null || head.next == null) {
                return head;
            }
            ListNode slow = head;
            ListNode fast = head.next;

            // 奇数链表，slow 位于中间节点
            // 偶数链表，slow 位于左边节点
            while (slow.next != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }
            // 后半部分头节点
            ListNode tmp = slow.next;
            // 前半部分尾节点断开与后半部分的连接
            slow.next = null;

            // 2. sort sublist
            ListNode l = sortList(head);
            ListNode r = sortList(tmp);

            // 3. merge two sorted list
            // fake node
            ListNode newHead = new ListNode(0);
            ListNode h = newHead;
            while (l != null && r != null) {
                if (l.val < r.val) {
                    h.next = l;
                    l = l.next;
                } else {
                    h.next = r;
                    r = r.next;
                }
                h = h.next;
            }

            h.next = (l != null ? l : r);

            return newHead.next;
        }
    }
}
