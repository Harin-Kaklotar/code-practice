package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by liju on 9/10/17.
 * <p>
 * https://www.hackerrank.com/challenges/dijkstrashortreach/problem
 * - same as previous DisjkstraShortestPath1
 */
public class DisjkstraShortestPath2 {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new
                    InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public static void main(String[] args) throws IOException {

        FastReader sc = new FastReader();

        int q = sc.nextInt();

        for (int i = 0; i < q; i++) {

            int nodes = sc.nextInt();
            int edges = sc.nextInt();

            Graph<Integer> graph = new Graph(false);
            for (int j = 1; j <= nodes; j++) {
                graph.addSingleVertex(j);
            }
            for (int j = 0; j < edges; j++) {

                graph.addEdge(sc.nextInt(), sc.nextInt(), sc.nextInt());
            }

            int sourceId = sc.nextInt();

            Map<Vertex<Integer>, Integer> vertexIntegerMap = dijkstrasAlgo(graph, sourceId);

            vertexIntegerMap.remove(graph.allVertices.get(sourceId));

            vertexIntegerMap.values().stream().forEach(x -> System.out.print((x != Integer.MAX_VALUE ? x + " " : "-1 ")));

            System.out.println("");
        }
    }

    public static Map<Vertex<Integer>, Integer> dijkstrasAlgo(Graph<Integer> graph, int sourceVertexId) {

        Map<Vertex<Integer>, Integer> distance = new TreeMap<>(Comparator.comparing(Vertex::getId));
        Map<Vertex<Integer>, Vertex<Integer>> parent = new HashMap<>();

        //Comparator<Vertex<Integer>> vertexComparator = (Vertex<Integer> v1, Vertex<Integer> v2) -> v1.getData()-v2.getData();
        PriorityQueue<Vertex<Integer>> pq = new PriorityQueue(Comparator.<Vertex<Integer>>comparingInt(Vertex::getData));

        // set distance of all vertices to infinity
        for (Vertex<Integer> vertex : graph.allVertices.values()) {
            vertex.setData(Integer.MAX_VALUE);
            pq.offer(vertex);
        }

        //set the distance to source = 0
        Vertex<Integer> source = graph.allVertices.get(sourceVertexId);
        pq.remove(source);
        source.setData(0);
        pq.offer(source);

        distance.put(source, 0);
        parent.put(source, null);

        while (!pq.isEmpty()) {
            Vertex<Integer> current = pq.poll();

            distance.put(current, current.getData());
            //explore all adjacent edges
            for (Edge<Integer> edge : current.getEdges()) {
                Vertex<Integer> otherVertex = edge.getOtherVertex(current);

                //if the vertex is not in the heap , it means its shortest distance from source is already found
                if (!pq.contains(otherVertex)) continue;

                //if current node is reachable from source then only check the adj edge
                if (distance.get(current) != Integer.MAX_VALUE) {
                    int newDistance = distance.get(current) + edge.getWgt();

                    if (newDistance < otherVertex.getData()) {
                        pq.remove(otherVertex);
                        otherVertex.setData(newDistance);
                        pq.offer(otherVertex);

                        parent.put(otherVertex, current);
                    }
                }
            }
        }
        return distance;
    }


    static class Graph<T> {

        private List<Edge<T>> allEdges = new ArrayList<>();
        private Map<Integer, Vertex<T>> allVertices = new HashMap<>();
        private boolean isDirected;

        //mataining a edge map to avoid duplicate edges
        private Map<Edge<T>, Integer> edgeWgtMap = new HashMap<>();

        public Graph(boolean isDirected) {
            this.isDirected = isDirected;
        }

        public void addSingleVertex(int id) {
            if (!allVertices.containsKey(id))
                allVertices.put(id, new Vertex<T>(id));
        }

        public void setDataForVertex(int id, T data) {
            if (allVertices.containsKey(id))
                allVertices.get(id).setData(data);
        }

        public void addEdge(Vertex<T> vertex1, Vertex<T> vertex2, int wgt) {

            if (allVertices.containsKey(vertex1.getId())) {
                vertex1 = allVertices.get(vertex1.getId());
            }
            if (allVertices.containsKey(vertex2.getId())) {
                vertex2 = allVertices.get(vertex2.getId());
            }
            Edge<T> newEdge = new Edge<>(vertex1, vertex2, wgt, isDirected);
            //avoid duplicate edge and edge with more wgt
            if (!edgeWgtMap.containsKey(newEdge) || wgt < edgeWgtMap.get(newEdge)) {
                edgeWgtMap.put(newEdge, wgt);
                vertex1.addAdjVertex(newEdge, vertex2);
                if (!isDirected) {
                    vertex2.addAdjVertex(newEdge, vertex1);
                }
                allEdges.add(newEdge);
            }
        }

        public void addEdge(int id1, int id2, int wgt) {

            Vertex<T> vertex1;
            Vertex<T> vertex2;

            if (allVertices.containsKey(id1))
                vertex1 = allVertices.get(id1);
            else {
                vertex1 = new Vertex<T>(id1);
                allVertices.put(id1, vertex1);
            }

            if (allVertices.containsKey(id2))
                vertex2 = allVertices.get(id2);
            else {
                vertex2 = new Vertex<T>(id2);
                allVertices.put(id2, vertex2);
            }

            addEdge(vertex1, vertex2, wgt);

        }

    }

    static class Vertex<T> {
        private Integer id;
        private T data;
        private Set<Vertex<T>> adjacentVertices = new HashSet<>();
        private List<Edge<T>> edges = new ArrayList<>();

        public Vertex(int id) {
            this.id = id;
        }

        public Vertex(int id, T data) {
            this.id = id;
            this.data = data;
        }

        public void addAdjVertex(Edge<T> edge, Vertex<T> adjVertex) {
            adjacentVertices.add(adjVertex);
            edges.add(edge);
        }

        public Integer getId() {
            return id;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Set<Vertex<T>> getAdjacentVertices() {
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
            result = 31 * result + (result ^ (result >>> 32));
            return result;
        }
    }

    static class Edge<T> {
        Vertex<T> vertex1;
        Vertex<T> vertex2;
        int wgt;
        boolean isDirected;

        public Edge(Vertex<T> vertex1, Vertex<T> vertex2, int wgt, boolean isDirected) {
            this.vertex1 = vertex1;
            this.vertex2 = vertex2;
            this.wgt = wgt;
            this.isDirected = isDirected;
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

        public Vertex<T> getOtherVertex(Vertex<T> vertex) {
            if (vertex.equals(vertex1)) return vertex2;
            if (vertex.equals(vertex2)) return vertex1;
            throw new IllegalArgumentException("not a vertex for this edge");
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


