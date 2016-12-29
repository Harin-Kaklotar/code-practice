package queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by liju on 12/29/16.
 * https://www.hackerrank.com/challenges/castle-on-the-grid
 */
public class CastleOnGrid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            String line = sc.next();
            for (int j = 0; j < n; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        Cell start = new Cell(sc.nextInt(), sc.nextInt());
        Cell goal = new Cell(sc.nextInt(), sc.nextInt());


        boolean[][] visited = new boolean[n][n];
        int steps[][] = new int[n][n];
        Queue<Cell> queue = new LinkedList();

        queue.offer(start);
        steps[start.x][start.y] = 0;
        visited[start.x][start.y] = true;

        while (!queue.isEmpty()) {

            Cell cell = queue.poll();

            if (processNeighbours(cell.x, cell.y, grid, steps, visited, goal, queue)) break;
        }

        System.out.println(steps[goal.x][goal.y]);

    }

    private static boolean processNeighbours(int x, int y, char[][] grid, int[][] steps, boolean[][] visited, Cell goal, Queue<Cell> queue) {

        // move right
        for (int newY = y + 1; isLegalMove(x, newY, grid, visited); newY++) {
            steps[x][newY] = steps[x][y] + 1;
            visited[x][newY] = true;
            if (isGoalReached(x, newY, goal)) {
                return true;
            } else {
                queue.offer(new Cell(x, newY));
            }
        }
        // move left
        for (int newY = y - 1; isLegalMove(x, newY, grid, visited); newY--) {
            steps[x][newY] = steps[x][y] + 1;
            visited[x][newY] = true;
            if (isGoalReached(x, newY, goal)) {
                return true;
            } else {
                queue.offer(new Cell(x, newY));
            }
        }
        // move up
        for (int newX = x - 1; isLegalMove(newX, y, grid, visited); newX--) {
            steps[newX][y] = steps[x][y] + 1;
            visited[newX][y] = true;
            if (isGoalReached(newX, y, goal)) {
                return true;
            } else {
                queue.offer(new Cell(newX, y));
            }
        }
        // move down
        for (int newX = x + 1; isLegalMove(newX, y, grid, visited); newX++) {
            steps[newX][y] = steps[x][y] + 1;
            visited[newX][y] = true;
            if (isGoalReached(newX, y, goal)) {
                return true;
            } else {
                queue.offer(new Cell(newX, y));
            }
        }
        return false;
    }

    private static boolean isGoalReached(int x, int y, Cell goal) {
        return (x == goal.x && y == goal.y);
    }

    private static boolean isLegalMove(int x, int y, char[][] grid, boolean[][] visited) {
        return (x < grid.length && y < grid.length && x >= 0 && y >= 0 && !visited[x][y] && grid[x][y] == '.');
    }

    static class Cell {
        int x, y;

        public Cell(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
