package array;

import java.util.Scanner;

/**
 * Created by liju on 12/9/16.
 A left rotation operation on an array of size  shifts each of the array's elements  unit to the left. For example, if left rotations are performed on array [1,2,3,4,5], then the array would become [3,4,5,1,2].


 Sample Input

 5 4
 1 2 3 4 5

 Sample Output

 5 1 2 3 4
 */
public class LeftRotation {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc  = new Scanner(System.in);
        int numbers  = sc.nextInt();
        int rotations  = sc.nextInt();
        int arr[] = new int[numbers];
        for (int i = 0; i < numbers; i++) {
            arr[i]= sc.nextInt();
        }
        int tmp[] = new int[rotations];
        System.arraycopy(arr,0,tmp,0,rotations);
        System.arraycopy(arr,rotations,arr,0,arr.length-rotations);
        System.arraycopy(tmp,0,arr,arr.length-rotations,rotations);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

}
