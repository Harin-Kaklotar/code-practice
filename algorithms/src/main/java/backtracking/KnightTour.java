package backtracking;

/**
 * Created by liju on 6/13/16.
 * The knight is placed on the first block of an empty board and, moving according to the rules of chess, must visit each square exactly once.
 *
 * Ref - http://www.geeksforgeeks.org/backtracking-set-1-the-knights-tour-problem/
 *
 * Backtracking is not the best solution for knights tour ( also it depends on the how we start the initial moves
 */
public class KnightTour {

    private int[] xMoves = { 2, 2, 1, 1, -1, -1, -2, -2 };
    private int[] yMoves = { -1, 1, -2, 2, 2, -2, -1, 1 };

    public boolean isValidMove(int[][] soln, int x, int y) {
        // valid if move within the board and square is unmarked
        return (x >= 0 && x < soln.length && y >= 0 && y < (soln[soln.length - 1].length) && soln[x][y] == 0);
    }

    public boolean solveKnightTour(int[][] soln, int x, int y, int counter) {

        if (counter == 65) {
            return true;
        }

        if (isValidMove(soln, x, y)) {
            soln[x][y] = counter;

            // move 1
            if (solveKnightTour(soln, x + xMoves[0], y + yMoves[0], counter + 1)) {
                return true;
            }
            // move 2
            if (solveKnightTour(soln, x + xMoves[1], y + yMoves[1], counter + 1)) {
                return true;
            }
            // move 3
            if (solveKnightTour(soln, x + xMoves[2], y + yMoves[2], counter + 1)) {
                return true;
            }
            // move 4
            if (solveKnightTour(soln, x + xMoves[3], y + yMoves[3], counter + 1)) {
                return true;
            }
            // move 5
            if (solveKnightTour(soln, x + xMoves[4], y + yMoves[4], counter + 1)) {
                return true;
            }
            // move 6
            if (solveKnightTour(soln, x + xMoves[5], y + yMoves[5], counter + 1)) {
                return true;
            }
            // move 7
            if (solveKnightTour(soln, x + xMoves[6], y + yMoves[6], counter + 1)) {
                return true;
            }
            // move 8
            if (solveKnightTour(soln, x + xMoves[7], y + yMoves[7], counter + 1)) {
                return true;
            }

            // if none of the above leads to solution then backtrack
            soln[x][y] = 0;// reset as un-visited

        }
        return false;

    }

    public static void main(String[] args) {
        int[][] board = new int[8][8]; // default 0 ( means not visited)

        KnightTour knightTour = new KnightTour();

        knightTour.solveKnightTour(board, 0, 0, 1);

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + "\t");
            }
            System.out.println("\n");
        }
    }
}
