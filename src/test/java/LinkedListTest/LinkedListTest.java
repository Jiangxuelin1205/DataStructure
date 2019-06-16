package LinkedListTest;

import LinkedList.DeleteDuplicate;
import LinkedList.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class LinkedListTest {
    @Test
    public void null_head_test() {
        DeleteDuplicate d = new DeleteDuplicate();
        ListNode head = null;
        Assert.assertNull(d.removeElements(head, 0));
    }

    @Test
    public void null_result_test() {
        DeleteDuplicate d = new DeleteDuplicate();
        ListNode head = new ListNode(3);
        head.next = new ListNode(3);
        Assert.assertNull(d.removeElements(head, 3));
    }

    @Test
    public void delete_head_and_tail_test() {
        DeleteDuplicate d = new DeleteDuplicate();
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        head.next = node1;
        node1.next = node2;

        Assert.assertEquals(d.removeElements(head, 3).val, 2);
    }

    @Test
    public void delete_medium_test() {
        DeleteDuplicate d = new DeleteDuplicate();
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        head.next = node1;
        node1.next = node2;

        Assert.assertEquals(d.removeElements(head, 3).val, 2);
    }

    @Test
    public void null_head_test_recursive() {
        DeleteDuplicate d = new DeleteDuplicate();
        ListNode head = null;
        Assert.assertNull(d.removeElementsRecursive(head, 0));
    }

    @Test
    public void null_result_test_recursive() {
        DeleteDuplicate d = new DeleteDuplicate();
        ListNode head = new ListNode(3);
        head.next = new ListNode(3);
        Assert.assertNull(d.removeElementsRecursive(head, 3));
    }

    @Test
    public void delete_head_and_tail_test_recursive() {
        DeleteDuplicate d = new DeleteDuplicate();
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        head.next = node1;
        node1.next = node2;

        Assert.assertEquals(d.removeElementsRecursive(head, 3).val, 2);
    }

    @Test
    public void delete_medium_test_recursive() {
        DeleteDuplicate d = new DeleteDuplicate();
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        head.next = node1;
        node1.next = node2;

        Assert.assertEquals(d.removeElementsRecursive(head, 3).val, 2);
    }

    @Test
    public void delete_tail_test_recursive() {
        DeleteDuplicate d = new DeleteDuplicate();
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(6);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Assert.assertEquals(d.removeElementsRecursive(head, 6).val, 1);
    }

}
