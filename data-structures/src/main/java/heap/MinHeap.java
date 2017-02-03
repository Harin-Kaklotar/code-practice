package heap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liju on 2/2/17.
 *
 * Data structure to support following operations
 * extracMin - O(logn)
 * addToHeap - O(logn)
 * containsKey - O(1)
 * decreaseKey - O(logn)
 * getKeyWeight - O(1)
 *
 * It is a combination of binary heap and hash map
 *
 */
public class MinHeap<T> {
    class Node<T> {
        T key;
        int wgt;

        public Node(T key, int wgt) {
            this.key = key;
            this.wgt = wgt;
        }

        @Override
        public String toString() {
            return "Node{" + "key=" + key + ", wgt=" + wgt + '}';
        }
    }

    private final List<Node<T>> allNodes = new ArrayList<>();
    // map for key to node position
    private final Map<T, Integer> nodePosition = new HashMap<T, Integer>();

    // Adds new node (key,wgt) to the heap
    public void addToHeap(T key, int wgt) {
        Node<T> node = new Node<>(key, wgt);
        allNodes.add(node);
        int currIndex = allNodes.size() - 1;
        nodePosition.put(key, currIndex);
        bubbleUp(currIndex);
    }

    // Extracts min wgt node from the heap , removes it from the heap
    public Node<T> extractMin() {
        final Node<T> min = allNodes.get(0);
        allNodes.set(0, allNodes.get(allNodes.size() - 1));
        allNodes.remove(allNodes.size() - 1);
        sinkDown(0);
        return min;
    }

    // Get the node with min wgt without removing it from the heap
    public Node<T> getMin() {
        return allNodes.get(0);
    }

    // Decreases the the wgt of the key to new val. It assumes new wgt should be less that existing one
    public void decreaseKeyWgt(T key, int newWgt) {
        final Integer pos = nodePosition.get(key);
        if (newWgt < allNodes.get(pos).wgt) {
            allNodes.get(pos).wgt = newWgt;
            bubbleUp(pos);
        } else {
            throw new IllegalArgumentException("new wgt should be lower that existing");
        }

    }

    // Get weight of a key
    public int getWeight(T key) {
        final Integer pos = nodePosition.get(key);
        return allNodes.get(pos).wgt;
    }

    // Check if heap contains given key
    public boolean containsKey(T key) {
        return nodePosition.containsKey(key);
    }

    // Size of the heap
    public int getHeapSize() {
        return allNodes.size();
    }

    public void printHeap() {
        for (Node node : allNodes) {
            System.out.println(node);
        }
    }

    public void printPositionMap() {
        for (Map.Entry<T, Integer> tIntegerEntry : nodePosition.entrySet()) {
            System.out.println("key : " + tIntegerEntry.getKey() + " , pos : " + tIntegerEntry.getValue());
        }
    }

    private void sinkDown(int currIndex) {
        // check the min of two childs if present
        final int leftChildIndex = getLeftChildIndexOf(currIndex);
        final int rightChildIndex = getRightChildIndexOf(currIndex);
        if (leftChildIndex > allNodes.size() - 1)
            return;

        final Node<T> current = allNodes.get(currIndex);
        final Node<T> leftChild = allNodes.get(leftChildIndex);
        final Node<T> rightChild = allNodes.get(rightChildIndex);

        if (leftChild.wgt < rightChild.wgt && leftChild.wgt < current.wgt) {
            swap(leftChildIndex, currIndex);
            updatePositionMap(leftChild, current, leftChildIndex, currIndex);
            sinkDown(leftChildIndex);
        } else if (leftChild.wgt > rightChild.wgt && rightChild.wgt < current.wgt) {
            swap(rightChildIndex, currIndex);
            updatePositionMap(rightChild, current, rightChildIndex, currIndex);
            sinkDown(rightChildIndex);
        }
    }

    private void bubbleUp(int index) {
        final Node<T> currentNode = allNodes.get(index);
        int parentIndex = getParentIndexOf(index);
        final Node<T> parentNode = allNodes.get(parentIndex);
        if (currentNode.wgt < parentNode.wgt) {
            swap(parentIndex, index);
            updatePositionMap(currentNode, parentNode, index, parentIndex);
            bubbleUp(parentIndex);
        }
    }

    private void updatePositionMap(Node<T> currentNode, Node<T> otherNode, int currIndex, int otherIndex) {
        nodePosition.put(currentNode.key, otherIndex);
        nodePosition.put(otherNode.key, currIndex);
    }

    private void swap(int indexA, int indexB) {
        Node tmp = allNodes.get(indexA);
        allNodes.set(indexA, allNodes.get(indexB));
        allNodes.set(indexB, tmp);
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

    public static void main(String[] args) {
        MinHeap<String> heap = new MinHeap();
        heap.addToHeap("IND", 10);
        heap.addToHeap("AUS", 5);
        heap.addToHeap("ENG", 20);
        heap.addToHeap("USA", 13);
        System.out.println("Size=" + heap.getHeapSize());
        System.out.println("Min=" + heap.getMin());
        heap.addToHeap("SRI", 3);
        heap.addToHeap("KOR", 14);
        System.out.println("Min=" + heap.getMin());
        heap.addToHeap("SA", 9);
        heap.decreaseKeyWgt("ENG", 10);
        System.out.println("Size=" + heap.getHeapSize());
        System.out.println("Min=" + heap.getMin());
        heap.decreaseKeyWgt("USA", 2);
        System.out.println("Min=" + heap.getMin());
        heap.decreaseKeyWgt("IND", 1);
        System.out.println("Min=" + heap.getMin());
        System.out.println("Size=" + heap.getHeapSize());

        System.out.println("extracted node= " + heap.extractMin());
        System.out.println("Min=" + heap.getMin());
        System.out.println("Size=" + heap.getHeapSize());
        heap.printHeap();
        heap.printPositionMap();
    }
}
