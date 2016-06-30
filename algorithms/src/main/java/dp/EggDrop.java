package dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liju on 6/30/16.
 *
 * http://www.geeksforgeeks.org/dynamic-programming-set-11-egg-dropping-puzzle/
 *
 */
public class EggDrop {

    //naive recursive solution
    public int minAttemptRecursive(int floors, int eggs){

        if (floors==0 || floors==1){
            return floors;
        }

        if (eggs==1){
            return floors;
        }

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= floors; i++) {

            int val = Math.max(minAttemptRecursive(floors-i,eggs),minAttemptRecursive(i-1,eggs-1));

            if (val < min){
                min = val;
            }
        }
        return 1+min;
    }

    public int minAttemptDP(int floors, int eggs, Map<Index,Integer> lookup){

        if (floors==0 || floors==1){
            return floors;
        }

        if (eggs==1){
            return floors;
        }

        Index index  = new Index(floors,eggs);

        if (lookup.get(index)==null) {
            int min = Integer.MAX_VALUE;
            for (int i = 1; i <= floors; i++) {

                int val = Math.max(minAttemptRecursive(floors - i, eggs), minAttemptRecursive(i - 1, eggs - 1));

                if (val < min) {
                    min = val;
                }
            }
            lookup.put(index, 1 + min);
        }
        return lookup.get(index);
    }

    class Index{

        int floors,eggs;

        public Index(int floors,int eggs){
            this.floors=floors;
            this.eggs=eggs;
        }

        @Override public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;

            Index index = (Index) o;

            if (eggs != index.eggs)
                return false;
            if (floors != index.floors)
                return false;

            return true;
        }

        @Override public int hashCode() {
            int result = floors;
            result = 31 * result + eggs;
            return result;
        }
    }


    public static void main(String[] args) {
        int eggs = 2;
        int floors  = 10;
        EggDrop eggDrop = new EggDrop();

        System.out.println("Min attempts using naive recursive : "+eggDrop.minAttemptRecursive(floors,eggs));
        System.out.println("Min attempts using dp : "+eggDrop.minAttemptDP(floors, eggs, new HashMap<>()));
    }
}
