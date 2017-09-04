package greedy;

import java.util.*;

/**
 * Created by liju on 9/2/17.
 * <p>
 * https://www.hackerrank.com/challenges/pylons/problem
 */
public class GoodlandElectricity {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        /*int towers[] = new int[n];
        for (int i = 0; i < n; i++) {
            towers[i] = sc.nextInt();
        }

        int start = 0;
        int end = Math.min(start + k-1,n-1);
        Set<Integer> selectedTowers = new HashSet<>();
        boolean possible = true;
         while (start<n){
            while (end>=start && towers[end]==0){
                if (start==end){
                    possible=false;
                    break;
                }
                end--;
            }
            if (start==end && towers[start]==0)break;
             selectedTowers.add(end);
             start = end+k;
             end = Math.min(start + k - 1,n);

        }

        System.out.println(!possible? -1 : selectedTowers.size());*/


        Map<Integer,Integer> towerMap = new HashMap<Integer,Integer>();
        for(int i=0;i<n;i++)
        {
            towerMap.put(i, sc.nextInt());
        }

        int start = k-1;
        int end = start+k-1;
        int next = end+k;
        int towers = 0;
        Set<Integer> towerSet = new HashSet<Integer>();

        while(start <n) {
            while(start >=0 && towerMap.get(start)!=1)
            {
                start--;
            }
            if(start >= 0 && !towerSet.contains(start))
            {
                towerSet.add(start);
            }
            else
            {
                towers = -1;
                break;
            }
            end = start+k-1;
            next = end+k;
            start = next;
            if(next >= n && end < n-1)
            {
                start = n-1;

            }
            towers++;
        }

        System.out.println(towers);
    }


    // 6 1 0 1 1 1 1 0
}
