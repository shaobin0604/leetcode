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

    // 插头法：不使用 dummy 节点
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

    // 插头法：使用 dummy 节点
    public ListNode reverseList2(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = next;
        }
        return dummy.next;
    }

    public ListNode reverseList3(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // 递归
    public ListNode reverseList4(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p = reverseList4(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }
}
