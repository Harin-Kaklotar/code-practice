package graph;

import heap.MinHeap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by liju on 2/6/17.
 * <p>
 * 1. Used to find shortest distance from a source vertex to all other vertices in the graph
 * 2. Can be used for both directed and undirected graphs
 * 3. Graph mush be connected
 * 4. All edges must have non-negative weights
 * <p>
 * 5. A bit similar to PrimsMST algo
 */
public class DijkstraShortestPath {

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
        Map<Vertex<Integer>, Integer> distanceMap = dijkstraShortestPath(graph, graph.getVertex(0));

        System.out.println(distanceMap);


    }


    public static Map<Vertex<Integer>, Integer> dijkstraShortestPath(Graph<Integer> graph, Vertex<Integer> source) {
        MinHeap<Vertex<Integer>> minHeap = new MinHeap<>();
        Map<Vertex<Integer>, Integer> distance = new HashMap<>();
        Map<Vertex<Integer>, Vertex<Integer>> parent = new HashMap<>();
        // initialize distance to all the vertices to infinity i.e. unreachable
        for (Vertex<Integer> vertex : graph.getAllVertices()) {
            minHeap.add(Integer.MAX_VALUE, vertex);
        }
        //initialize the source to 0
        minHeap.decrease(source, 0);
        distance.put(source, 0);
        // parent of source will be null
        parent.put(source, null);

        while (!minHeap.empty()) {
            MinHeap<Vertex<Integer>>.Node node = minHeap.extractMinNode();
            Vertex<Integer> currentVertex = node.getKey();
            distance.put(currentVertex, node.getWeight());

            for (Edge<Integer> edge : currentVertex.getEdges()) {
                Vertex<Integer> otherVertex = getOtherVertex(edge, currentVertex);
                //if the vertex is not in the heap , it means its shortest distance from source is already found
                if (!minHeap.containsKey(otherVertex))
                    continue;

                // calc distance of current vertex from source
                int distanceNew = distance.get(currentVertex) + edge.getWeight();

                // if the new distance is less than the already existing then udpate the heap with the new distance
                if (distanceNew < minHeap.getWeight(otherVertex)) {
                    minHeap.decrease(otherVertex, distanceNew);
                    parent.put(otherVertex, currentVertex);
                }
            }
        }
        return distance;
    }

    private static Vertex<Integer> getOtherVertex(Edge<Integer> edge, Vertex<Integer> vertex) {
        return edge.getVertex1().equals(vertex) ? edge.getVertex2() : edge.getVertex1();
    }

}
