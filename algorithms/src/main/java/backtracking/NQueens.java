package backtracking;

/**
 * Created by liju on 6/13/16.
 * The N Queen is the problem of placing N chess queens on an N×N chessboard so that no two queens attack each other.
 * For example, following is a solution for 4 Queen problem.
 *
 { 0,  1,  0,  0}
 { 0,  0,  0,  1}
 { 1,  0,  0,  0}
 { 0,  0,  1,  0}

 Ref - http://www.geeksforgeeks.org/backtracking-set-3-n-queen-problem/
 */
public class NQueens {

    public boolean isSafeMove(int[][] soln, int N, int x, int y) {

        if (x < 0 || x >= N || y < 0 || y >= N) {
            return false;
        }

        // check all columns for a row
        for (int i = 0; i < N; i++) {
            if (soln[x][i] != 0) {
                return false;
            }
        }
        // check all rows for a column
        for (int i = 0; i < N; i++) {
            if (soln[i][y] != 0) {
                return false;
            }
        }

        // right-down diagonal
        for (int i = x, j = y; i < N && j < N; i++, j++) {
            if (soln[i][j] != 0) {
                return false;
            }
        }

        // right-up diagonal
        for (int i = x, j = y; i < N && j >= 0; i++, j--) {
            if (soln[i][j] != 0) {
                return false;
            }
        }

        // left-up diagonal
        for (int i = x, j = y; i >= 0 && j >= 0; i--, j--) {
            if (soln[i][j] != 0) {
                return false;
            }
        }

        // left-down diagonal
        for (int i = x, j = y; i >= 0 && j < N; i--, j++) {
            if (soln[i][j] != 0) {
                return false;
            }
        }

        return true;

    }

    public boolean nQueen(int[][] soln, int queenNo) {

        if (soln.length == queenNo)
            return true;

        // try to place one queen on the given row (one queen , one row)
        for (int i = 0; i < soln.length; i++) {

            if (isSafeMove(soln, soln.length, queenNo, i)) {
                soln[queenNo][i] = queenNo + 1;

                if (nQueen(soln, queenNo + 1)) {
                    return true;
                }
                // if none of these move lead to solution then backtrack
                // reset as unvisited
                soln[queenNo][i] = 0;
            }
        }
        /* If queen can not be place in any column in this row , then return false */
        return false;
    }

    public static void main(String[] args) {
        int N = 4;
        int[][] board = new int[N][N];

        NQueens nQueens = new NQueens();

        boolean solutionExists = false;
        for (int i = 0; i < N; i++) {
            solutionExists = nQueens.nQueen(board, 0);
            if (solutionExists) {
                System.out.println("Solution exists");
                break;
            }
        }

        // print solution
        if (solutionExists) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(board[i][j] + " \t");
                }
                System.out.print("\n");
            }
        } else {
            System.out.println("Solution doesn't exists");
        }
    }
}
