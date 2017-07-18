package simple;

import java.util.Scanner;

/**
 * Created by liju on 7/14/17.
 * https://www.hackerrank.com/challenges/encryption
 */
public class Encryption {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] input = sc.next().trim().toCharArray();
        double sqrt = Math.sqrt(input.length);
        int row = (int) Math.floor(sqrt);
        int col = (int) Math.ceil(sqrt);

        if (row * col < input.length) {
            row = row + 1;
        }

        char[][] mtrx = new char[row][col];
        int k = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col && k < input.length; j++) {
                mtrx[i][j] = input[k++];
            }
        }
        String str = "";

        for (int i = 0; i < col; i++) {

            for (int j = 0; j < row; j++) {
                if (mtrx[j][i] != '\u0000')
                    str += mtrx[j][i];
            }
            str += " ";
        }
        System.out.println(str);
    }
}


