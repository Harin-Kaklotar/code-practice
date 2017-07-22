package string;

import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Created by liju on 7/20/17.
 * https://www.hackerrank.com/challenges/game-of-thrones
 */
public class GOT1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long count = sc.next().chars().mapToObj(x -> (char) x).collect(Collectors.groupingBy(x -> x, Collectors.counting())).entrySet().stream().filter(x -> x.getValue() % 2 != 0).count();
        System.out.println(count > 1 ? "NO" : "YES");
    }
}
