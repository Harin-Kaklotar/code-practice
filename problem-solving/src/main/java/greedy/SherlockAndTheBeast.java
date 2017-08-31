package greedy;

import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * Created by liju on 8/30/17.
 *
 * https://www.hackerrank.com/challenges/sherlock-and-the-beast/problem
 *
 * Diophine equation  3x + 5y = N
 *
 *
 *
 * So, we have N numbers n_5 numbers of 5 and n_3 numbers of 3. n_5 + n_3 = N n_5 need to be divisible by 3 and n_3 need to be divisible by 5. Key to solving this task is that n_5 + n_3 need to be MAXIMUM from all exist cases. If you will think about this it’s easy to see that the maximum is then 5s in the beginning and 3s in the end (I hope this doesn’t need explanation) We will apply greedy algorithm principle: we need to take as much 5s in the beginning as we can. And only rest chunk of number fill with 3s. So now we have 2 cases from here: First one is trivial N is divisible by 3: N % 3 = 0. For example N is 9. Easy peasy: “555555555”
 Second case when N is not divisible by 3. What does it mean for us? That we need to fill some positions with 3s starting from tail. As n_3 need to be divisible by 5. We fill with 5 3s, look if we satisfying our constraints or not, if not fill again with 5 3s. Example 1: N = 11 N%3 = 2. First fill all 11 position with 5s “55555555555”. Now start to replace it with “3” First time: “55555533333” Does it satisfy constraints? Yes it does. n_5 = 6 n_3 = 5.
 Example 2: N = 10 N%3 = 1. First fill all 11 position with 5s “5555555555”. Now start to replace it with “3” First time: “5555533333” Does it satisfy constraints? Nope. n_5 = 5 and it’s not divisible by 3. So we fill with 3 3s again. “3333333333” Does it satisfy constraints now? Yes it does. n_5 = 0 n_3 = 10
 If you will play with any examples you will see that no matter how long number you will take you need to fill with “3”s only one time or two times, no more. When remainder is 2 It will be 1 time. If remainder is 1 it will be 2 times. Why this is happening?? There are no woodoo magic here, no pins and no dolls. Let’s look closer:
 Modulo 1: N%3 = 1 we can rephrase: x*3 +1 = N Now let’s start to fill with “3” x*3 +1 - 5 -> x*3 - 4 Is it divisible by 3? Nope. Let’s fill more 5 cells with 3s. x*3 +1 - 10 -> x*3 - 9 -> 3(x-3) Now we now that this is ALWAYS divisible by 3. So our answer is n_3 = 10, n_5 = N - 10
 Modulo 2: N%3 = 2 we can rephrase: x*3 + 2 = N Now let’s start to fill with “3” x*3 +2 - 5 -> x*3 - 3 -> 3(x - 1) And it’s ALWAYS divisible by 3 So our answer is n_3 = 5, n_5 = N - 5
 That’s it. Now don’t forget about cases then N is less than 10 and voila.
 */
public class SherlockAndTheBeast {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        // eg N=11 55555533333
        // N=5 33333
        // N=3 555
        // N=1 -1
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();

            int z = n;
            while (z % 3 != 0) {
                z -= 5;
            }
            if (z < 0) {
                System.out.println(-1);
            } else {
                StringBuilder sb = new StringBuilder();
                IntStream.range(0, z).forEach(x -> sb.append(5));
                IntStream.range(0, (n - z)).forEach(x -> sb.append(3));
                System.out.println(sb.toString());
            }
        }
    }
}
