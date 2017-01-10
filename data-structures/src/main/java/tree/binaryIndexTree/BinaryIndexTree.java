package tree.binaryIndexTree;

/**
 * Created by liju on 1/9/17.
 *
 https://www.hackerearth.com/practice/notes/binary-indexed-tree-or-fenwick-tree/

 Operations -
 1. create BIT for given input
 2. Update index with the given value
 */

// Also called Fenwick-Tree
public class BinaryIndexTree {

    public int[] createBinaryIndexTree(int[] input) {
        // to make algo easy lets make the bit array 1 indexed (we won't consider bit[0])
        // calculation with 1 indexed is straight forward
        int[] bit = new int[input.length + 1];

        for (int i = 0; i < input.length; i++) {
            add(bit, i + 1, input[i]);
        }
        return bit;
    }

    public void add(int[] bit, int index, int value) {
        while (index < bit.length) {
            bit[index] += value;
            index = getNextIndex(index);
        }
    }

    private int getNextIndex(int index) {
        // isolate the last set bit ( binary notation) and add it to the current index to get the next index
        return index + (index & -index);

    }

    public int getSum(int[] bit, int index) {
        int sum = 0;
        index = index + 1; // since bit is 1 based array
        while (index >= 1) {
            sum += bit[index];
            index = getParentIndex(index);
        }
        return sum;
    }

    private int getParentIndex(int index) {
        // isolate the last set bit ( binary notation) and substract it from the current index to get the parent index
        return index - (index & -index);
    }

    public static void main(String[] args) {
        int input[] = { 1, 2, 3, 4, 5, 6, 7 };
        BinaryIndexTree bit = new BinaryIndexTree();
        int[] binaryIndexTree = bit.createBinaryIndexTree(input);
        assert 1 == bit.getSum(binaryIndexTree, 0);
        assert 3 == bit.getSum(binaryIndexTree, 1);
        assert 6 == bit.getSum(binaryIndexTree, 2);
        assert 10 == bit.getSum(binaryIndexTree, 3);
        assert 15 == bit.getSum(binaryIndexTree, 4);
        assert 21 == bit.getSum(binaryIndexTree, 5);
        assert 28 == bit.getSum(binaryIndexTree, 6);
    }
}
