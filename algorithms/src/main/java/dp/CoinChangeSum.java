package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liju on 6/17/16.
 * Given a list of N coins, their values (V1, V2, … , VN), and the total sum S.
 * Find the minimum number of coins the sum of which is S (we can use as many coins of one type as we want),
 * or report that it’s not possible to select coins in such a way that they sum up to S.
 */
public class CoinChangeSum {

   /* public int coinChangeSum(int[] coins, int sum,int[][] solution){

        // populate the first row
        for (int i = 0; i <= sum; i++) {
            if (i > coins[0]){
                solution[0][i] = (1 + solution[0][i- i%coins[0]]);
            }

        }

        for (int i = 1; i < coins.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (coins[i] > j){
                    solution[i][j] = solution[i-1][j];
                }else {
                    solution[i][j] = Math.min(solution[i-1][j],1+solution[i][j- (j%coins[i])]);
                }
            }
        }

        return solution[coins.length-1][sum-1];
    }
*/

    public int coinChangeRecursive(int[] coins,int requiredSum){

        //base case
        if (requiredSum == 0){
            return 0;
        }

        int minCoinsReq  = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {

            if (coins[i] <= requiredSum){
                //no need to add 1 here as same coin can be used multiple times
                int val  =  coinChangeRecursive(coins, requiredSum - coins[i]);

                if (val < minCoinsReq){
                    minCoinsReq = val;
                }
            }

        }
        minCoinsReq = (minCoinsReq == Integer.MAX_VALUE ? minCoinsReq: minCoinsReq+1);

        return minCoinsReq;

    }



    public int coinChangeDP(int[] coins,int requiredSum,Map<Integer,Integer> map){

        //base case
        if (requiredSum == 0){
            return 0;
        }

        if (map.containsKey(requiredSum)){
            return map.get(requiredSum);
        }
        int minCoinsReq  = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {

            if (coins[i] <= requiredSum){
                //no need to add 1 here as same coin can be used multiple times
                int val  =  coinChangeRecursive(coins, requiredSum - coins[i]);

                if (val < minCoinsReq){
                    minCoinsReq = val;
                }
            }

        }
        minCoinsReq = (minCoinsReq == Integer.MAX_VALUE ? minCoinsReq: minCoinsReq+1);

        map.put(requiredSum,minCoinsReq);

        return minCoinsReq;

    }

    public static void main(String[] args) {

        int total = 13;
        //int coins[] = {7, 3, 2, 6};
        int coins[] = {2, 3, 6, 7};
        int[][] sol = new int[coins.length][total+1];

        CoinChangeSum coinChangeSum = new CoinChangeSum();
       // int minCoinReq = coinChangeSum.coinChangeSum(coins,total,sol);

       // System.out.println("Min coins required to get sum of "+total +" is "+minCoinReq);

        System.out.println("Recursive solution  : Min coins required to get sum of "+total +" is "+coinChangeSum.coinChangeRecursive(coins,total));
        System.out.println("DP solution  : Min coins required to get sum of "+total +" is "+coinChangeSum.coinChangeDP(coins, total, new HashMap<>()));
    }
}
