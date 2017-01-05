package heap;

import java.util.Scanner;

/**
 * Created by liju on 12/30/16.

 https://www.hackerrank.com/challenges/qheap1

 */
public class MinHeap {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int q = sc.nextInt();
        Heap heap = new Heap();
        for (int i = 0; i < q; i++) {
            int queryType = sc.nextInt();
            switch (queryType) {
                case 1:
                    heap.addItem(sc.nextInt());
                    break;
                case 2:
                    heap.delete(sc.nextInt());
                    break;
                case 3:
                    System.out.println(heap.getMin());
                    break;
                default:
                    throw new IllegalArgumentException("invalid query");
            }
        }
    }

    static class Heap {
        int[] heap = new int[100000];
        int currMaxIndex = -1;

        public int getMin() {
            return heap[0];
        }

        public void deleteMin() {
            swap(0, currMaxIndex);
            currMaxIndex--;
            bubbleDown(0);
        }

        // delete item is not a normal heap operation
        public void delete(int item) {
            int indexOfItem = -1;
            for (int i = 0; i <= currMaxIndex; i++) {
                if (item == heap[i]) {
                    indexOfItem = i;
                    break;
                }
            }
            if (indexOfItem != -1) {
                swap(indexOfItem, currMaxIndex);
                currMaxIndex--;
                bubbleDown(indexOfItem);

            }
        }

        private void bubbleDown(int index) {
            int leftChildIndex = leftChildIndexOf(index);
            int rightChildIndex = rightChildIndexOf(index);
            if (leftChildIndex <= currMaxIndex && heap[index] > heap[leftChildIndex]) {
                swap(index, leftChildIndex);
                bubbleDown(leftChildIndex);
            }
            if (rightChildIndex <= currMaxIndex && heap[index] > heap[rightChildIndex]) {
                swap(index, rightChildIndex);
                bubbleDown(rightChildIndex);
            }
        }

        private int rightChildIndexOf(int index) {
            return 2 * index + 2;
        }

        private int leftChildIndexOf(int index) {
            return 2 * index + 1;
        }

        public void addItem(int item) {
            heap[++currMaxIndex] = item;
            bubbleUp(currMaxIndex);
        }

        private void bubbleUp(int index) {
            int parentIndex = parent(index);
            if (parentIndex >= 0 && heap[index] < heap[parentIndex]) {
                swap(parentIndex, index);
                bubbleUp(parentIndex);
            }
        }

        private void swap(int index1, int index2) {
            int tmp = heap[index1];
            heap[index1] = heap[index2];
            heap[index2] = tmp;
        }

        private int parent(int index) {
            return (index + 1) / 2 - 1;
        }

    }
}
