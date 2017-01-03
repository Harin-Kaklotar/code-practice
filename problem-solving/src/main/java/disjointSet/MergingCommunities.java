package disjointSet;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by liju on 1/2/17.
 * https://www.hackerrank.com/challenges/merging-communities
 */
public class MergingCommunities {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfPeople = sc.nextInt();
        int noOfQueries = sc.nextInt();

        DisjointSet djs = new DisjointSet();

        for (int i = 1; i <= noOfPeople; i++) {
            djs.createSet(i);
        }

        for (int i = 0; i < noOfQueries; i++) {
            char c = sc.next().charAt(0);
            switch (c) {
                case 'M':
                    djs.union(sc.nextInt(), sc.nextInt());
                    break;
                case 'Q':
                    System.out.println(djs.size(sc.nextInt()));
                    break;
                default:
                    throw new IllegalArgumentException("invalid query");
            }
        }
    }


    static private class DisjointSet {
        private class Node {
            int data;
            int rank;
            int size;
            Node parent;
        }

        Map<Integer, Node> map = new HashMap<>();


        public void createSet(int x) {
            Node node = new Node();
            node.data = x;
            node.rank = 0;
            node.parent = node;
            node.size = 1;
            map.put(x, node);
        }


        public void union(int x, int y) {
            Node nodeX = map.get(x);
            Node nodeY = map.get(y);

            Node rootX = findSet(nodeX);
            Node rootY = findSet(nodeY);

            if (rootX == rootY) return;

            if (rootX.rank >= rootY.rank) {
                if (rootX.rank > rootY.rank) {
                    rootX.rank++;
                }
                rootX.size += rootY.size;
                rootY.parent = rootX;

            } else {
                rootX.parent = rootY;
                rootY.size += rootX.size;
            }

        }

        public int size(int x) {
            return findSet(map.get(x)).size;
        }

        private Node findSet(Node node) {
            if (node.parent == node) return node;
            node.parent = findSet(node.parent);
            return node.parent;
        }
    }
}
