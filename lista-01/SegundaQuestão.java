import java.util.Random;

public class SegundaQuestão {
    public static void main(String[] args) {
        char[][] board = new char[9][9];
        int[][] mines = new int[9][9];
        int line = 0, column = 0;
        boolean drawnNumber = true;
        Random random = new Random();

        for (int i = 0; i < 10; i++) {
            while (drawnNumber) {
                line = random.nextInt(8) + 1;
                column = random.nextInt(8) + 1;
                if (mines[line][column] != -1) {
                    drawnNumber = false;
                }
            }
            drawnNumber = true;
            mines[line][column] = -1;
        }
        showBoard(board, mines);
    }

    public static void showBoard(char[][] board, int[][] mines) {

        for (int i = 1; i < mines.length; i++) {
            for (int j = 1; j < mines.length; j++) {
                board[i][j] = '.';
            }
        }

        for (int i = 1; i < 9; i++) {
            for (int j = 1; j < 9; j++) {
                if (mines[i][j] == -1) {
                    board[i][j] = '*';
                }
            }
        }

        for (int line1 = 8; line1 > 0; line1--) {
            for (int column1 = 1; column1 < 9; column1++) {
                System.out.print(board[line1][column1]);
            }
            System.out.println();
        }
    }
}
