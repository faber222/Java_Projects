import java.util.Scanner;

public class TerceiraQuestão {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        char[][] board = new char[9][9];
        int[][] mines = new int[9][9];
        int j = 0;

        while (keyboard.hasNext()) {
            String loginVet = keyboard.next();
            for (int i = 0; i < 8; i++) {
                board[j][i] = loginVet.charAt(i);
            }
            j++;
        }
        keyboard.close();

        char aster = '*';

        for (int i = 0; i < 8; i++) {
            for (int k = 0; k < 8; k++) {
                if (board[i][k] == aster) {
                    mines[i][k] = -1;
                }
            }
        }
        fillTips(mines);

        for (int i = 0; i < 8; i++) {
            for (int k = 0; k < 8; k++) {
                if (mines[i][k] == 0) {
                    System.out.print(".");
                } else if (mines[i][k] == -1) {
                    System.out.print("*");
                } else {
                    System.out.print(mines[i][k]);
                }
            }
            System.out.println("");
        }

    }

    public static void fillTips(int[][] mines) {
        for (int line = 1; line < 8; line++) {
            for (int column = 1; column < 8; column++) {
                for (int i = -1; i <= 1; i++) {
                    for (int j = -1; j <= 1; j++) {
                        // verifica aleatoriamente o mapa, indo de [1][1] até [8][8],
                        // mas não indo em [0][i] e nem [i][0]
                        if (mines[line][column] != -1) {
                            if (mines[line + i][column + j] == -1) {
                                mines[line][column]++;
                            }
                        }

                    }
                } // sequencia de ifs que vão verificar as posições [0][i]
                if ((mines[0][column] != -1) && line == 1) {
                    if (mines[0][column + 1] == -1) {
                        mines[0][column]++;
                    }
                    if (mines[0][column - 1] == -1) {
                        mines[0][column]++;
                    }
                    if (mines[1][column - 1] == -1) {
                        mines[0][column]++;
                    }
                    if (mines[1][column] == -1) {
                        mines[0][column]++;
                    }
                    if (mines[1][column + 1] == -1) {
                        mines[0][column]++;
                    }
                }

            } // sequencia de ifs que vão verificar as posições de [i][0]
            if ((mines[line][0] != -1)) {
                if (mines[line - 1][0] == -1) {
                    mines[line][0]++;
                }
                if (mines[line + 1][0] == -1) {
                    mines[line][0]++;
                }
                if (mines[line - 1][1] == -1) {
                    mines[line][0]++;
                }
                if (mines[line + 1][1] == -1) {
                    mines[line][0]++;
                }
                if (mines[line][1] == -1) {
                    mines[line][0]++;
                }
            }
        } // sequencia para vetor [0][0]
        if (mines[0][0] != -1) {
            if (mines[0][1] == -1) {
                mines[0][0]++;
            }
            if (mines[1][0] == -1) {
                mines[0][0]++;
            }
            if (mines[1][1] == -1) {
                mines[0][0]++;
            }
        }
    }
}
