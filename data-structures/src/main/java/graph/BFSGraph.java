package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Refer pic BFSGraph.png
 */
public class BFSGraph {
    private int V;
    private List<Integer> adj[];

    BFSGraph(int v) {
        V = v;
        adj = new LinkedList[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int dest) {
        adj[source].add(dest);
    }

    public void traversalBFS(int startVertice) {
        // default - mark all the vertices as not visited
        boolean visited[] = new boolean[V];
        // Create a queue for BFS
        Queue<Integer> queue = new LinkedList<>();

        queue.add(startVertice);
        visited[startVertice] = true;

        while (!queue.isEmpty()) {

            int vertice = queue.poll();
            // print visited node
            System.out.print(" " + vertice);

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            for (Integer adjacentVertice : adj[vertice]) {
                if (!visited[adjacentVertice]) {
                    queue.add(adjacentVertice);
                    visited[adjacentVertice] = true;
                }
            }

        }

    }

    public static void main(String[] args) {
        BFSGraph graph = new BFSGraph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        // graph traversal from vertice 2
        graph.traversalBFS(2);

    }
}
