package maths;

/**
 * Created by liju on 8/21/17.
 */
public class Prime {

    public boolean isPrime(int n) {
        if (n <= 1)
            return false;
        if (n == 2)
            return true;
        if (n % 2 == 0)
            return false;
        double m = Math.sqrt(n);

        for (int i = 3; i <= m; i += 2)
            if (n % i == 0)
                return false;

        return true;
    }

    public static void main(String[] args) {
        final Prime prime = new Prime();
        System.out.println(prime.isPrime(36));
        System.out.println(prime.isPrime(37));
    }
}
