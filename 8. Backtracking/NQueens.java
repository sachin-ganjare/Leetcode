class NQueens {

    static int countWays = 0;

    // by nQueens function, we dont need to check for checking downwards
    static boolean isSafe(char board[][], int row, int col) {
        // up
        for(int i = row - 1; i >= 0; i--) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }

        // up left diag
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
             if(board[i][j] == 'Q') {
                return false;
            }
        }
        
        // up right
        for(int i = row - 1, j = col + 1; i >= 0 && j < board[0].length; i--, j++) {
            if(board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    static void printBoard(char[][] board) {
        for(int i = 0; i < board.length; i++) {
                for(int j = 0; j < board[0].length; j++) {
                        System.out.print(board[i][j] + " ");
                };
                System.out.println();
            };
        System.out.println();
    }

    static void nQueens(char board[][], int row) {
        // base case, when row is last one + 1, print board and return
        if(row == board.length) {
            printBoard(board);
            countWays++;
            return;
        }

        // rows are outershell (the main call), columns are innershell.
        // we are checking column wise here.
        for(int j = 0; j < board[0].length; j++){
            if(isSafe(board, row, j)) {
                board[row][j] = 'Q';
                nQueens(board, row + 1); // if placing at that column is safe, then check for columsn of next row.
                board[row][j] = 'x'; // backtracking step, after checking if safe solution exist.
            }
        }
    }

    public static void main(String[] args) {
        int n = 5;
        char board[][] = new char[n][n];

        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                board[i][j] = 'x';
            }
        }

        nQueens(board, 0);
        System.out.println("Total no. of ways this problem can be solved: " + countWays);
    }
}