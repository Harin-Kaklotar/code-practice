package bitmanipulation;

/**
 * Created by liju on 9/4/17.
 */
public class CountSetBits {

    public static void main(String[] args) {

        System.out.println(calculateSetBits(8));
        System.out.println(calculateSetBits(10));
        System.out.println(calculateSetBits(7));

    }

    static int calculateSetBits(int n){
        int count =0;

        while (n>0){
            n=n&(n-1);
            count++;
        }

        return count;
    }
}
