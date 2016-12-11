package linkedList;

/**
 * Created by Liju on 12/9/2016.
 Get the nth element from the tail of the linked list
 */
public class NthElementFromTail {


    int GetNode(Node head, int n) {
        Node current = head;
        Node behind = head;
        int i = 0;
        if (current.next == null) return current.data;
        while (current.next != null) {
            current = current.next;
            if (i >= n) {
                behind = behind.next;

            }
            i++;
        }
        return behind.data;
    }

    class Node {
        int data;
        Node next;
    }
}
