package graph;

import java.util.*;

/**
 * Created by liju on 1/14/17.
 * https://www.hackerrank.com/challenges/journey-to-the-moon
 */
public class JourneyToMoon {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = sc.nextInt();

        DisjointSet djs = new DisjointSet();
        for (int j = 0; j < n; j++) {
            djs.create(j);
        }
        for (int j = 0; j < i; j++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            djs.union(x, y);
        }

        Map<Integer, Integer> componentMap = new HashMap<>();
        for (int j = 0; j < n; j++) {
            DisjointSet.Node parent = djs.findSet(j);
            if (!componentMap.containsKey(parent.val)) {
                componentMap.put(parent.val, parent.size);
            }
        }

        // do the suffix sum array for getting all the combinations
        int tmp[] = new int[componentMap.size()];
        Integer[] sizes = new Integer[componentMap.size()];
        sizes = componentMap.values().toArray(sizes);

        for (int j = sizes.length - 2; j >= 0; j--) {
            tmp[j] = sizes[j + 1] + tmp[j + 1];
        }

        long total = 0;
        for (int j = 0; j < sizes.length; j++) {
            total = total + (sizes[j] * tmp[j]);
        }

        System.out.println(total);
    }

    private static class DisjointSet {
        private static class Node {
            int val;
            int rank;
            int size;
            Node parent;
        }

        private Map<Integer, Node> map = new HashMap<>();

        public void create(int val) {
            Node node = new Node();
            node.rank = 0;
            node.size = 1;
            node.val = val;
            node.parent = node;
            map.put(val, node);
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
                rootY.parent = rootX;
                rootX.size += rootY.size;
            } else {
                rootY.rank++;
                rootX.parent = rootY;
                rootY.size += rootX.size;
            }
        }

        private Node findSet(Node node) {
            if (node.parent == node) return node;
            node.parent = findSet(node.parent);
            return node.parent;
        }

        public int size(int x) {
            return findSet(map.get(x)).size;
        }

        public Node findSet(int val) {
            return findSet(map.get(val));
        }
    }
}
