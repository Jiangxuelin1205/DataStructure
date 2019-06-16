package LinkedListTest;

import LinkedList.ListNode;
import LinkedList.MergeSort;
import org.junit.Test;

public class MergeSortTest {

    @Test
    public void merge_sorted_list_test() {
        MergeSort m = new MergeSort();
        ListNode head1 = new ListNode(5);
        ListNode n1 = new ListNode(6);
        ListNode n2 = new ListNode(10);
        head1.next = n1;
        n1.next = n2;

        ListNode head2 = new ListNode(5);
        ListNode n3 = new ListNode(5);
        ListNode n4 = new ListNode(11);
        head2.next = n3;
        n3.next = n4;

        ListNode result = m.merge(head1, head2);
        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
    }

    @Test
    public void divide_and_merge() {
        ListNode head = new ListNode(3);
        ListNode n1 = new ListNode(5);
        ListNode n2 = new ListNode(8);
        ListNode n3 = new ListNode(6);
        ListNode n4 = new ListNode(2);

        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        MergeSort m = new MergeSort();

        ListNode result = m.divideAndMerge(head);
        while (result != null) {
            System.out.print(result.val + "->");
            result = result.next;
        }
        System.out.println();
    }
}
