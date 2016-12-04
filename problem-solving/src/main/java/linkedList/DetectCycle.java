package linkedList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * Created by Liju on 12/3/2016.
 * Given a singly linked list, determine if it has a cycle in it.
 * <p>
 * Follow up:
 * Can you solve it without using extra space?
 * <p>
 * https://leetcode.com/problems/linked-list-cycle/
 */
public class DetectCycle {


    /**
     * Time-Complexity  - O(n)
     * Space-Complexity  -O(n)
     * <p>
     * Hash table solution
     */
    public boolean hasCycle(ListNode head) {

        HashSet<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) return true;
            set.add(head);
            head = head.next;
        }
        return false;
    }

    /**
     * Time-Complexity  - O(n)
     * Space-Complexity  -O(1)
     * <p>
     * Two pointer solution
     */
    public boolean hasCyclePreffered(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (slow == null || fast == null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
