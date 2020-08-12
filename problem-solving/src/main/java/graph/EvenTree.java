package graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by liju on 9/12/17.
 *
 * https://www.hackerrank.com/challenges/even-tree/problem
 */
public class EvenTree {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int nodes = sc.nextInt();
        int edges = sc.nextInt();

        Graph graph = new Graph(nodes);
        for (int i = 0; i < edges; i++) {
            graph.addEdge(sc.nextInt()-1,sc.nextInt()-1);
        }

        solve(graph,sc.nextInt()-1);


    }

    private static int solve(Graph graph, int root) {
        return 0;
    }


    static class Graph{
        private int V;
        private List<Integer> adjList[];

        public Graph(int v) {
            V = v;
            adjList = new LinkedList[V];
            for (int i = 0; i < V; i++) {
                adjList[i] = new LinkedList();
            }
        }

        public void addEdge(int id1,int id2){
            adjList[id1].add(id2);
            adjList[id2].add(id1);
        }
    }

}
