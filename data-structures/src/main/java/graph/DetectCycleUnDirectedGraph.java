package graph;

import java.util.LinkedList;
import java.util.List;

/**
 * Like directed graphs, we can use DFS to detect cycle in an undirected graph in O(V+E) time. We do a DFS traversal of
 * the given graph. For every visited vertex ‘v’, if there is an adjacent ‘u’ such that u is already visited and u is
 * not parent of v, then there is a cycle in graph. If we don’t find such an adjacent for any vertex, we say that there
 * is no cycle. The assumption of this approach is that there are no parallel edges between any two vertices.
 */
public class DetectCycleUnDirectedGraph {
    private int V;
    private List<Integer> adj[];

    public DetectCycleUnDirectedGraph(int v) {
        V = v;
        adj = new LinkedList[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    // add both ways for undirected graph
    public void addEdge(int a, int b) {
        adj[a].add(b);
        adj[b].add(a);
    }

    public boolean isCyclic() {

        for (int i = 0; i < V; i++) {
            boolean isCyclic = isCyclic(i, new boolean[V], -1);
            if (isCyclic)
                return true;
        }
        return false;
    }

    private boolean isCyclic(int vertice, boolean[] visited, int parent) {
        visited[vertice] = true;

        for (Integer adjVertice : adj[vertice]) {
            if (!visited[adjVertice]) {
                isCyclic(adjVertice, visited, vertice);
            } else if (adjVertice != parent) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        DetectCycleUnDirectedGraph cyclicGraph = new DetectCycleUnDirectedGraph(5);
        cyclicGraph.addEdge(1, 0);
        cyclicGraph.addEdge(0, 2);
        cyclicGraph.addEdge(2, 0);
        cyclicGraph.addEdge(0, 3);
        cyclicGraph.addEdge(3, 4);

        DetectCycleUnDirectedGraph cyclicGraph2 = new DetectCycleUnDirectedGraph(3);
        cyclicGraph2.addEdge(0, 1);
        cyclicGraph2.addEdge(1, 2);
        cyclicGraph2.addEdge(2, 0);

        DetectCycleUnDirectedGraph noncyclicGraph = new DetectCycleUnDirectedGraph(3);
        noncyclicGraph.addEdge(0, 1);
        noncyclicGraph.addEdge(1, 2);

        DetectCycleUnDirectedGraph noncyclicGraph2 = new DetectCycleUnDirectedGraph(5);
        noncyclicGraph2.addEdge(0, 1);
        noncyclicGraph2.addEdge(1, 2);
        noncyclicGraph2.addEdge(2, 3);
        noncyclicGraph2.addEdge(1, 4);

        System.out.println("cyclicGraph is cyclic - " + cyclicGraph.isCyclic());
        System.out.println("cyclicGraph2 is cyclic - " + cyclicGraph2.isCyclic());
        System.out.println("noncyclicGraph is cyclic - " + noncyclicGraph.isCyclic());
        System.out.println("noncyclicGraph2 is cyclic - " + noncyclicGraph2.isCyclic());
    }
}
