import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TicTacToe {

    static char mark = 'X'; // 'X' - player's mark, 'O' - CPU's mark

    static int playerTurns = 0;
    static int cpuTurns = 0;
    static boolean gameOver = false;

    static char[][] gameBoard = { // the digits indicate the X and Y coordinates
            {' ', ' ', '1', ' ', '2', ' ', '3'}, // <<- X
            {'1', ' ', '_', '|', '_', '|', '_'},
            {'2', ' ', '-', '|', '-', '|', '-'},
            {'3', ' ', '¯', '|', '¯', '|', '¯'}
           // ^
           // ^
           // |
           //
           // Y
    };

    public static void main(String[] args) throws InterruptedException {
        drawGameBoard();

        while (!gameOver) {
            markPlacing(mark);
            gameOver = gameOver();
            drawGameBoard();
            mark = changePlayer();
        }
    }

    public static void drawGameBoard() {
        for (char[] chars : gameBoard) {
            for (int j = 0; j < gameBoard[0].length; j++) {
                System.out.print(chars[j]);
            }
            System.out.println();
        }
    }

    public static void markPlacing(char mark) throws InterruptedException {

        if (mark == 'X') {

            System.out.println("Your turn");
            int posX;
            int posY;
            Scanner sc = new Scanner(System.in);
            System.out.println("Select X coordinate of your mark: ");
            posX = sc.nextInt();
            System.out.println("Select Y coordinate of your mark: ");
            posY = sc.nextInt();
            gameBoard[posY][2 * posX] = 'X';
            playerTurns++;

        } else {

            System.out.println("CPU is thinking...");
            TimeUnit.SECONDS.sleep(3);

            Random random = new Random();
            int posX = random.nextInt(3) + 1;
            int posY = random.nextInt(3) + 1;

            while (true) {
                if (gameBoard[posY][2 * posX] == 'X' || gameBoard[posY][2 * posX] == 'O') {
                    posX = random.nextInt(3) + 1;
                    posY = random.nextInt(3) + 1;
                } else {
                    gameBoard[posY][2 * posX] = 'O';
                    cpuTurns++;
                    break;
                }
            }
        }
    }

    public static char changePlayer() {
        if (mark == 'X') {
            mark = 'O';
        } else {
            mark = 'X';
        }
        return mark;
    }

    public static boolean gameOver() {

        // game over if mark amount = 9
        if (playerTurns + cpuTurns == 9) {
            System.out.println("Game over");
            return true;
        }

        // game over if 3 same marks in a row, column or diagonal
        for (int i = 1; i <= 3; i++) {

            // check rows
            if (gameBoard[i][2] == mark && gameBoard[i][4] == mark && gameBoard[i][6] == mark) {
                System.out.println("\nGame over");
                System.out.println("Player with " + "'" + mark + "'" + " wins");
                return true;
                // check columns
            } else if (gameBoard[1][i * 2] == mark && gameBoard[2][i * 2] == mark && gameBoard[3][i * 2] == mark) {
                System.out.println("\nGame over");
                System.out.println("Player with " + "'" + mark + "'" + " wins");
                return true;
            }
        }

        // check diagonals
        if (gameBoard[1][2] == mark && gameBoard[2][4] == mark && gameBoard[3][6] == mark || gameBoard[3][2] == mark && gameBoard[2][4] == mark && gameBoard[1][6] == mark) {
            System.out.println("\nGame over");
            System.out.println("Player with " + "'" + mark + "'" + " wins");
            return true;
        } else {
            return false;
        }
    }
}
