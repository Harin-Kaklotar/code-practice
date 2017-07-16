package simple;

import java.util.Scanner;

/**
 * Created by liju on 7/14/17.
 * https://www.hackerrank.com/challenges/taum-and-bday
 */
public class TaumBday {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {

            long B = sc.nextLong();
            long W = sc.nextLong();

            long X = sc.nextLong();
            long Y = sc.nextLong();
            long Z = sc.nextLong();

            boolean useX = true;
            boolean useY = true;
            if (X < Y && (X+Z)<Y){
                Y = X;
                useY = false;
            }else if(Y < X && (Y+Z) < X) {
                X = Y;
                useX = false;
            }
            System.out.println((useX?X*B:(Y+Z)*B)+ (useY?Y*W:(X+Z)*W));
        }
    }
}
