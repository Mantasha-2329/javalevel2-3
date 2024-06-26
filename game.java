import java.util.Scanner;
class game{
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
            char currentPlayer = 'X';
            boolean gameWon = false;
            
            do {
                
                displayBoard(board);
                System.out.print("Player " + currentPlayer + ", enter your move (row[1-3] column[1-3]): ");
                int row = scanner.nextInt() - 1;
                int col = scanner.nextInt() - 1;
                if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                    board[row][col] = currentPlayer;
                    if (checkWin(board, currentPlayer)) {
                        displayBoard(board);
                        System.out.println("Player " + currentPlayer + " wins!");
                        gameWon = true;
                    } else {
                        
                        if (checkDraw(board)) {
                            displayBoard(board);
                            System.out.println("It's a draw!");
                            break;
                        }
                        
                        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                    }
                } else {
                    System.out.println("Invalid move. Try again.");
                }
                
            } while (!gameWon);
        }
    }

    public static void displayBoard(char[][] board) {
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " | ");
            }
            System.out.println();
        }
    }

    public static boolean checkWin(char[][] board, char player) {
        
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) ||
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
           }
        
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) ||
            (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        } 
        }

        return false;
        
    }

    public static boolean checkDraw(char[][] board) {
        
        for (char[] row : board) {
            for (char cell : row) {
                if (cell == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}

