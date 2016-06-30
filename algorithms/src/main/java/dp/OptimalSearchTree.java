package dp;

/**
 * Created by liju on 6/29/16.
 *
 * Given a sorted array keys[0.. n-1] of search keys and an array freq[0.. n-1] of frequency counts, where freq[i] is the number of searches to keys[i].
 * Construct a binary search tree of all keys such that the total cost of all the searches is as small as possible.
 *
 *Eg. Input:  keys[] = {10, 12, 20}, freq[] = {34, 8, 50}
     There can be following possible BSTs
     10                12                 20         10             20
     \             /    \              /             \            /
     12          10     20           12               20         10
     \                            /                  /             \
     20                        10                 12                12
     I               II             III             IV             V
     Among all possible BSTs, cost of the fifth BST is minimum.
     Cost of the fifth BST is 1*50 + 2*34 + 3*8 = 142

 *
 * Ref - http://www.geeksforgeeks.org/dynamic-programming-set-24-optimal-binary-search-tree/
 */
public class OptimalSearchTree {

    // naive recursive solution

    public int minCostRecur(int[] freq, int startIndex, int endIndex) {
        // no more elements
        if (startIndex > endIndex) {
            return 0;
        }
        // one element
        if (startIndex == endIndex) {
            return freq[startIndex];
        }
        // get sum of all the nodes and then get min sum of left and right tree making each node as root
        int sum = sum(freq, startIndex, endIndex);

        int min = Integer.MAX_VALUE;

        for (int i = startIndex; i <= endIndex; i++) {
            // min cost of left tree + min cost of right tree with i being the root
            int val = minCostRecur(freq, startIndex, i - 1) + minCostRecur(freq, i + 1, endIndex);

            if (val < min) {
                min = val;
            }
        }

        return (sum + min);
    }

    // using memoization dp

    public int minCostDP(int[] freq, int[][] lookup, int startIndex, int endIndex) {
        // no more elements
        if (startIndex > endIndex) {
            return 0;
        }
        // one element
        if (startIndex == endIndex) {
            return freq[startIndex];
        }

        if (lookup[startIndex][endIndex] == 0) {
            // get sum of all the nodes and then get min sum of left and right tree making each node as root
            int sum = sum(freq, startIndex, endIndex);

            int min = Integer.MAX_VALUE;

            for (int i = startIndex; i <= endIndex; i++) {
                // min cost of left tree + min cost of right tree with i being the root
                int val = minCostDP(freq, lookup, startIndex, i - 1) + minCostDP(freq, lookup, i + 1, endIndex);

                if (val < min) {
                    min = val;
                }
            }

            lookup[startIndex][endIndex] = sum + min;
        }

        return lookup[startIndex][endIndex];
    }

    private int sum(int[] freq, int startIndex, int endIndex) {
        int sum = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            sum += freq[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] keys = { 10, 12, 20 };
        int freq[] = { 34, 8, 50 };

        OptimalSearchTree optimalSearchTree = new OptimalSearchTree();

        System.out.println("optimal search tree cost using naive recursion : " + optimalSearchTree.minCostRecur(freq, 0, 2));

        int[][] lookup = new int[3][3];
        System.out.println("optimal search tree cost using dp  : " + optimalSearchTree.minCostDP(freq, lookup, 0, 2));
 }
}
