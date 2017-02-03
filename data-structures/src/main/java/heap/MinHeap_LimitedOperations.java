package heap;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by liju on 2/2/17.
 *
 * Min Heap supporting following ops -
 * extracMin - O(logn)
 * addToHeap - O(logn)
 */
public class MinHeap_LimitedOperations<T> {
    List<Node<T>> allNodes = new ArrayList<>();

    class Node<T>{
        T key;
        int wgt;

        public Node(T key, int wgt) {
            this.key = key;
            this.wgt = wgt;
        }
    }

    public void addToHeap(T key,int wgt){
        Node node = new Node<T>(key, wgt);
        allNodes.add(node);
        int current = allNodes.size()-1;
        bubbleUp(current);
    }

    public Node<T> extractMin(){
        final Node<T> min = allNodes.get(0);
        allNodes.add(0,allNodes.get(allNodes.size()-1));
        allNodes.remove(allNodes.size()-1);
        sinkDown(0);
        return min;
    }


    private void sinkDown(int index) {
        //check the min of two childs if present
        final int leftChildIndex = getLeftChildIndexOf(index);
        final int rightChildIndex = getRightChildIndexOf(index);
        if (leftChildIndex > allNodes.size()-1)
            return;

        if (allNodes.get(leftChildIndex).wgt < allNodes.get(rightChildIndex).wgt && allNodes.get(leftChildIndex).wgt < allNodes.get(index).wgt) {
            swap(leftChildIndex, index);
            sinkDown(leftChildIndex);
        } else if (allNodes.get(leftChildIndex).wgt > allNodes.get(rightChildIndex).wgt && allNodes.get(rightChildIndex).wgt < allNodes.get(index).wgt) {
            swap(rightChildIndex, index);
            sinkDown(rightChildIndex);
        }
    }

    private void bubbleUp(int index) {
        int parentIndex = getParentIndexOf(index);
        if (allNodes.get(index).wgt < allNodes.get(parentIndex).wgt) {
            swap(parentIndex, index);
            bubbleUp(parentIndex);
        }
    }

    private void swap(int indexA, int indexB) {
        Node tmp = allNodes.get(indexA);
        allNodes.add(indexA,allNodes.get(indexB));
        allNodes.add(indexB,tmp);
    }
    private int getLeftChildIndexOf(int index) {
        return 2 * index;
    }
    private int getRightChildIndexOf(int index) {
        return 2 * index + 1;
    }
    private int getParentIndexOf(int index) {
        return index / 2;
    }
}
