package simple;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by liju on 7/16/17.
 * https://www.hackerrank.com/challenges/flatland-space-stations
 */
public class FlatlandSpaceStation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] stations = new int[m];

        for (int i = 0; i < m; i++) {
            stations[i] = sc.nextInt();
        }

        Arrays.sort(stations);

        int maxDist = 0;
        if (stations[0]!=0) maxDist = stations[0];

        if (stations[m-1]!=(n-1) && ((n-1) - stations[m-1]) > maxDist) maxDist = (n-1) - stations[m-1];



        for (int i = 1; i < m; i++) {
            int dist = (int)Math.ceil((stations[i] - stations[i-1])/2);
            if (dist> maxDist) maxDist = dist;
        }

        System.out.println(maxDist);

    }
}
