package simple;

import java.util.Scanner;

/**
 * Created by liju on 7/16/17.
 * https://www.hackerrank.com/challenges/cavity-map
 */
public class CavityMap {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        char[][] map = new char[n][n];

        for (int i = 0; i < n; i++) {
            char[] tmp = sc.next().toCharArray();
            for (int j = 0; j < n; j++) {
                map[i][j] = tmp[j];
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i!=0 && i != (n-1) && j!=0 && j!=(n-1) ){
                    if (map[i][j]>map[i-1][j] && map[i][j]>map[i+1][j] && map[i][j]>map[i][j+1] && map[i][j]>map[i][j-1] ){
                        map[i][j] ='X';
                    }
                }
                System.out.print(map[i][j]);
            }
            System.out.print("\n");
        }
    }
}
