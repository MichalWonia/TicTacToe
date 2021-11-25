import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class TicTacToe {

    static char mark = 'X'; // 'X' - player's mark, 'O' - CPU's mark

    static int playerTurns = 0;
    static int cpuTurns = 0;
    static boolean gameOver = false;

    static char[][] gameBoard = { // the digits indicate the vertical and horizontal coordinates
            {' ', ' ', '1', ' ', '2', ' ', '3'},
            {'1', ' ', '_', '|', '_', '|', '_'},
            {'2', ' ', '-', '|', '-', '|', '-'},
            {'3', ' ', '¯', '|', '¯', '|', '¯'}
    };

    public static void main(String[] args) throws InterruptedException {
        drawGameBoard();

        while (!gameOver) {
            markPlacing(mark);
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
            System.out.println("Select vertical coordinate of your mark: ");
            posX = sc.nextInt();
            System.out.println("Select horizontal coordinate of your mark: ");
            posY = sc.nextInt();
            gameBoard[posX][2 * posY] = 'X';
            playerTurns++;

        } else {

            System.out.println("CPU is thinking...");
            TimeUnit.SECONDS.sleep(3);

            Random random = new Random();
            int posX = random.nextInt(3) + 1;
            int posY = random.nextInt(3) + 1;

            while (true) {
                if (gameBoard[posX][2 * posY] == 'X' || gameBoard[posX][2 * posY] == 'O') {
                    posX = random.nextInt(3) + 1;
                    posY = random.nextInt(3) + 1;
                } else {
                    gameBoard[posX][2 * posY] = 'O';
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
}
