package disjointSet;

import java.util.*;

/**
 * Created by liju on 1/2/17.
 * https://www.hackerrank.com/challenges/components-in-graph
 */
public class ComponentsInGraph {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        DisjointSet disjointSet = new DisjointSet();

        for (int i = 1; i <= 2 * n; i++) {
            disjointSet.createSet(i);
        }

        for (int i = 0; i < n; i++) {
            disjointSet.union(sc.nextInt(), sc.nextInt());
        }

        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            int size = disjointSet.size(i);
            if (size > max && size != 1)
                max = size;
            if (size < min && size != 1)
                min = size;
        }

        System.out.println(String.format("%d %d", min, max));
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
