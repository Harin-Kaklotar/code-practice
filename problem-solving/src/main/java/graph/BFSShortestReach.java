package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by liju on 9/7/17.
 * https://www.hackerrank.com/challenges/bfsshortreach
 * hint  - Dijkstra's algo
 */
public class BFSShortestReach {



    class Graph<T>{

        private List<Edge<T>> allEdges = new ArrayList<>();
        private Map<Integer, Vertex<T>> allVertices = new HashMap<>();
        private boolean isDirected;

        public void addEdge(Vertex<T> vertex1,Vertex<T> vertex2,int wgt){

            if (allVertices.containsKey(vertex1.getId())){
                vertex1 = allVertices.get(vertex1.getId());
            }
            if (allVertices.containsKey(vertex2.getId())){
                vertex2 = allVertices.get(vertex2.getId());
            }
            allEdges.add(new Edge<T>(vertex1,vertex2,wgt,isDirected));
        }

        public void addEdge(int id1,int id2,int wgt){

            Vertex<T> vertex1;
            Vertex<T> vertex2;

            if (allVertices.containsKey(id1))
                vertex1 = allVertices.get(id1);
            else vertex1 = new Vertex<T>(id1);

            if (allVertices.containsKey(id2))
                vertex2 = allVertices.get(id2);
            else
                vertex2 = new Vertex<T>(id2);

            addEdge(vertex1,vertex2,wgt);

        }


    }

    class Vertex<T>{
        int id;
        T data;
        List<Vertex<T>> adjacentVertices = new ArrayList<>();
        List<Edge<T>> edges = new ArrayList<>();

        public Vertex(int id) {
            this.id = id;
        }

        public Vertex(int id, T data) {
            this.id = id;
            this.data = data;
        }

        public void addAdjVertex(Edge<T> edge,Vertex<T> adjVertex){
            adjacentVertices.add(adjVertex);
            edges.add(edge);
        }

        public int getId() {
            return id;
        }

        public T getData() {
            return data;
        }

        public List<Vertex<T>> getAdjacentVertices() {
            return adjacentVertices;
        }

        public List<Edge<T>> getEdges() {
            return edges;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Vertex<?> vertex = (Vertex<?>) o;

            if (id != vertex.id) return false;
            if (data != null ? !data.equals(vertex.data) : vertex.data != null) return false;
            if (adjacentVertices != null ? !adjacentVertices.equals(vertex.adjacentVertices) : vertex.adjacentVertices != null)
                return false;
            return edges != null ? edges.equals(vertex.edges) : vertex.edges == null;
        }

        @Override
        public int hashCode() {
            int result = id;
            result = 31 * result + (data != null ? data.hashCode() : 0);
            result = 31 * result + (adjacentVertices != null ? adjacentVertices.hashCode() : 0);
            result = 31 * result + (edges != null ? edges.hashCode() : 0);
            return result;
        }
    }

    class Edge<T> {
        Vertex<T> vertex1;
        Vertex<T> vertex2;
        int wgt;
        boolean isDirected;

        public Edge(Vertex<T> vertex1, Vertex<T> vertex2, int wgt, boolean isDirected) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.wgt = wgt;
            this.isDirected = isDirected;
            vertex1.addAdjVertex(this,vertex2);
            if (!isDirected){
                vertex2.addAdjVertex(this,vertex1);
            }
        }

        public Vertex<T> getVertex1() {
            return vertex1;
        }

        public Vertex<T> getVertex2() {
            return vertex2;
        }

        public int getWgt() {
            return wgt;
        }

        public boolean isDirected() {
            return isDirected;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Edge<?> edge = (Edge<?>) o;

            if (wgt != edge.wgt) return false;
            if (isDirected != edge.isDirected) return false;
            if (!vertex1.equals(edge.vertex1)) return false;
            return vertex2.equals(edge.vertex2);
        }

        @Override
        public int hashCode() {
            int result = vertex1.hashCode();
            result = 31 * result + vertex2.hashCode();
            result = 31 * result + wgt;
            result = 31 * result + (isDirected ? 1 : 0);
            return result;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "vertex1=" + vertex1 +
                    ", vertex2=" + vertex2 +
                    ", wgt=" + wgt +
                    ", isDirected=" + isDirected +
                    '}';
        }
    }
}
