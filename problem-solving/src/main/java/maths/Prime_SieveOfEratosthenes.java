package maths;

import java.util.Arrays;

/**
 * Created by liju on 8/21/17.
 * 
 * Now suppose we wanted to find all the primes from 1 to 100000, then we would have to call the prime method 100000
 * times. This would be very inefficient since we would be repeating the same calculations over and over again. In this
 * situation it is best to use a method known as the Sieve of Eratosthenes. The Sieve of Eratosthenes will generate all
 * the primes from 2 to a given number n. It begins by assuming that all numbers are prime. It then takes the first
 * prime number and removes all of its multiples. It then applies the same method to the next prime number. This is
 * continued until all numbers have been processed
 */
public class Prime_SieveOfEratosthenes {

    public boolean[] sieve(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        prime[0] = false;
        prime[1] = false;
        double m = Math.sqrt(n);

        for (int i = 2; i <= m; i++)
            if (prime[i])
                for (int k = i * i; k <= n; k += i)
                    prime[k] = false;

        return prime;
    }
}
