package linkedList;

/**
 *
 *  You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *  Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *  Output: 7 -> 0 -> 8
 *  https://leetcode.com/articles/add-two-numbers/
 */
public class LinkedListSum {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(2);
        //ListNode listNode1 = new ListNode(3);
        //listNode.next = listNode1;

        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(6);
        listNode2.next = listNode3;
        new Solution().addTwoNumbers(listNode,listNode2);
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode head = null,tail=null;
            int carry =0;
            ListNode l1tmp =  l1;
            ListNode l2tmp =  l2;
            while (l1tmp!=null || l2tmp !=null){
                int sum = (l1tmp!=null ? l1tmp.val:0)+(l2tmp!=null ? l2tmp.val:0)+carry;
                int remainder;
                if (sum>9){
                    remainder = sum%10;
                }else {
                    remainder = sum;
                }
                carry = sum/10;
                if (head==null){
                    head=tail=new ListNode(remainder);
                }else {
                    tail.next = new ListNode(remainder);
                    tail = tail.next;
                }
                l1tmp = l1tmp!=null ? l1tmp.next : null;
                l2tmp = l2tmp!=null ? l2tmp.next : null;

            }
            if (carry>0){
                tail.next = new ListNode(carry);
            }
            return head;
        }
    }
}


