package aimoffer;

public class _18_1_DeleteNodeInList<T> {
    static class ListNode<T> {
        T val;
        ListNode<T> next;
    }

    public ListNode<T> deleteNode(ListNode<T> head, ListNode<T> delete) {
        if (head == null || delete == null) {
            return null;
        }

        if (delete.next != null) {
            ListNode<T> next = delete.next;
            delete.val = next.val;
            delete.next = next.next;
        } else {
            if (head == delete) {
                return null;
            } else {
                ListNode<T> cur = head;
                while (cur.next != delete) {
                    cur = cur.next;
                }
                cur.next = null;
            }
        }
        return head;
    }
}
