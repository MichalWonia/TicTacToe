public class TicTacToe {

    static char mark = 'X';
    static int playerTurns = 0;
    static int cpuTurns = 0;
    static boolean gameOver = false;
    static char[][] gameBoard = new char[][]
            {
                    {' ', ' ', '1', ' ', '2', ' ', '3'},
                    {'1', ' ', '_', '|', '_', '|', '_'},
                    {'2', ' ', '-', '|', '-', '|', '-'},
                    {'3', ' ', '¯', '|', '¯', '|', '¯'}
            };

    public static void main(String[] args) {
        drawGameBoard();
    }

    public static void drawGameBoard() {
        char[][] var0 = gameBoard;
        int var1 = var0.length;

        for (char[] chars : var0) {
            for (int j = 0; j < gameBoard[0].length; ++j) {
                System.out.print(chars[j]);
            }
            System.out.println();
        }
    }
}
