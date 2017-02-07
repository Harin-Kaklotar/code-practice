package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import heap.MinHeap;

/**
 * Created by liju on 2/1/17.
 *
 * http://www.geeksforgeeks.org/greedy-algorithms-set-5-prims-minimum-spanning-tree-mst-2/
 */
public class PrimsMST {

    public static void main(String[] args) {

        Graph<Integer> graph = new Graph<>(false);
        graph.addEdge(0, 1, 4);
        graph.addEdge(1, 2, 8);
        graph.addEdge(2, 3, 7);
        graph.addEdge(3, 4, 9);
        graph.addEdge(4, 5, 10);
        graph.addEdge(5, 6, 2);
        graph.addEdge(6, 7, 1);
        graph.addEdge(7, 0, 8);
        graph.addEdge(1, 7, 11);
        graph.addEdge(7, 8, 7);
        graph.addEdge(2, 8, 2);
        graph.addEdge(6, 8, 6);
        graph.addEdge(2, 5, 4);
        graph.addEdge(3, 5, 14);

        final List<Edge<Integer>> edges = primsMST(graph);

        for (Edge<Integer> edge : edges) {
            System.out.println(edge);
        }
    }

    private static List<Edge<Integer>> primsMST(Graph<Integer> graph) {

        MinHeap<Vertex<Integer>> minHeap = new MinHeap<>();
        Map<Vertex<Integer>, Edge<Integer>> vertexToEdge = new HashMap<>();
        List<Edge<Integer>> mstEdges = new ArrayList<>();

        // initialize the key of all the vertices of the graph to infinity ( i.e. unreachable)
        for (Vertex<Integer> vertex : graph.getAllVertices()) {
            minHeap.add(Integer.MAX_VALUE,vertex);
        }

        // randomly select one of the vertex to start with
        final Vertex<Integer> startVertex = graph.getAllVertices().iterator().next();

        // update distance to start vertex as 0 in the heap, that it is picked first
        minHeap.decrease(startVertex, 0);

        // process each node until the heap is empty
        while (!minHeap.empty()) {
            // extract the vertex with min key
            final Vertex<Integer> vertex = minHeap.extractMin();

            // Get the edge for this vertex and add it to the final mst edges
            // This is the spanning edge and wont be present for the first vertex
            if (vertexToEdge.containsKey(vertex)) {
                mstEdges.add(vertexToEdge.get(vertex));
            }

            // Get all the adjacent edges for this vertex and update their distance
            for (Edge<Integer> adjEdge : vertex.getEdges()) {

                final Vertex<Integer> adjVertex = getOtherVertexForEdge(adjEdge, vertex);

                if (minHeap.containsKey(adjVertex) && minHeap.getWeight(adjVertex) > adjEdge.getWeight()) {
                    // decrease the wgt for the adj vertex
                    minHeap.decrease(adjVertex, adjEdge.getWeight());
                    // add it to the vertex to edge map
                    vertexToEdge.put(adjVertex, adjEdge);
                }
            }
        }
        return mstEdges;
    }

    private static Vertex<Integer> getOtherVertexForEdge(Edge<Integer> adjEdge, Vertex<Integer> vertex) {
        return adjEdge.getVertex1().equals(vertex) ? adjEdge.getVertex2() : adjEdge.getVertex1();
    }
}
