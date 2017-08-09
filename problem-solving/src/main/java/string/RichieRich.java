package string;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by liju on 7/25/17.
 * <p>
 * https://www.hackerrank.com/challenges/richie-rich
 */
public class RichieRich {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        char[] num = sc.next().toCharArray();

        int i = 0, j = n - 1;
        int changesReq = 0;
        List<Integer> pos = new LinkedList<>();
        while (i < j) {
            if (num[i] != num[j]) {
                changesReq++;
                pos.add(i);
            }
            i++;
            j--;
        }

        Iterator<Integer> iterator = pos.iterator();

        if (changesReq > k) {
            System.out.println(-1);
            return;
        }

        i = 0; j = n - 1;
        while (k > changesReq * 2 && changesReq > 0) {
            //if ()
        }

        while (changesReq < k && changesReq > 0)  {
            Integer index = iterator.next();
            if (num[index] != '9' && num[n - index - 1] != '9') {
                num[index] = '9';
                num[n - index - 1] = '9';
                changesReq--;
                k -= 2;
            } else if ((num[index] != '9' && num[n - index - 1] == '9') || (num[index] == '9' && num[n - index - 1] != '9')) {
                num[index] = '9';
                num[n - index - 1] = '9';
                changesReq--;
                k -= 1;
            }
        }

        while (changesReq == k && changesReq > 0) {
            Integer index = iterator.next();
            if (num[index] > num[n - index - 1]) {
                num[n - index - 1] = num[index];
            } else {
                num[index] = num[n - index - 1];
            }
            changesReq--;
            k--;
        }

        //still be have pending k , the num is already palindrome now
        i =0;
        j = n - 1;
        while (k>0 && i<=j){
            if (k > 1) {
                if (i==j){
                    num[i]='9';
                    i++;j--;
                    k--;
                }
                else if (num[i] != '9') {
                    num[i]='9';
                    num[j]='9';
                    i++;j--;
                    k-=2;
                }else {
                    i++;j--;
                }
            }else {
                if (i==j){
                    num[i] = '9';
                    k--;
                }
                i++;
                j--;
            }

        }

        System.out.println(String.valueOf(num));

    }


}
