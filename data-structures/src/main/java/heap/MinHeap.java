package heap;

/**
 * Created by Liju on 11/27/2016.
 */
public class MinHeap {
    Integer[] heap;
    Integer maxSize;
    Integer position;

    MinHeap(int maxSize) {
        heap = new Integer[maxSize];
        position = -1;
    }

    public void insert(int i) {
        heap[++position] = i;
        bubbleUp(position);
    }

    public int getMin() {
        return heap[0];
    }

    public int extractMin() {
        int min = heap[0];
        heap[0] = heap[position];
        heap[position] = null;
        position--;
        sinkDown(0);
        return min;
    }

    private void sinkDown(int index) {
        //check the min of two childs if present
        final int leftChildIndex = getLeftChildIndexOf(index);
        final int rightChildIndex = getRightChildIndexOf(index);
        if (leftChildIndex > position)
            return;

        if (heap[leftChildIndex] < heap[rightChildIndex] && heap[leftChildIndex] < heap[index]) {
            swap(leftChildIndex, index);
            sinkDown(leftChildIndex);
        } else if (heap[leftChildIndex] > heap[rightChildIndex] && heap[rightChildIndex] < heap[index]) {
            swap(rightChildIndex, index);
            sinkDown(rightChildIndex);
        }
    }

    private void bubbleUp(int index) {
        int parentIndex = getParentIndexOf(index);
        if (heap[parentIndex] < heap[index]) {
            swap(parentIndex, index);
            bubbleUp(parentIndex);
        }
    }

    private void swap(int indexA, int indexB) {
        int temp = heap[indexA];
        heap[indexA] = heap[indexB];
        heap[indexB] = temp;
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
