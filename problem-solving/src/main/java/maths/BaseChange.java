package maths;

/**
 * Created by liju on 8/21/17.
 */
public class BaseChange {

    /**
     * Converts a number n in base b (2<=b<=10) to a decimal number:
     * @param n
     * @param b
     * @return
     */

    public int toDecimal(int n, int b)
    {
        int result=0;
        int multiplier=1;

        while(n>0)
        {
            result+=n%10*multiplier;
            multiplier*=b;
            n/=10;
        }

        return result;
    }


    /**
     * Converts from a decimal number n to a number in base b (2<=b<=10)
     * @param n
     * @param b
     * @return
     */
    public int fromDecimal(int n, int b)
    {
        int result=0;
        int multiplier=1;

        while(n>0)
        {
            result+=n%b*multiplier;
            multiplier*=10;
            n/=b;
        }

        return result;
    }


    /**
     * Convert from a decimal to any base (up to base 20)
     * @param n
     * @param b
     * @return
     */
    public String fromDecimal2(int n, int b)
    {
        String chars="0123456789ABCDEFGHIJ";
        String result="";

        while(n>0)
        {
            result=chars.charAt(n%b) + result;
            n/=b;
        }

        return result;
    }



    //OR
    /**
     *
     Integer.parseInt(""+n,b);
     Integer.toBinaryString(n);
     Integer.toOctalString(n);
     Integer.toHexString(n);
     */


}
