package graph;

import java.util.*;

/**
 * Created by liju on 1/15/17.
 * https://www.hackerrank.com/challenges/kruskalmstrsub

 Hint  - use disjoint set for creating MST
 */
public class KruskalMST {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nodes = sc.nextInt();
        int edges = sc.nextInt();

        List<Edge> edgeList = new ArrayList<>();
        DisjointSet disjointSet = new DisjointSet();
        for (int i = 1; i <= nodes; i++) {
            disjointSet.create(i);
        }
        for (int i = 0; i < edges; i++) {
            edgeList.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        edgeList.sort(Comparator.comparing(edge -> edge.w));

        long totalWgt = 0;
        for (Edge edge : edgeList) {
            if (disjointSet.findSet(edge.x) != disjointSet.findSet(edge.y)) {
                disjointSet.union(edge.x, edge.y);
                totalWgt += edge.w;
            }
        }

        System.out.println(totalWgt);
    }

    private static class Edge {
        int x, y, w;

        public Edge(int x, int y, int w) {
            this.x = x;
            this.y = y;
            this.w = w;
        }
    }

    private static class DisjointSet {
        private static class Node {
            int val;
            int rank;
            Node parent;
        }

        Map<Integer, Node> map = new HashMap<>();

        public void create(int val) {
            Node node = new Node();
            node.val = val;
            node.rank = 0;
            node.parent = node;
            map.put(val, node);
        }

        public void union(int x, int y) {
            Node rootX = findSet(map.get(x));
            Node rootY = findSet(map.get(y));
            if (rootX == rootY) return;

            if (rootX.rank >= rootY.rank) {
                if (rootX.rank > rootY.rank) {
                    rootX.rank++;
                }
                rootY.parent = rootX;
            } else {
                rootY.rank++;
                rootX.parent = rootY;
            }
        }

        private Node findSet(Node node) {
            if (node.parent == node) return node;
            node.parent = findSet(node.parent);
            return node.parent;
        }

        public int findSet(int val) {
            return findSet(map.get(val)).parent.val;
        }
    }
}
