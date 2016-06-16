package backtracking;

/**
 * Created by liju on 6/14/16.
 * Subset sum problem is to find subset of elements that are selected from a given set whose sum adds up to a given number K.
 * We are considering the set contains non-negative values. It is assumed that the input set is unique (no duplicates are presented).
 */
public class SubsetSum {

    public boolean subsetSum(int[] set, int[] targetSet, int currentSum, int targetSum, int startPoint) {
        if (currentSum == targetSum) {
            return true;
        }
        //pick element one by one
        for (int i = startPoint; i < set.length; i++) {
            if (currentSum + set[i] <= targetSum) {
                targetSet[i] = set[i];
                if (subsetSum(set, targetSet, (currentSum + set[i]), targetSum, startPoint + 1)) {
                    return true;
                }
                targetSet[i] = 0;
            }
        }
        return false;//backtrack
    }

    public static void main(String[] args) {
        SubsetSum subsetSum = new SubsetSum();
        int[] input = { 10, 7, 5, 18, 12, 20, 15 };
        int[] targetSet = { 0, 0, 0, 0, 0, 0, 0 };
        int targetSum = 35;

        if (subsetSum.subsetSum(input, targetSet, 0, targetSum, 0)) {
            System.out.println("solution exists");
        } else {
            System.out.println("solution doesn't exists");
        }

        // print
        for (int i = 0; i < targetSet.length; i++) {
            System.out.print(targetSet[i] + "\t");
        }
    }
}

