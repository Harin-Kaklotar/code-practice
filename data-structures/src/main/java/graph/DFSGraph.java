package graph;

import java.util.LinkedList;
import java.util.List;

/**
 * refer to DFSGraph.png
 */
public class DFSGraph {
    private int V;
    private List<Integer> adj[];

    DFSGraph(int v){
        V = v;
        adj = new LinkedList[V];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source ,int dest){
        adj[source].add(dest);
    }

    public void traversalDFS(int startVertice,boolean visited[]){

        //mark the visited node
        visited[startVertice] = true;
        System.out.println(" "+startVertice);
        //recurcusively call for all the adjacent vertices to the current node
        for (Integer adjacentVertice : adj[startVertice]) {
            if (!visited[adjacentVertice])
            traversalDFS(adjacentVertice,visited);
        }

    }

    public static void main(String[] args) {

        DFSGraph graph = new DFSGraph(4);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        // graph traversal from vertice 2
        graph.traversalDFS(2 , new boolean[graph.V]);
    }
}
