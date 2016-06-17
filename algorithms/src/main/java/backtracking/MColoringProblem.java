package backtracking;

/**
 * Created by liju on 6/16/16.
 * Given an undirected graph and a number m, determine if the graph can be colored with at most m colors such that no two adjacent vertices of the graph are colored with same color. Here coloring of a graph means assignment of colors to all vertices.

 Input:
 1) A 2D array graph[V][V] where V is the number of vertices in graph and graph[V][V] is adjacency matrix representation of the graph. A value graph[i][j] is 1 if there is a direct edge from i to j, otherwise graph[i][j] is 0.
 2) An integer m which is maximum number of colors that can be used.

 Output:
 An array color[V] that should have numbers from 1 to m. color[i] should represent the color assigned to the ith vertex. The code should also return false if the graph cannot be colored with m colors.

 Ref  - http://www.geeksforgeeks.org/backttracking-set-5-m-coloring-problem/
 */
public class MColoringProblem {


    public boolean color(int[][] graph, int[] coloredVertices, int vertex, int totalColors) {

        if (allVerticesColored(coloredVertices)) {
            return true;
        }

        for (int i = 0; i < totalColors; i++) {

            if (isSafeColor(graph, coloredVertices, vertex, i)) {
                // color this vertex
                coloredVertices[vertex] = i;

                // move to color next vertex
                if (color(graph, coloredVertices, vertex + 1, totalColors)) {
                    return true;
                }

                // reset as un-colored
                coloredVertices[vertex] = -1;
            }
        }
        return false;

    }

    private boolean isSafeColor(int[][] graph, int[] coloredVertices, int vertex, int color) {
        for (int j = 0; j < graph.length; j++) {
            //check if any connecting vertex is already colored with the given color
            if (graph[vertex][j]==1 && coloredVertices[j]==color){
                return false;
            }
        }
        return true;
    }

    private boolean allVerticesColored(int[] coloredVertices) {
        for (int i = 0; i < coloredVertices.length; i++) {
            if (coloredVertices[i]==-1){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MColoringProblem mColoringProblem = new MColoringProblem();

         /* Create following graph and test whether it is
           3 colorable
          (3)---(2)
           |   / |
           |  /  |
           | /   |
          (0)---(1)
        */
        int graph[][] = {{0, 1, 1, 1},
                        {1, 0, 1, 0},
                        {1, 1, 0, 1},
                        {1, 0, 1, 0},
        };
        int m = 3; // Number of colors

        int[] coloredVertices ={-1,-1,-1,-1};

        if(mColoringProblem.color(graph,coloredVertices,0,m)){
            System.out.println("Given graph can be colored using "+m +"colors");
            printColoredVertice(coloredVertices);
        }else{
            System.out.println("Given graph cannot be colored using "+m +"colors");
        }
    }

    private static void printColoredVertice(int[] coloredVertices) {

        for (int i = 0; i < coloredVertices.length; i++) {
            System.out.print(coloredVertices[i] + "\t");
        }
    }
}
