package other;

import java.util.Arrays;

/**
 * Created by liju on 1/4/17.
 *
 Sum of product of all the possible triplets in a given array in O(n) time complexity
 */
public class TripletSum {

    public static void main(String[] args) {
        int[] O  = new int[]{1,2,3};
        int sum=0;
        //naive
        for (int i = 0; i < O.length; i++) {
            for (int j = i+1; j < O.length; j++) {
                for (int k = j+1; k < O.length; k++) {
                 sum+=O[i]*O[j]*O[k];
                }
            }
        }

        System.out.println(sum);

        // DP
        // O  =    1,  2,  3,  4, 5, 6
        // A  =    1,  2,  3,  4, 5, 6
        // B  =   20, 18, 15, 11, 6
        // A  =   20, 36, 45, 44, 30
        // C  =   155, 119, 74, 30
        // A  =   155,238,222,120
        int[] A = new int[O.length];
        int[] B = new int[O.length];
        int[] C = new int[O.length];

        sum =0;

        //update A with original values
        for (int i = 0; i < O.length; i++){
            A[i] = O[i];
        }

        System.out.println("A::"+Arrays.toString(A));
        for (int i = O.length-2; i >=0; i--) {
            B[i] = A[i + 1] + B[i + 1];
        }
        System.out.println("B::"+Arrays.toString(B));
        //update A
        for (int i = 0; i < O.length; i++) {
            A[i] = A[i] * B[i];
        }
        System.out.println("A::"+Arrays.toString(A));
        for (int i = O.length-3; i >=0 ; i--) {
            C[i] = A[i + 1] + C[i + 1];
        }
        System.out.println("C::"+Arrays.toString(C));

        //update A
        for (int i = 0; i < O.length; i++) {
            A[i] = O[i] * C[i];
        }
        System.out.println("A::"+Arrays.toString(A));

        for (int i = 0; i < O.length; i++) {
            sum += A[i];
        }

        System.out.println(sum);
    }
}
