import java.util.Scanner;

public class NQueensWithPartialPlacement {

    public static void printBoard(int[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) {
                    System.out.print("Q ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    public static boolean isSafe(int[][] board, int row, int col, int n) {
        // Check the row on the left side
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1) {
                return false;
            }
        }

        // Check upper diagonal on the left side
        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        // Check lower diagonal on the left side
        for (int i = row, j = col; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    public static boolean solveNQueens(int[][] board, int col, int n) {
        if (col >= n) {
            return true; // All queens are placed
        }

        for (int i = 0; i < n; i++) {
            if (isSafe(board, i, col, n)) {
                board[i][col] = 1;

                if (solveNQueens(board, col + 1, n)) {
                    return true;
                }

                // If placing the queen at (i, col) doesn't lead to a solution, backtrack
                board[i][col] = 0;
            }
        }

        return false; // No solution exists
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of queens (N): ");
        int n = scanner.nextInt();
        
        int[][] board = new int[n][n];

        // Initialize the board with the first queen placed in the first column (0)
        board[0][0] = 1;
        
        boolean result = solveNQueens(board, 1, n);

        if (result) {
            System.out.println("Solution found:");
            printBoard(board);
        } else {
            System.out.println("No solution exists.");
        }
    }
}
