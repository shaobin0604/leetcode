package leetcode;

import org.jetbrains.annotations.Nullable;

public class _0023_MergeKSortedLists {


    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static class Solution1 {
        public ListNode mergeKLists(ListNode[] lists) {
            // fake node
            ListNode newHead = new ListNode(-1);
            ListNode tail = newHead;
            int count = 0;
            while (true) {
                final int minListNodePosition = findMinListNodePosition(lists);
                if (minListNodePosition == -1) {
                    break;
                }

                tail.next = lists[minListNodePosition];
                tail = tail.next;
                lists[minListNodePosition] = lists[minListNodePosition].next;
            }
            return newHead.next;
        }


        private int findMinListNodePosition(ListNode[] lists) {
            int minPosition = -1;
            int minValue = Integer.MAX_VALUE;
            for (int i = 0; i < lists.length; i++) {
                final ListNode node = lists[i];
                if (node != null && node.val < minValue) {
                    minValue = node.val;
                    minPosition = i;
                }
            }
            return minPosition;
        }
    }

    // https://leetcode-cn.com/problems/merge-k-sorted-lists/solution/luo-ji-fei-chang-jian-dan-de-javati-jie-shi-jian-j/
    public static class Solution2 {
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }

            int len = lists.length;

            while (len > 1) {
                for (int i = 0; i < len / 2; i++) {
                    lists[i] = mergeTwoList(lists[i], lists[len - 1 - i]);
                }
                len = (len + 1) / 2;
            }

            return lists[0];
        }

        ListNode mergeTwoList(ListNode l1, ListNode l2) {
            // fake node
            ListNode newHead = new ListNode(-1);
            ListNode tail = newHead;

            while (l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    tail.next = l1;
                    l1 = l1.next;
                } else {
                    tail.next = l2;
                    l2 = l2.next;
                }

                tail = tail.next;
            }

            if (l1 != null) {
                tail.next = l1;
            } else if (l2 != null) {
                tail.next = l2;
            }

            return newHead.next;
        }
    }
}
