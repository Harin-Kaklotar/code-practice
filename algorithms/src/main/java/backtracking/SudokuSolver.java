package backtracking;

/**
 * Created by liju on 6/15/16.
 * Solving sodoku , usual sodoku rules
 *
 * Eg. solve given soduku
 *
 {3, 0, 6, 5, 0, 8, 4, 0, 0},
 {5, 2, 0, 0, 0, 0, 0, 0, 0},
 {0, 8, 7, 0, 0, 0, 0, 3, 1},
 {0, 0, 3, 0, 1, 0, 0, 8, 0},
 {9, 0, 0, 8, 6, 3, 0, 0, 5},
 {0, 5, 0, 0, 9, 0, 6, 0, 0},
 {1, 3, 0, 0, 0, 0, 2, 5, 0},
 {0, 0, 0, 0, 0, 0, 0, 7, 4},
 {0, 0, 5, 2, 0, 6, 3, 0, 0}}
 *
 *
 */
public class SudokuSolver {
    class Point{
        Point(int x, int y){
            this.x=x;
            this.y=y;
        }
        int x,y;
    }

    public boolean isSolved(int[][] sudoku){
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                if (sudoku[i][j]==0){
                    return false; // still unsolved as some have 0 value
                }
            }
        }
        return true;// solved as no block with 0 value
    }

    private Point getUnassignedPoint(int[][] sudoku) {
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                if (sudoku[i][j]==0){
                    return new Point(i,j);
                }
            }
        }
        return null;
    }

    private boolean isSafe(int[][] sudoku, int number, int x, int y) {
        //check safe in column-wise for the given row
        for (int i = 0; i < sudoku.length; i++) {
            if (sudoku[x][i]==number)
                return false;
        }

        //check safe in row-wise for the given column
        for (int i = 0; i < sudoku.length; i++) {
            if (sudoku[i][y]==number)
                return false;
        }
        
        //check for the given box ( 3 X 3)
        int startX = x-x%3;
        int startY = y-y%3;
        for (int i =startX ; i < startX+3; i++) {
            for (int j = startY; j < startY + 3 ; j++) {
                if (sudoku[i][j]==number){
                    return false;
                }
            }
        }

        return true;
    }

    public boolean solveSudoku(int[][] sudoku){
        if (isSolved(sudoku)){
            return true;
        }else{
            Point point = getUnassignedPoint(sudoku);

            //assign one of the 1-9 numbers
            for (int i = 1; i <= 9; i++) {
                if (isSafe(sudoku,i,point.x,point.y)){
                    sudoku[point.x][point.y] = i;
                    if(solveSudoku(sudoku)){
                        return true;
                    }
                    sudoku[point.x][point.y] = 0;//reset as it is not safe
                }
            }
            return false;// bracktrack
        }
    }

    public static void main(String[] args) {
        SudokuSolver sudokuSolver = new SudokuSolver();

        int[][] sudoku  ={   {3, 0, 6, 5, 0, 8, 4, 0, 0},
                             {5, 2, 0, 0, 0, 0, 0, 0, 0},
                             {0, 8, 7, 0, 0, 0, 0, 3, 1},
                             {0, 0, 3, 0, 1, 0, 0, 8, 0},
                             {9, 0, 0, 8, 6, 3, 0, 0, 5},
                             {0, 5, 0, 0, 9, 0, 6, 0, 0},
                             {1, 3, 0, 0, 0, 0, 2, 5, 0},
                             {0, 0, 0, 0, 0, 0, 0, 7, 4},
                             {0, 0, 5, 2, 0, 6, 3, 0, 0}
                            };


        if(sudokuSolver.solveSudoku(sudoku)){
            System.out.println("Solution exists");
        }else {
            System.out.println("Solution doesn't exists");
        }

        //print

        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {

                System.out.print(sudoku[i][j] + "\t");
            }
            System.out.print("\n");
        }

    }

}
