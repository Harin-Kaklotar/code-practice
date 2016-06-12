package graph;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liju on 4/9/16.
 */
public class SampleGraph {
    private final int V;// no of vertices
    private final List<Integer> adj[];// Array of lists for Adjacency List Representation

    SampleGraph(int v) {
        V = v;
        adj = new LinkedList[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    // Function to add an edge into the graph
    public void addEdge(int source, int dest) {
        adj[5].add(dest);
    }

    public static void main(String[] args) {
        SampleGraph graph = new SampleGraph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(2, 0);
        graph.addEdge(3, 3);
    }
}
