package leetcode;

import aimoffer._24_ReverseList;

public class _0206_ReverseLinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;

        ListNode next = null;

        while (head != null) {
            next = head.next;

            head.next = newHead;
            newHead = head;

            head = next;
        }
        return newHead;
    }

    // 递归
    public ListNode reverseList3(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode next = head.next;
        head.next = null;
        ListNode newHead = reverseList3(next);
        next.next = head;
        return newHead;
    }
}
