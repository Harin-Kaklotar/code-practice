package dp;

import java.util.Map;

/**
 * 0/1 Knapsack Problem - Given items of certain weights/values and maximum allowed weight
 * how to pick items to pick items from this set to maximize sum of value of items such that
 * sum of weights is less than or equal to maximum allowed weight.
 *
 * Time complexity - O(W*total items)
 *
 * References -
 * http://www.geeksforgeeks.org/dynamic-programming-set-10-0-1-knapsack-problem/
 *
 */
public class Knapsack01 {

    /**
     * Simple recursive solution
     * @param wt
     * @param val
     * @param remainingWgt
     * @param currentItem
     * @param totalItems
     * @return
     */
    public int knapsackRecursive(int[] wt, int[] val,int remainingWgt , int currentItem,int totalItems){
        //base case
        if ((currentItem+1) > totalItems|| remainingWgt < 0 ){
            return 0;
        }
        //wght of current item is more than remaining , so ignore this item and move to next items
        if (wt[currentItem] > remainingWgt){
            return  knapsackRecursive(wt,val,remainingWgt,currentItem+1,totalItems);
        }else{
            //max of ( either when item is included or when item is not included)
            return Math.max(val[currentItem]+knapsackRecursive(wt,val,remainingWgt-wt[currentItem],currentItem+1,totalItems),knapsackRecursive(wt,val,remainingWgt,currentItem+1,totalItems));
        }

    }

    /**
     * Solution using dynamic top-down approach
     * @param wt
     * @param val
     * @param remainingWgt
     * @param currentItem
     * @param totalItems
     * @param memoizeMap
     * @return
     */
    public int knapsackDP(int[] wt, int[] val,int remainingWgt , int currentItem,int totalItems,Map<Index,Integer> memoizeMap){

        //base case
        if (remainingWgt < 0 || (currentItem+1) > totalItems){
            return 0;
        }

        final Index index = new Index(remainingWgt, totalItems - currentItem - 1);
        //check in the memorized map
        if (memoizeMap.containsKey(index)){
            return memoizeMap.get(index);
        }
        int valMax;
        if (wt[currentItem] > remainingWgt){
            valMax =  knapsackDP(wt,val,remainingWgt,currentItem+1,totalItems,memoizeMap);
        }else{
            //max of ( either when item is included or when item is not included)
            valMax =  Math.max(val[currentItem]+knapsackDP(wt,val,remainingWgt-wt[currentItem],currentItem+1,totalItems,memoizeMap),knapsackDP(wt,val,remainingWgt,currentItem+1,totalItems,memoizeMap));
        }
        memoizeMap.put(index,valMax);
        return valMax;

    }

    public static void main(String[] args) {
        int val[] = {60, 100, 120};
        int wt[] = {10, 20, 30};
        int  W = 50;

        Knapsack01 knapsack01 = new Knapsack01();
        System.out.println("Simple Recursive solution :  "+knapsack01.knapsackRecursive(wt,val,W,0,3));
        System.out.println("DP top-down solution :  "+knapsack01.knapsackRecursive(wt,val,W,0,3));
    }


    class Index {
        int remainingWgt;
        int remainingItems;

        public Index(int remainingWgt, int remainingItems){
            this.remainingItems= remainingItems;
            this.remainingWgt = remainingWgt;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            Index index = (Index) o;

            if (remainingItems != index.remainingItems)
                return false;
            if (remainingWgt != index.remainingWgt)
                return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = remainingWgt;
            result = 31 * result + remainingItems;
            return result;
        }
    }
}
