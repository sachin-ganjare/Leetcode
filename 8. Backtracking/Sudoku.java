class Sudoku {
    boolean solveSudoku(int sudoku[][], int i, int j) {
        if(i == 9) return true; // if all rows are traversed, return true -- end of sudoku

        int nextI = i, nextJ = j + 1; // usually traverse all the columns of single row first.
        
        // if whole one row is traversed i.e. column's end is reached, jump to the next row.
        if(nextJ == 9) {
            nextI = i + 1;
            nextJ = 0;
        }

        // when number is already placed in sudoku, go to next column/row.
        if(sudoku[i][j] != 0) {
            return solveSudoku(sudoku, nextI, nextJ);
        }

        // check if sudoku is safe for each number ranging from 1 to 9.
        for(int n = 1; n <= 9; n++) {
            if(isSafe(sudoku, i, j, n)) {
                sudoku[i][j] = n; // place the number
                // check if the sudoku can be solved for next row/column.
                if(solveSudoku(sudoku, nextI, nextJ)) {
                    return true;
                }
                sudoku[i][j] = 0; // backtrack, if sudoku can't be solved for next row/column for given number n.
            }
        }
        return false;
    }

    static void printSudoku(int sudoku[][]) {
        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }
    }

    boolean isSafe(int sudoku[][], int row, int col, int n) {
        // check in row.
        for(int j = 0; j < 9; j++) {
            if(sudoku[row][j] == n) {
                return false;
            }
        }
        // check in column.
        for(int i = 0; i < 9; i++) {
            if(sudoku[i][col] == n) {
                return false;
            }
        }

        // check in grid
        int sx = (row / 3) * 3;
        int sy = (col / 3) * 3;
        for(int i = sx; i < sx + 3; i++) {
            for(int j = sy; j < sy + 3; j++) {
                if(sudoku[i][j] == n) {
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        int sudoku[][] = {
            {3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0},
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

        Sudoku solver = new Sudoku();

        System.out.println("Original Sudoku:");
        printSudoku(sudoku);

        if(solver.solveSudoku(sudoku, 0, 0)) {
            System.out.println("\nSolved Sudoku:");
            printSudoku(sudoku);
        } else {
            System.out.println("No solution exists for the given Sudoku.");
        }
    }
}