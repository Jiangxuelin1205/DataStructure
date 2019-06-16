package LinkedList;

public class MergeSort {

    public ListNode divideAndMerge(ListNode head) {
        //使用快慢指针
        if (head == null||head.next==null) {
            return head;
        }

        ListNode slow = getMedium(head);
        ListNode rightHead=slow.next;
        slow.next = null;

        ListNode left=divideAndMerge(head);
        ListNode right=divideAndMerge(rightHead);

        return merge(left, right);
    }

    private ListNode getMedium(ListNode head) {
        ListNode slow, fast;
        slow = fast = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
        ListNode head = new ListNode(-1);
        ListNode h = head;
        ListNode p1 = head1;
        ListNode p2 = head2;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                h.next = p1;
                p1 = p1.next;
            } else {
                h.next = p2;
                p2 = p2.next;
            }
            h = h.next;
        }

        if (p1 != null) {
            h.next = p1;
        }
        if (p2 != null) {
            h.next = p2;
        }
        return head.next;
    }
}
