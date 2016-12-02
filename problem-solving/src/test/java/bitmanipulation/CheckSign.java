package bitmanipulation;

/**
 * Created by liju on 12/2/16.
 *
 * Check given integer is +ve or -ve ( 0 is considered +ve)
 */
public class CheckSign {

    public static void main(String[] args) {
        System.out.println(checkSign(-2));
        System.out.println(checkSign(0));
        System.out.println(checkSign(2));
    }

    public static String checkSign(int i) {
        return i >> 31 == 0 ? "+ve" : "-ve";
    }
}
