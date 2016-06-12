package linkedList;

/**
 * Created by liju on 5/4/16.
 */
public class LinkedList<T> implements  List<T> {

    Node<T> root = null;

    @Override public void add(T t) {
        if (root==null) {
            root = new Node<T>();
            root.data = t;
            return;
        }
        Node<T> tmp = root;
        while (tmp.next !=null){
            tmp = tmp.next;
        }

        tmp.next = new Node<T>();
        tmp.data = t;
    }

    @Override public void remove(T t) {
        Node<T> tmp = root;
        if (tmp == null)
            return;
        //only 1 element
        if (tmp.next == null){
            if (tmp.data.equals(t)){
                root = null;
            }
            return;
        }
        //todo

    }

    @Override public int size() {
        if (root==null)
            return 0;
        Node<T> tmp = root;
        int count = 0;
        while (tmp!=null){
            tmp = tmp.next;
            count++;
        }
        return count;
    }

    @Override public boolean isEmpty() {
        if (root == null)
            return true;
        else
            return false;
    }
}

class Node<T> {
    T data;
    Node<T> next;
}
