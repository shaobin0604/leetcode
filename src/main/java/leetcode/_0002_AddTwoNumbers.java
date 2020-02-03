package leetcode;

public class _0002_AddTwoNumbers {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode dummy = new ListNode(-1);
            ListNode cur = dummy;
            int carry = 0;
            int value = 0;
            while (l1 != null || l2 != null) {
                int val1 = l1 != null ? l1.val : 0;
                int val2 = l2 != null ? l2.val : 0;

                value = carry + val1 + val2;
                carry = value / 10;
                value = value % 10;

                cur.next = new ListNode(value);
                cur = cur.next;

                if (l1 != null) {
                    l1 = l1.next;
                }

                if (l2 != null) {
                    l2 = l2.next;
                }
            }

            if (carry > 0) {
                cur.next = new ListNode(carry);
            }

            return dummy.next;
        }
    }
}
