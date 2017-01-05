package competition;

import java.util.Scanner;

/**
 * Created by liju on 12/24/16.
 */
public class DrawingBook {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int p = in.nextInt();
        int fromFront = distanceFromFront(n, p);
        int fromEnd = distanceFromEnd(n, p);
        System.out.println(fromFront<fromEnd?fromFront:fromEnd);

    }

    private static int distanceFromEnd(int n, int p) {
        boolean numIsEven = n%2==0;
        int diff = n-p;
        boolean diffIsEven  = diff%2==0;
        if (numIsEven){
            if (diffIsEven){
                return diff/2;
            }else {
                return diff/2+1;
            }
        }else{
            return diff/2;
        }
    }

    private static int distanceFromFront(int n, int p) {
        if(p==1) return 0;
       return p/2;
    }
}
