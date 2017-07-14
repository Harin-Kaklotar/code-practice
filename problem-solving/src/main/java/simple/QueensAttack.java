package simple;

import java.util.Scanner;

/**
 * Created by liju on 7/13/17.
 * https://www.hackerrank.com/challenges/queens-attack-2
 */
public class QueensAttack {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int rQueen = in.nextInt();
        int cQueen = in.nextInt();

        Coordinate u = new Coordinate(-1, -1);
        Coordinate d = new Coordinate(-1, -1);
        Coordinate r = new Coordinate(-1, -1);
        Coordinate l = new Coordinate(-1, -1);
        Coordinate ur = new Coordinate(-1, -1);
        Coordinate ul = new Coordinate(-1, -1);
        Coordinate dr = new Coordinate(-1, -1);
        Coordinate dl = new Coordinate(-1, -1);


        for (int a0 = 0; a0 < k; a0++) {
            int rObstacle = in.nextInt();
            int cObstacle = in.nextInt();
            // your code goes here
            //left
            if ((rObstacle == rQueen && cObstacle < cQueen)) {
                if (cObstacle > u.c || (l.c == -1)) {
                    l.r = rObstacle;
                    l.c = cObstacle;
                }
            }
            //right
            if (rObstacle == rQueen && cObstacle > cQueen) {
                if (cObstacle < r.c || (r.c == 1))
                    r.r = rObstacle;
                r.c = cObstacle;
            }

            // up
            if (cObstacle == cQueen && rObstacle > rQueen) {
                if (rObstacle < u.r || u.r == -1) u.r = rObstacle;
                u.c = cObstacle;
            }
            // down
            if (cObstacle == cQueen && rObstacle < rQueen) {
                if (rObstacle > d.r || d.r == -1) d.r = rObstacle;
                d.c = cObstacle;
            }

            //up right
            if (cObstacle - cQueen == rObstacle - rQueen && cObstacle > cQueen && rObstacle > rQueen) {
                if (ur.c == -1 || (cObstacle < ur.c && rObstacle < ur.r)) {
                    ur.r = rObstacle;
                    ur.c = cObstacle;
                }
            }

            //up left
            if (cQueen - cObstacle == rObstacle - rQueen && cObstacle < cQueen && rObstacle > rQueen) {
                if (ul.r == -1 || (cObstacle > ul.c && rObstacle < ul.r)) {
                    ul.r = rObstacle;
                    ul.c = cObstacle;
                }
            }

            //down right
            if (cObstacle - cQueen == rQueen - rObstacle && cObstacle > cQueen && rObstacle < rQueen) {
                if (dr.r == -1 || (cObstacle < dr.c && rObstacle > dr.r)) {
                    dr.r = rObstacle;
                    dr.c = cObstacle;
                }
            }

            //down left
            if (cQueen - cObstacle == rQueen - rObstacle && cObstacle < cQueen && rObstacle < rQueen) {
                if (dl.r == -1 || (cObstacle > dl.c && rObstacle > dl.r)) {
                    dl.r = rObstacle;
                    dl.c = cObstacle;
                }
            }

        }


        int lC = (l.c != -1) ? (cQueen - l.c - 1) : cQueen - 1;
        int rC = r.c != -1 ? r.c - cQueen - 1 : n - cQueen;
        int uC = u.r != -1 ? u.r - rQueen - 1 : n - rQueen;
        int dC = d.r != -1 ? rQueen - d.r - 1 : rQueen - 1;

        int drC = dr.c != -1 ? dr.c - cQueen - 1 : Math.min(n - cQueen, rQueen - 1);
        int dlC = dl.c != -1 ? cQueen - dl.c - 1 : Math.min(cQueen - 1, rQueen - 1);
        int ulC = ul.c != -1 ? cQueen - ul.c - 1 : Math.min(cQueen - 1, n - rQueen);
        int urC = ur.c != -1 ? ur.c - cQueen - 1 : Math.min(n - cQueen, n - rQueen);


        System.out.println(lC + rC + uC + dC + urC + ulC + drC + dlC);

    }

    static class Coordinate {
        int r, c;

        public Coordinate(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
