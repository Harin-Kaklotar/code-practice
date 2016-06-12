package graph;

import java.util.LinkedList;
import java.util.List;

/**
 * Detects cycle in a given graph
 *
 * To detect a back edge, we can keep track of vertices currently in recursion stack of function for DFS traversal.
 * If we reach a vertex that is already in the recursion stack, then there is a cycle in the tree. The edge that connects
 * current vertex to the vertex in the recursion stack is back edge.
 * We have used recStack[] array to keep track of vertices in the recursion stack.
 *
 * Refer DetectCycle-DirectedGraph.png
 */
public class DetectCycleDirectedGraph {

    int V;
    List<Integer> adj[];

    public DetectCycleDirectedGraph(int v) {
        V = v;
        adj = new LinkedList[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int dest) {
        adj[source].add(dest);
    }

    public boolean isCyclic() {
        // traverse from every node to check cycle
        for (int i = 0; i < V; i++) {
            boolean isCyclic = traverseDFS(i, new boolean[V], new boolean[V]);
            if (isCyclic)
                return isCyclic;
        }
        return false;
    }

    private boolean traverseDFS(int vertice, boolean visited[], boolean recStack[]) {

        visited[vertice] = true;
        recStack[vertice] = true;

        for (Integer adjacentVertice : adj[vertice]) {

            if (!visited[adjacentVertice]) {
                traverseDFS(adjacentVertice, visited, recStack);

            }// if visited and is in recursion stack
            else if (recStack[adjacentVertice]) {
                return true;
            }
        }
        // remove the vertice from the recursion stack
        recStack[vertice] = false;
        return false;
    }

    public static void main(String[] args) {
        // cyclic graph
        DetectCycleDirectedGraph cyclicGraph = new DetectCycleDirectedGraph(4);
        cyclicGraph.addEdge(0, 1);
        cyclicGraph.addEdge(0, 2);
        cyclicGraph.addEdge(1, 2);
        cyclicGraph.addEdge(2, 0);
        cyclicGraph.addEdge(2, 3);
        cyclicGraph.addEdge(3, 3);

        // non-cyclic graph

        DetectCycleDirectedGraph nonCyclicGraph = new DetectCycleDirectedGraph(4);
        nonCyclicGraph.addEdge(2, 0);
        nonCyclicGraph.addEdge(0, 1);
        nonCyclicGraph.addEdge(1, 3);
        nonCyclicGraph.addEdge(2, 3);

        System.out.println("cyclicGraph graph is cyclic - " + cyclicGraph.isCyclic());
        System.out.println("nonCyclicGraph graph is cyclic - " + nonCyclicGraph.isCyclic());
    }
}
