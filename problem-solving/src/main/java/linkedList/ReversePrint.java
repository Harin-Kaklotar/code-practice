package linkedList;

/**
 * Created by Liju on 12/9/2016.
 You are given the pointer to the head node of a linked list and you need to print all its elements in reverse order from tail to head, one element per line.
 The head pointer may be null meaning that the list is empty - in that case, do not print anything!
 */
public class ReversePrint {

    void ReversePrint(Node head) {
        // This is a "method-only" submission.
        // You only need to complete this method.
        if (head==null) return;
        ReversePrint(head.next);
        System.out.println(head.data);
    }
    class Node {
        int data;
        Node next;
    }
}
