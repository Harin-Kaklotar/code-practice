package graph;

import java.util.*;

/**
 * Created by liju on 2/6/17.
 */
public class DijkstraShortestPath {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt();
        for (int i = 0; i < testcases; i++) {
            Graph<Integer> graph = new Graph<>(false);
            int nodes = sc.nextInt();
            int edges = sc.nextInt();

            for (int j = 0; j < edges; j++) {
                graph.addEdge(sc.nextInt(), sc.nextInt(), sc.nextInt());
            }

            int source = sc.nextInt();
            Map<Vertex<Integer>, Integer> distanceMap = dijkstraShortestPath(graph, graph.getVertex(source));
            distanceMap.remove(graph.getVertex(source));

            distanceMap.values().stream().forEach(distance -> {
                if (distance == Integer.MAX_VALUE) {
                    System.out.println(-1 + " ");
                } else {
                    System.out.print(distance + " ");
                }
            });
        }
    }

    private static Map<Vertex<Integer>, Integer> dijkstraShortestPath(Graph<Integer> graph, Vertex<Integer> source) {
        MinHeap<Vertex<Integer>> minHeap = new MinHeap<>();
        Map<Vertex<Integer>, Integer> distance = new TreeMap<>(Comparator.comparing(v -> v.getId()));
        Map<Vertex<Integer>, Vertex<Integer>> parent = new HashMap<>();

        // initialize the distance of all the vertices to infinity
        for (Vertex<Integer> vertex : graph.getAllVertices()) {
            minHeap.add(Integer.MAX_VALUE, vertex);
        }
        // update the source distance to 0

        minHeap.decrease(source, 0);
        distance.put(source, 0);
        //parent of source vertex will be null
        parent.put(source, null);

        while (!minHeap.empty()) {

            MinHeap<Vertex<Integer>>.Node node = minHeap.extractMinNode();
            Vertex<Integer> currentVertex = node.key;
            distance.put(currentVertex, node.weight);

            for (Edge<Integer> adjEdge : currentVertex.getEdges()) {
                Vertex<Integer> otherVertex = getOtherVertex(adjEdge, currentVertex);

                if (!minHeap.containsData(otherVertex))
                    continue;

                int newDistance = distance.get(currentVertex) + adjEdge.getWeight();
                if (newDistance < minHeap.getWeight(otherVertex)) {
                    minHeap.decrease(otherVertex, newDistance);
                    parent.put(otherVertex, currentVertex);
                }
            }

        }
        return distance;
    }

    private static Vertex<Integer> getOtherVertex(Edge<Integer> adjEdge, Vertex<Integer> vertex) {
        return adjEdge.getVertex1().equals(vertex) ? adjEdge.getVertex2() : adjEdge.getVertex1();
    }

    static class Graph<T> {

        private final Map<Integer, Vertex<T>> allVertices;
        private final List<Edge<T>> allEdges;
        private final boolean isDirected;

        public Graph(boolean isDirected) {
            this.allVertices = new HashMap<>();
            this.allEdges = new ArrayList<>();
            this.isDirected = isDirected;
        }

        public void addEdge(int id1, int id2) {
            addEdge(id1, id2, 0);
        }

        public void addSingleVertex(int id) {
            if (!allVertices.containsKey(id)) {
                Vertex<T> vertex = new Vertex<T>(id);
                allVertices.put(id, vertex);
            }
        }

        public void addEdge(int id1, int id2, int wgt) {

            Vertex<T> vertex1 = null;
            if (allVertices.containsKey(id1)) {
                vertex1 = allVertices.get(id1);
            } else {
                vertex1 = new Vertex<T>(id1);
                allVertices.put(id1, vertex1);
            }

            Vertex<T> vertex2 = null;
            if (allVertices.containsKey(id2)) {
                vertex2 = allVertices.get(id2);
            } else {
                vertex2 = new Vertex<T>(id2);
                allVertices.put(id2, vertex2);
            }

            Edge<T> edge = new Edge<T>(vertex1, vertex2, wgt, isDirected);
            allEdges.add(edge);

            vertex1.addAdjVertex(vertex2, edge);

            if (!isDirected) {
                vertex2.addAdjVertex(vertex1, edge);
            }
        }

        public void addEdge(Vertex<T> vertex1, Vertex<T> vertex2, int wgt) {
            if (allVertices.containsKey(vertex1.getId())) {
                vertex1 = allVertices.get(vertex1.getId());
            }

            if (allVertices.containsKey(vertex2.getId())) {
                vertex2 = allVertices.get(vertex2.getId());
            }
            Edge<T> edge = new Edge<T>(vertex1, vertex2, wgt, isDirected);
            allEdges.add(edge);

            vertex1.addAdjVertex(vertex2, edge);

            if (!isDirected) {
                vertex2.addAdjVertex(vertex1, edge);
            }
        }

        public void setDataForVertex(int id, T data) {
            if (allVertices.containsKey(id)) {
                allVertices.get(id).setData(data);
            }
        }

        public List<Edge<T>> getAllEdges() {
            return allEdges;
        }

        public Vertex<T> getVertex(int id) {
            return allVertices.get(id);
        }

        public Collection<Vertex<T>> getAllVertices() {
            return allVertices.values();
        }

    }

    static class Vertex<T> {
        private int id;
        private T data;
        private List<Vertex<T>> adjacentVertices = new ArrayList<>();
        private List<Edge<T>> edges = new ArrayList<>();

        public Vertex(int id) {
            this.id = id;
        }

        public Vertex(int id, T data) {
            this.id = id;
            this.data = data;
        }

        public int getId() {
            return id;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public List<Vertex<T>> getAdjacentVertices() {
            return adjacentVertices;
        }

        public List<Edge<T>> getEdges() {
            return edges;
        }

        public int getDegree() {
            return edges.size();
        }

        public void addAdjVertex(Vertex<T> vertex, Edge<T> edge) {
            adjacentVertices.add(vertex);
            // a pair of vertex can have multiple edges
            edges.add(edge);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof Vertex))
                return false;

            Vertex<?> vertex = (Vertex<?>) o;

            if (id != vertex.id)
                return false;
            if (data != null ? !data.equals(vertex.data) : vertex.data != null)
                return false;
            if (adjacentVertices != null ? !adjacentVertices.equals(vertex.adjacentVertices) : vertex.adjacentVertices != null)
                return false;
            return edges != null ? edges.equals(vertex.edges) : vertex.edges == null;

        }

        @Override
        public int hashCode() {
            int result = id;
            result = 31 * result + (result ^ (result >>> 32));
            return result;
        }

        @Override
        public String toString() {
            return "Vertex{" + "id=" + id + ", data=" + data + '}';
        }
    }

    static class Edge<T> {
        private Vertex<T> vertex1;
        private Vertex<T> vertex2;
        private int weight;
        private boolean isDirected;

        public Edge(Vertex<T> vertex1, Vertex<T> vertex2, int weight, boolean isDirected) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.weight = weight;
            this.isDirected = isDirected;
        }

        public Vertex<T> getVertex1() {
            return vertex1;
        }

        public Vertex<T> getVertex2() {
            return vertex2;
        }

        public int getWeight() {
            return weight;
        }

        public boolean isDirected() {
            return isDirected;
        }

        @Override
        public String toString() {
            return "Edge{" + "vertex1=" + vertex1 + ", vertex2=" + vertex2 + ", weight=" + weight + ", isDirected=" + isDirected + '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (!(o instanceof Edge))
                return false;

            Edge<?> edge = (Edge<?>) o;

            if (weight != edge.weight)
                return false;
            if (isDirected != edge.isDirected)
                return false;
            if (!vertex1.equals(edge.vertex1))
                return false;
            return vertex2.equals(edge.vertex2);

        }

        @Override
        public int hashCode() {
            int result = vertex1.hashCode();
            result = 31 * result + (result ^ (result >>> 32));
            return result;
        }
    }

    static class MinHeap<T> {

        private List<Node> allNodes = new ArrayList<>();
        private Map<T,Integer> nodePosition = new HashMap<>();

        public class Node {
            int weight;
            T key;
        }

        /**
         * Checks where the key exists in heap or not
         */
        public boolean containsData(T key){
            return nodePosition.containsKey(key);
        }

        /**
         * Add key and its weight to they heap
         */
        public void add(int weight,T key) {
            Node node = new Node();
            node.weight = weight;
            node.key = key;
            allNodes.add(node);
            int size = allNodes.size();
            int current = size - 1;
            int parentIndex = (current - 1) / 2;
            nodePosition.put(node.key, current);

            while (parentIndex >= 0) {
                Node parentNode = allNodes.get(parentIndex);
                Node currentNode = allNodes.get(current);
                if (parentNode.weight > currentNode.weight) {
                    swap(parentNode,currentNode);
                    updatePositionMap(parentNode.key,currentNode.key,parentIndex,current);
                    current = parentIndex;
                    parentIndex = (parentIndex - 1) / 2;
                } else {
                    break;
                }
            }
        }

        /**
         * Get the heap min without extracting the key
         */
        public T min(){
            return allNodes.get(0).key;
        }

        /**
         * Checks with heap is empty or not
         */
        public boolean empty(){
            return allNodes.size() == 0;
        }

        /**
         * Decreases the weight of given key to newWeight
         */
        public void decrease(T data, int newWeight){
            Integer position = nodePosition.get(data);
            allNodes.get(position).weight = newWeight;
            int parent = (position -1 )/2;
            while(parent >= 0){
                if(allNodes.get(parent).weight > allNodes.get(position).weight){
                    swap(allNodes.get(parent), allNodes.get(position));
                    updatePositionMap(allNodes.get(parent).key,allNodes.get(position).key,parent,position);
                    position = parent;
                    parent = (parent-1)/2;
                }else{
                    break;
                }
            }
        }

        /**
         * Get the weight of given key
         */
        public Integer getWeight(T key) {
            Integer position = nodePosition.get(key);
            if( position == null ) {
                return null;
            } else {
                return allNodes.get(position).weight;
            }
        }

        /**
         * Returns the min node of the heap
         */
        public Node extractMinNode() {
            int size = allNodes.size() -1;
            Node minNode = new Node();
            minNode.key = allNodes.get(0).key;
            minNode.weight = allNodes.get(0).weight;

            int lastNodeWeight = allNodes.get(size).weight;
            allNodes.get(0).weight = lastNodeWeight;
            allNodes.get(0).key = allNodes.get(size).key;
            nodePosition.remove(minNode.key);
            nodePosition.remove(allNodes.get(0));
            nodePosition.put(allNodes.get(0).key, 0);
            allNodes.remove(size);

            int currentIndex = 0;
            size--;
            while(true){
                int left = 2*currentIndex + 1;
                int right = 2*currentIndex + 2;
                if(left > size){
                    break;
                }
                if(right > size){
                    right = left;
                }
                int smallerIndex = allNodes.get(left).weight <= allNodes.get(right).weight ? left : right;
                if(allNodes.get(currentIndex).weight > allNodes.get(smallerIndex).weight){
                    swap(allNodes.get(currentIndex), allNodes.get(smallerIndex));
                    updatePositionMap(allNodes.get(currentIndex).key,allNodes.get(smallerIndex).key,currentIndex,smallerIndex);
                    currentIndex = smallerIndex;
                }else{
                    break;
                }
            }
            return minNode;
        }
        /**
         * Extract min value key from the heap
         */
        public T extractMin(){
            Node node = extractMinNode();
            return node.key;
        }

        private void printPositionMap(){
            System.out.println(nodePosition);
        }

        private void swap(Node node1,Node node2){
            int weight = node1.weight;
            T data = node1.key;

            node1.key = node2.key;
            node1.weight = node2.weight;

            node2.key = data;
            node2.weight = weight;
        }

        private void updatePositionMap(T data1, T data2, int pos1, int pos2){
            nodePosition.remove(data1);
            nodePosition.remove(data2);
            nodePosition.put(data1, pos1);
            nodePosition.put(data2, pos2);
        }

        public void printHeap(){
            for(Node n : allNodes){
                System.out.println(n.weight + " " + n.key);
            }
        }

    }
}
