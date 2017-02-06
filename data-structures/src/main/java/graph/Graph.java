package graph;

import java.util.*;

/**
 * Created by liju on 2/2/17.
 *
 * Below is edge list representation of graph in the form of G = |u,v| set of vertices and set of edges
 *
 * Other representations are : Adjacency matrix and Adjacency list
 */
public class Graph<T> {

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

    public static void main(String[] args) {
        Graph<Integer> graph = new Graph<>(false);

        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);
        graph.addEdge(7, 0);
        graph.addEdge(1, 7);
        graph.addEdge(7, 8);
        graph.addEdge(2, 8);
        graph.addEdge(6, 8);
        graph.addEdge(2, 5);
        graph.addEdge(3, 5);

        for (Edge<Integer> edge : graph.getAllEdges()) {
            System.out.println(edge);
        }
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
        if (!adjacentVertices.contains(vertex)) {
            adjacentVertices.add(vertex);
            edges.add(edge);
        }
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