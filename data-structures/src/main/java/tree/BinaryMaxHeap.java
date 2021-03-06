package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liju on 4/16/16.
 *
 *A Binary Heap is a Binary Tree with following properties.
    1) It’s a complete tree (All levels are completely filled except possibly the last level and the last level has all keys as left as possible).
    This property of Binary Heap makes them suitable to be stored in an array.

    2) A Binary Heap is either Min Heap or Max Heap. In a Min Binary Heap, the key at root must be minimum among all keys present in Binary Heap.
    The same property must be recursively true for all nodes in Binary Tree.

 Applications of Heaps:
 1) Heap Sort: Heap Sort uses Binary Heap to sort an array in O(nLogn) time.
 2) Priority Queue: Priority queues can be efficiently implemented using Binary Heap because it supports insert(), delete() and extractmax(), decreaseKey() operations in O(logn) time. Binomoial Heap and Fibonacci Heap are variations of Binary Heap. These variations perform union also efficiently.
 3) Graph Algorithms: The priority queues are especially used in Graph Algorithms like Dijkstra’s Shortest Path and Prim’s Minimum Spanning Tree.
 4) Many problems can be efficiently solved using Heaps. See following for example.
 a) K’th Largest Element in an array.
 b) Sort an almost sorted array/
 c) Merge K Sorted Arrays.

 Why array based representation for Binary Heap?
 Since a Binary Heap is a Complete Binary Tree, it can be easily represented as array and array based representation is space efficient.
 If the parent node is stored at index I, the left child can be calculated by 2 * I + 1 and right child by 2 * I + 2.


 A priority queue is a data structure for maintaining a set S of elements, each with an associated value called a key. A max-priority queue supports the following operations.
 􏰋 INSERT(S, x) inserts the element x into the set S. This operation could be written as S 􏰂 S   {x}.
 􏰋 MAXIMUM(S) returns the element of S with the largest key.
 􏰋 EXTRACT-MAX(S) removes and returns the element of S with the largest key.
 􏰋 INCREASE-KEY(S, x, k) increases the value of element x's key to the new value k,
 which is assumed to be at least as large as x's current key value.
 One application of max-priority queues is to schedule jobs on a shared computer. The max- priority queue keeps track of the jobs to be performed
 and their relative priorities. When a job is finished or interrupted, the highest-priority job is selected from those pending using EXTRACT-MAX.
 A new job can be added to the queue at any time using INSERT.
 *
 */

public class BinaryMaxHeap<T> {
    private final List<Node> heap = new ArrayList();
    class Node implements Comparable{
        int key;
        T data;

        public Node(int key, T data) {
            this.key = key;
            this.data = data;
        }

        @Override public int compareTo(Object o) {
            Node node = (Node)o;
            if (this.key > node.key)
                return 1;
            else if (this.key < node.key)
                return -1;
            else
                return 0;
        }
    }

    /**
     * When MAX-HEAPIFY is called, it is assumed that the binary trees rooted at LEFT(i) and RIGHT(i) are max-heaps,
     * but that A[i] may be smaller than its children, thus violating the max-heap property. The function of MAX-HEAPIFY
     * is to let the value at A[i] "float down" in the max-heap so that the subtree rooted at index i becomes a max-heap.
     * @param index
     */
    public void heapify(int index){

        int leftNodeIndex = leftIndex(index);//left child
        int rightNodeIndex = rightIndex(index);//right child
        int indexOfLargest = index;
        //mark the largest among the parent and its child
        if (leftNodeIndex <= (heap.size() - 1)&& heap.get(leftNodeIndex).compareTo(heap.get(index)) > 0 ){
            indexOfLargest = leftNodeIndex;
        }
        if (rightNodeIndex <=(heap.size() - 1) && heap.get(rightNodeIndex).compareTo(heap.get(indexOfLargest)) > 0){
            indexOfLargest = rightNodeIndex;
        }
        if (indexOfLargest!=index){
            swap(index,indexOfLargest);
            heapify(parentIndex(index));
        }
    }

    private void swap(int index, int indexOfLargest) {
        Node tmp = heap.get(index);
        heap.set(index,heap.get(indexOfLargest));
        heap.set(indexOfLargest, tmp);
    }

    /**
     * Method to add new node to maxHeap
     * @param key
     * @param data
     */
    public void add(int key,T data){

        heap.add(new Node(key,data));
        int parentIndex = (heap.size()-2)/2;
        heapify(parentIndex);
    }

    /**
     * Extracts max value of the max-heap
     * This method get the max value of the maxHeap and removes the max value node and
     * restores the maxHeap property by calling heapify
     * @return
     */
    public Node extractMax(){
        Node max = null;
        if (!heap.isEmpty()){
         max = heap.remove(0);//remaining elements are shifted one index left
            if (!heap.isEmpty())
                heapify(0);//to correct any violation due to removal of max
        }
        return max;
    }

    /**
     * Replaces the key only if the given key is greater than the current
     * @param index
     * @param newKey
     */
    public void increaseKey(int index , int newKey){

        Node node = heap.get(index);
        if (node!=null && newKey > node.key ){
            node.key = newKey;
            heapify(parentIndex(index));
        }

    }

    /**
     * get parent index of given index
     * @param index
     * @return
     */
    private int parentIndex(int index){
        return (index-1)/2;
    }

    /**
     * get left index of the given index
     * @param index
     * @return
     */
    private int leftIndex(int index){
        return  (2*index+1);
    }

    /**
     * get right index of the given index
     * @param index
     * @return
     */
    private int rightIndex(int index){
        return  (2*index+2);
    }

    /**
     * print all the nodes
     */
    public void printNodes(){
        for (Node node : heap) {
            System.out.println("key:"+node.key+" data:"+node.data);
        }

    }

    public static void main(String[] args) {

        BinaryMaxHeap maxHeap = new BinaryMaxHeap();
        maxHeap.add(50,"A");
        maxHeap.add(40,"B");
        maxHeap.add(60,"C");
        maxHeap.add(70,"D");
        maxHeap.add(45,"E");
        maxHeap.add(20,"F");
        maxHeap.add(80,"G");
        maxHeap.add(65,"H");
        maxHeap.add(90,"I");
        maxHeap.add(100,"J");
        maxHeap.add(25,"K");
        maxHeap.printNodes();

        maxHeap.increaseKey(6,110);
        maxHeap.printNodes();

        System.out.println("extracted max key - " + maxHeap.extractMax().key);
        System.out.println("extracted max key - " + maxHeap.extractMax().key);
        System.out.println("extracted max key - " + maxHeap.extractMax().key);
        maxHeap.printNodes();

    }

}
