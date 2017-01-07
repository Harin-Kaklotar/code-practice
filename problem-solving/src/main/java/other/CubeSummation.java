package other;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by liju on 1/7/17.
 * <p>
 * https://www.hackerrank.com/domains/data-structures/data-structures
 */
public class CubeSummation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        for (int i = 0; i < testcases; i++) {
            long n = sc.nextLong();
            long m = sc.nextLong();

            Set<Cell> set = new HashSet<>();
            for (int j = 0; j < m; j++) {
                String operation = sc.next();
                switch (operation) {
                    case "UPDATE":
                        Cell cell = new Cell(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt());
                        if (set.contains(cell)) {
                            set.remove(cell);
                        }
                        set.add(cell);
                        break;
                    case "QUERY":
                        long x1 = sc.nextLong();
                        long y1 = sc.nextLong();
                        long z1 = sc.nextLong();
                        long x2 = sc.nextLong();
                        long y2 = sc.nextLong();
                        long z2 = sc.nextLong();
                        long result = 0;
                        for (Cell cell1 : set) {
                            if (cell1.x >= x1 && cell1.x <= x2 && cell1.y >= y1 && cell1.y <= y2 && cell1.z >= z1 && cell1.z <= z2) {
                                result += cell1.value;
                            }
                        }
                        System.out.println(result);
                        break;
                    default:
                        throw new IllegalArgumentException("illegal operation");
                }
            }
        }
    }

    private static class Cell {
        long x, y, z, value;

        public Cell(long x, long y, long z, long value) {
            this.x = x;
            this.y = y;
            this.z = z;
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Cell cell = (Cell) o;

            if (x != cell.x) return false;
            if (y != cell.y) return false;
            return z == cell.z;
        }

        @Override
        public int hashCode() {
            int result = (int) (x ^ (x >>> 32));
            result = 31 * result + (int) (y ^ (y >>> 32));
            result = 31 * result + (int) (z ^ (z >>> 32));
            return result;
        }
    }
}
