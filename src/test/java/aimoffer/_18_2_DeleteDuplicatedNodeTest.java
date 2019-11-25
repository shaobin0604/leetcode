package aimoffer;

import org.junit.Assert;
import org.junit.Test;

public class _18_2_DeleteDuplicatedNodeTest {
    @Test
    public void test_case_1() {
        final _18_2_DeleteDuplicatedNode.ListNode head = _18_2_DeleteDuplicatedNode.ListNode.asList(1, 2, 3, 3, 4, 4, 5);

        final _18_2_DeleteDuplicatedNode.ListNode newHead = new _18_2_DeleteDuplicatedNode().deleteDuplication(head);

        Assert.assertArrayEquals(new Integer[] {1, 2, 5}, _18_2_DeleteDuplicatedNode.ListNode.toIntegerArray(newHead));
    }

    @Test
    public void test_case_2() {
        final _18_2_DeleteDuplicatedNode.ListNode head = _18_2_DeleteDuplicatedNode.ListNode.asList(1, 1, 1, 1, 1, 1);

        final _18_2_DeleteDuplicatedNode.ListNode newHead = new _18_2_DeleteDuplicatedNode().deleteDuplication(head);

        Assert.assertArrayEquals(new Integer[0], _18_2_DeleteDuplicatedNode.ListNode.toIntegerArray(newHead));
    }

    @Test
    public void test_case_3() {
        final _18_2_DeleteDuplicatedNode.ListNode head = _18_2_DeleteDuplicatedNode.ListNode.asList(1, 1, 2, 2, 3, 3);

        final _18_2_DeleteDuplicatedNode.ListNode newHead = new _18_2_DeleteDuplicatedNode().deleteDuplication(head);

        Assert.assertArrayEquals(new Integer[0], _18_2_DeleteDuplicatedNode.ListNode.toIntegerArray(newHead));
    }

    @Test
    public void test_case_4() {
        final _18_2_DeleteDuplicatedNode.ListNode head = _18_2_DeleteDuplicatedNode.ListNode.asList(1, 2, 3);

        final _18_2_DeleteDuplicatedNode.ListNode newHead = new _18_2_DeleteDuplicatedNode().deleteDuplication(head);

        Assert.assertArrayEquals(new Integer[]{1, 2, 3}, _18_2_DeleteDuplicatedNode.ListNode.toIntegerArray(newHead));
    }

    @Test
    public void test_case_5() {
        final _18_2_DeleteDuplicatedNode.ListNode head = _18_2_DeleteDuplicatedNode.ListNode.asList(1, 2, 3, 4, 4);

        final _18_2_DeleteDuplicatedNode.ListNode newHead = new _18_2_DeleteDuplicatedNode().deleteDuplication(head);

        Assert.assertArrayEquals(new Integer[] {1, 2, 3}, _18_2_DeleteDuplicatedNode.ListNode.toIntegerArray(newHead));
    }
}
