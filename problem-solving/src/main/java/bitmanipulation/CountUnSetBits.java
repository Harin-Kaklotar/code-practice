package bitmanipulation;

/**
 * Created by liju on 9/4/17.
 * <p>
 * Calculate number of unset bits in a given number
 */
public class CountUnSetBits {

    public static void main(String[] args) {
        System.out.println(unsetBits(8));
        System.out.println(unsetBits(7));
        System.out.println(unsetBits(4));
        System.out.println(unsetBits(10));

    }

    static int unsetBits(int n) {
        int count = 0;
        while (n > 0) {
            count += (n % 2 == 0) ? 1 : 0;
            n = n / 2;
        }
        return count;
    }

}
