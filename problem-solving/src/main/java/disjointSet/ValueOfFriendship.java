package disjointSet;

import java.util.*;

/**
 * Created by liju on 1/12/17. https://www.hackerrank.com/contests/w28/challenges/value-of-friendship
 */
public class ValueOfFriendship {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int q = sc.nextInt();

        for (int i = 0; i < q; i++) {
            final int noOfStudents = sc.nextInt();
            final int noOfFriendships = sc.nextInt();

            DisjointSet disjointSet = new DisjointSet();
            for (int j = 0; j < noOfStudents; j++) {
                disjointSet.createSet(j + 1);
            }
            for (int j = 0; j < noOfFriendships; j++) {
                final int x = sc.nextInt();
                final int y = sc.nextInt();
                disjointSet.union(x, y);
            }

            System.out.println(disjointSet.sum);
        }
    }

    private static class DisjointSet {
        private static class Node {
            int val;
            int rank;
            int size;
            Node parent;
        }

        Map<Integer, Node> map = new HashMap<>();
        long sum = 0;
        long currentIterationSum=0;
        Map<Integer,Node> mapOfSets = new HashMap<>();

        public void createSet(int val) {
            Node node = new Node();
            node.val = val;
            node.parent = node;
            node.rank = 0;
            node.size = 1;
            map.put(val, node);
        }

        public void union(int x, int y) {
            Node rootX = findSet(map.get(x));
            Node rootY = findSet(map.get(y));

            if (rootX == rootY) {
                sum=sum+currentIterationSum;
                return;
            }
            mapOfSets.remove(rootX.val);
            mapOfSets.remove(rootY.val);
            if (rootX.rank >= rootY.rank) {
                if (rootX.rank > rootY.rank) {
                    rootX.rank++;
                }
                rootX.size += rootY.size;
                rootY.parent = rootX;
                mapOfSets.putIfAbsent(rootX.val,rootX);
            } else {
                rootY.rank++;
                rootY.size += rootX.size;
                rootX.parent = rootY;
                mapOfSets.putIfAbsent(rootY.val,rootY);
            }
            updateSum();
        }

        private Node findSet(Node node) {

            if (node == node.parent)
                return node;

            // path compression
            node.parent = findSet(node.parent);
            return node.parent;
        }

        public int sizeOfSet(int x) {
            return findSet(map.get(x)).size;
        }
        public void updateSum(){
            currentIterationSum=0;
            for (Node node :mapOfSets.values()){
                currentIterationSum+=node.size*(node.size-1);
            }
            sum+=currentIterationSum;
        }
    }
}
