package backtracking;

/**
 * Created by liju on 6/13/16.
 * A Maze is given as N*N binary matrix of blocks where source block is the upper left most block i.e., maze[0][0] and destination block is lower rightmost block i.e., maze[N-1][N-1]. A rat starts from source and has to reach destination.
 * The rat can move only in two directions: forward and down.
 In the maze matrix, 0 means the block is dead end and 1 means the block can be used in the path from source to destination.
 Note that this is a simple version of the typical Maze problem. For example, a more complex version can be that the rat can
 move in 4 directions and a more complex version can be with limited number of moves.

 Following is binary matrix representation of the above maze.
 {1, 0, 0, 0}
 {1, 1, 0, 1}
 {0, 1, 0, 0}
 {1, 1, 1, 1}

 Following is the solution matrix (output of program) for the above input matrx.
 {1, 0, 0, 0}
 {1, 1, 0, 0}
 {0, 1, 0, 0}
 {0, 1, 1, 1}
 All entries in solution path are marked as 1.


 */
public class RatInAMaze {

    public boolean isValidMove(int[][] maze ,int x , int y) {
        return (x >=0 && x < maze.length) && (y >=0 && y < maze[maze.length-1].length) && (maze[x][y] == 1);
    }
    public boolean solveMaze(int[][] maze , int[][] solution,int x, int y){

        //if destination reached
        if (x==(maze.length-1) && y == (maze[maze.length-1].length-1)){
            solution[x][y] =1;
            return true;
        }

        if (isValidMove(maze,x,y)){

            solution[x][y] = 1;

            //move right
            if(solveMaze(maze,solution,x+1,y)){
                return  true;
            }

            //move down
            if (solveMaze(maze,solution,x,y+1)){
                return true;
            }

            //if destination not reached by the above moves then backtrack
            solution[x][y] = 0;
            return false;

        }
        return  false;

    }

    public static void main(String[] args) {
            int[][] maze  = {       {1, 0, 0, 0},
                                    {1, 1, 0, 1},
                                    {0, 1, 0, 0},
                                    {1, 1, 1, 1}
                };

            int[][] solution = {    {0, 0, 0, 0},
                                    {0, 0, 0, 0},
                                    {0, 0, 0, 0},
                                    {0, 0, 0, 0}
                };

        RatInAMaze ratInAMaze = new RatInAMaze();
        ratInAMaze.solveMaze(maze,solution,0,0);

        for (int i = 0; i < solution.length; i++) {
            for (int j = 0; j < solution[solution.length - 1].length; j++) {
                System.out.print(solution[i][j]);
            }
            System.out.println("\n");
        }
    }

}
