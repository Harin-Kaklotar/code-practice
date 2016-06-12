package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *
 * start with any node and put that in a set of visited nodes and explore the children of the visited node , once that
 * node has no children ( i.e. totally explored) then put that node in stack and similaryly continue till all thed node
 * are visited and explored
 *
 * print the stack elememts
 *
 * Applications - build system where one package or component depends one other , the dependent components needs to be
 * build after that
 */
public class TopologicalSort {

    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);

        graph.topologicalSort();
    }
}

class Graph {
    private int V;
    private List<Integer> adj[];

    public Graph(int v) {
        V = v;
        adj = new LinkedList[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int dest) {
        adj[source].add(dest);
    }

    // method for topological sorting
    public void topologicalSort() {
        boolean[] visited = new boolean[V];
        Stack<Integer> exploredNode = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                exploreChildren(i, visited, exploredNode);
            }
        }

        // print all elements of stack - this is sorted elements
        while (!exploredNode.empty()) {
            System.out.print(" " + exploredNode.pop());
        }
    }

    // Explore all children of currrent nodes
    private void exploreChildren(int i, boolean[] visited, Stack<Integer> exploredNode) {
        visited[i] = true; // mark visited and explore all its children
        for (Integer adjVertice : adj[i]) {
            if (!visited[adjVertice])
                exploreChildren(adjVertice, visited, exploredNode);
        }
        exploredNode.push(i);
    }
}
