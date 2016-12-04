package linkedList;

/**
 * Created by Liju on 12/3/2016.
 * <p>
 * Reverse a singly linked list
 * <p>
 * 3 -> 5 -> 6-> 2  :  2 -> 6 -> 5 -> 3
 */
public class ReverseList {

    /**
     * Time-complexity : O(n)
     * Space -complexity  : O(1)
     */
    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead;
            newHead = head;
            head = next;
        }
        return newHead;
    }

    /**
     * Time-complexity : O(n)
     * Space -complexity  : O(n)
     * The extra space comes from implicit stack space due to recursion. The recursion could go up to nn levels deep.
     */
    public ListNode recursiveReverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
