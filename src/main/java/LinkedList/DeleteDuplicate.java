package LinkedList;

public class DeleteDuplicate {

    //使用非递归和递归方式对链表进行求和
    public ListNode removeElements(ListNode head, int val) {
        ListNode preHead = new ListNode(-1);
        preHead.next = head;

        ListNode preP = preHead;
        ListNode p = head;

        while (p != null) {
            if (p.val == val) {
                preP.next = p.next;
                p.next = null;
                p = preP.next;
            } else {
                p = p.next;
                preP = preP.next;
            }
        }
        return preHead.next;
    }

    public ListNode removeElementsRecursive(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode res = removeElementsRecursive(head.next, val);
        if (head.val == val) {
            return res;
        } else {
            head.next = res;
            return head;
        }
    }

}
