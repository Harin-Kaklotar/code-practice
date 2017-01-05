package disjointSet;

import java.util.*;

/**
 * Created by liju on 1/3/17.
 *
 https://www.hackerrank.com/challenges/kundu-and-tree

 If there is a red edge between vertex 'a' and 'b' then if we delete the red edge then vertex a and b will lie on different comonenet of the tree. So, if we delete all of the red edges in the tree. All the three vertices i.e. a, b and c will have to lie of different disconnected components.
 So, when you are scanning the tree and got that color of some edge is red, don't scan it and make forest i.e. disconnected tree.
 Consider that size of these components are a1, a2, a3,.... , ak.
 So we have to pick three vertices out of given k disconnected component
 */
public class KunduAndTree {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfVertices = sc.nextInt();

        long MOD = 1000000007;

        DisjointSet disjointSet = new DisjointSet();

        for (int i = 1; i <= noOfVertices; i++) {
            disjointSet.createSet(i);
        }

        for (int i = 1; i < noOfVertices; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            if (sc.next().charAt(0) == 'b') {
                disjointSet.union(v1, v2);
            }
        }

        List<DisjointSet.Node> list = new ArrayList<>();
        list.add(disjointSet.findSet(disjointSet.map.get(1)));

        for (int i = 2; i <= noOfVertices; i++) {
            DisjointSet.Node node = disjointSet.findSet(disjointSet.map.get(i));
            if (!list.contains(node)) {
                list.add(node);
            }
        }


        long sum = 0;
        long[] A = new long[list.size()];
        long[] B = new long[list.size()];
        long[] C = new long[list.size()];

        // Reducing the naive O(n3) to O(n)
        for (int i = 0; i < list.size(); i++) {
            A[i] = list.get(i).size;
        }

        for (int i = list.size() - 2; i >= 0; i--) {
            B[i] = (A[i + 1] + B[i + 1]) % MOD;
        }

        //update A
        for (int i = 0; i < list.size(); i++) {
            A[i] = (A[i] * B[i]) % MOD;
        }

        for (int i = list.size() - 3; i >= 0; i--) {
            C[i] = (A[i + 1] + C[i + 1]) % MOD;
        }

        //update A
        for (int i = 0; i < list.size(); i++) {
            A[i] = (list.get(i).size * C[i]) % MOD;
        }

        for (int i = 0; i < list.size(); i++) {
            sum = (sum + A[i]) % MOD;
        }

        System.out.println(sum);
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

