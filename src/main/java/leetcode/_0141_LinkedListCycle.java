package leetcode;

import java.util.HashSet;

public class _0141_LinkedListCycle {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    static class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null) {
                return false;
            }
            ListNode slow = head;
            ListNode fast = head.next;
            while (slow != null && fast != null && fast.next != null) {
                if (slow == fast) {
                    return true;
                }
                slow = slow.next;
                fast = fast.next.next;
            }
            return false;
        }
    }

    static class Solution2 {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }

            HashSet<ListNode> visited = new HashSet<>();
            while (head != null) {
                if (visited.contains(head)) {
                    return true;
                }

                visited.add(head);
                head = head.next;
            }

            return false;
        }
    }
}
