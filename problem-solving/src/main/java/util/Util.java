package util;

/**
 * Created by liju on 7/10/17.
 */
public class Util {


    /**
     * Reverse the given input integer
     * @param input
     * @return
     */
    static int reverse(int input){
        long reversedNum = 0;

        long input_long = input;

        while (input_long != 0)
        {
            reversedNum = reversedNum * 10 + input_long % 10;
            input_long = input_long / 10;
        }

        if (reversedNum > Integer.MAX_VALUE || reversedNum < Integer.MIN_VALUE)
        {
            throw new IllegalArgumentException();
        }
        return (int)reversedNum;
    }

    public static void main(String[] args) {
        System.out.println(reverse(320));
    }
}
