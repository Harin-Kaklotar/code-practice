package simple;

import java.util.Scanner;

/**
 * Created by liju on 7/9/17.
 * https://www.hackerrank.com/challenges/climbing-the-leaderboard
 */
public class ClimbingLeaderboard {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] scores = new int[n];

        scores[0] = in.nextInt();
        int j = 1;
        for (int i = 1; i < n; i++) {
            int tmp = in.nextInt();
            if (scores[j-1]!=tmp) {
                scores[j] = tmp;j++;
            }
        }


        int m = in.nextInt();
        for(int i=0; i < m; i++){
            System.out.println(solve(in.nextInt(),scores,j-1));
        }
        // your code goes here
    }

    private static int solve(int val, int[] scores, int end) {
         return binarySearch(val ,scores,0,end);
    }

    private static int binarySearch(int val,int[] scores,int l, int r){

        int m = 0;
        if((l+r)%2 == 0) m = (l+r)/2;
        else  m = (l+r)/2+1;

        if(val < scores[m] && m < r && m > l){
            return binarySearch(val,scores,m,r);
        }else if(val > scores[m] && m < r && m > l){
            return binarySearch(val,scores,l,m);
        }else{
            return m;
        }

    }
}
