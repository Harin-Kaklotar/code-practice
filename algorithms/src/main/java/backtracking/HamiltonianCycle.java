package backtracking;

/**
 * Created by liju on 6/15/16.
 * Hamiltonian Path in an undirected graph is a path that visits each vertex exactly once.
 * A Hamiltonian cycle (or Hamiltonian circuit) is a Hamiltonian Path such that there is an edge (in graph) from the last vertex
 * to the first vertex of the Hamiltonian Path. Determine whether a given graph contains Hamiltonian Cycle or not. If it contains,
 * then print the path. Following are the input and output of the required function.

 Input:
 A 2D array graph[V][V] where V is the number of vertices in graph and graph[V][V] is adjacency matrix representation of the graph. A value graph[i][j] is 1 if there is a direct edge from i to j, otherwise graph[i][j] is 0.

 Output:
 An array path[V] that should contain the Hamiltonian Path. path[i] should represent the ith vertex in the Hamiltonian Path. The code should also return false if there is no Hamiltonian Cycle in the graph.

 Ref - http://www.geeksforgeeks.org/backtracking-set-7-hamiltonian-cycle/
 */
public class HamiltonianCycle {


    public boolean traverseGraph(int[][] graph,int[] path,int vertexCounter, int vertice){
        if (hCycleDetected(graph,path,vertice) ){
            return true;
        }

        for (int i = 0; i < graph.length; i++) {

            if (isSafeMove(graph,path,vertice,i) ){

                //add as visited
                path[vertexCounter] = i;


                if(traverseGraph(graph,path,vertexCounter+1,i)){
                    return  true;
                }
                path[vertexCounter] = -1;
            }
        }

        return false;//backtrack

    }


    public boolean isSafeMove(int[][] graph, int[] path, int verticeFrom, int verticeTo) {
        if (graph[verticeFrom][verticeTo] != 1) {
            return false;
        }
        for (int i = 0; i < path.length; i++) {
            if (path[i] == verticeTo) {
                return false;
            }
        }
        return true;
    }

    public boolean hCycleDetected(int[][] graph, int[] path, int vertice) {

        // check if all vertices are visited
        for (int i = 0; i < path.length; i++) {
            // contains un-visited node
            if (path[i] == -1) {
                return false;
            }
        }
        // check if there is an edge available from the last visited vertice to the the first vertice
        if (graph[vertice][path[0]] != 1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        /* Let us create the following graph - this contains multiple hamiltonian cycle
           (0)--(1)--(2)
            |   / \   |
            |  /   \  |
            | /     \ |
           (3)-------(4)    */
        int graph1[][] = {   {0, 1, 0, 1, 0},
                            {1, 0, 1, 1, 1},
                            {0, 1, 0, 0, 1},
                            {1, 1, 0, 0, 1},
                            {0, 1, 1, 1, 0},
        };

        /* Let us create the following graph -- this doesn't contain hamiltonian cycle
           (0)--(1)--(2)
            |   / \   |
            |  /   \  |
            | /     \ |
           (3)       (4)    */
        int graph2[][] = {{0, 1, 0, 1, 0},
            {1, 0, 1, 1, 1},
            {0, 1, 0, 0, 1},
            {1, 1, 0, 0, 0},
            {0, 1, 1, 0, 0},
        };

        int path[] ={-1,-1,-1,-1,-1};



        HamiltonianCycle hamiltonianCycle = new HamiltonianCycle();

        //start with a node as visited
        path[0] = 0;
        int vertexCounter = 1; //node 0 visited

        if (hamiltonianCycle.traverseGraph(graph1,path,vertexCounter,path[0])){
            System.out.println("Hamiltonian cycle exists for graph1");
            hamiltonianCycle.printPath(path);
        }else{
            System.out.println("Hamiltonian cycle doesn't exists for graph1");
        }


        if (hamiltonianCycle.traverseGraph(graph2,path,vertexCounter,path[0])){
            System.out.println("Hamiltonian cycle exists for graph2");
            hamiltonianCycle.printPath(path);
        }else{
            System.out.println("Hamiltonian cycle doesn't exists for graph2");
        }
    }

    public void printPath(int [] path){
        for (int i = 0; i < path.length; i++) {
            System.out.print(path[i]+"\t");
        }
        System.out.println("");
    }
}
