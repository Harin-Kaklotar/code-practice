package graph;

import java.util.*;

/**
 * Created by liju on 2/6/17.
 *
 * https://www.hackerrank.com/challenges/primsmstsub
 */
public class PrimsMST {

    public static void main(String[] args) {

        Graph<Integer> graph = new Graph<>(false);

        Scanner sc = new Scanner(System.in);
        final int nodes = sc.nextInt();
        final int edges = sc.nextInt();

        for (int i = 0; i < edges; i++) {
            graph.addEdge(sc.nextInt(), sc.nextInt(), sc.nextInt());
        }
        // ignore starting node
        final int startNodeId = sc.nextInt();

        final List<Edge<Integer>> mstEdges = primsMST(graph,startNodeId);
        long sumOfEdgeWgt =0;
        for (Edge<Integer> mstEdge : mstEdges) {
            sumOfEdgeWgt += mstEdge.getWeight();
        }
        System.out.println(sumOfEdgeWgt);
    }

    private static List<Edge<Integer>> primsMST(Graph<Integer> graph, int startNode){
        final MinHeap<Vertex<Integer>> heap = new MinHeap();
        final List<Edge<Integer>> mstEdges = new ArrayList<>();
        final Map<Vertex<Integer>, Edge<Integer>> vertexToEdge = new HashMap<>();
        
        //initialize the distance to all vertex to infinite
        for (Vertex<Integer> vertex : graph.getAllVertices()) {
            heap.add(Integer.MAX_VALUE,vertex);
        }

        //set the distance to startVertex to 0 , so that it is picked up first
        heap.decrease(graph.getVertex(startNode), 0);
        
        while (!heap.empty()){
            // extract the min distance vertex from the heap
            final Vertex<Integer> vertex = heap.extractMin();

            // if this vertex has an edge , pick that edge and include in the final mst
            // for the first vertex it won't have edge
            if (vertexToEdge.containsKey(vertex)){
                mstEdges.add(vertexToEdge.get(vertex));
            }

            // get all the adjacent edges of the current vertex
            for (Edge<Integer> edge : vertex.getEdges()) {
                
                Vertex<Integer> otherVertex = getOtherVertex(edge,vertex);
                if (heap.containsData(otherVertex) && heap.getWeight(otherVertex) > edge.getWeight()){
                    heap.decrease(otherVertex, edge.getWeight());
                    vertexToEdge.put(otherVertex, edge);
                }
            }

        }
        return mstEdges;
    }

    private static Vertex<Integer> getOtherVertex(Edge<Integer> edge, Vertex<Integer> vertex) {
        return edge.getVertex1().equals(vertex) ? edge.getVertex2() : edge.getVertex1();
    }

}

class Graph<T> {

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

class Vertex<T> {
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
        //one pair of vertex can have multiple edges
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

class Edge<T> {
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

/**
 * Created by liju on 2/2/17.
 *
 * Data structure to support following operations
 * extracMin - O(logn)
 * addToHeap - O(logn)
 * containsKey - O(1)
 * decreaseKey - O(logn)
 * getKeyWeight - O(1)
 *
 * It is a combination of binary heap and hash map
 *
 */
class MinHeap<T> {

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
