import java.util.Scanner;
public class Main {
    public static boolean check(char[][] arr, int str, int stl, char player) { // метод находит выигрыши
        if (arr[str][0] == player && arr[str][1] == player && arr[str][2] == player) {
            return true;
        }

        if (arr[0][stl] == player && arr[1][stl] == player && arr[2][stl] == player) {
            return true;
        }

        if ((str == stl || str + stl == 2) &&
                ((arr[0][0] == player && arr[1][1] == player && arr[2][2] == player) ||
                        (arr[0][2] == player && arr[1][1] == player && arr[2][0] == player))) {
            return true;
        }

        return false;
    }

    public static boolean nichia(char[][] arr) {  // метод определяет, когда наступает ничья
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (arr[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
    

    public static void main(String[] args) {


        char[][] arr = new char[3][3];
        Scanner scanner = new Scanner(System.in);
       char player = 'X';
        boolean gameOver = false;
        boolean gameLose = false;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = ' ';
            }
        }

        while (!gameOver && !gameLose) {
            System.out.println("-------------");
            for (int i = 0; i < 3; i++) {
                System.out.print("| ");
                for (int j = 0; j < 3; j++) {
                    System.out.print(arr[i][j] + " | ");
                }
                System.out.println();
                System.out.println("-------------");
            }

            int str = 0;  //      строки
            int stl = 0;  //      столбцы

            while (true) {
                System.out.print("Игрок " + player +  "  введите строку : ");
                str = scanner.nextInt();
                System.out.print("Игрок " + player + ", введите  столбец : ");
                stl = scanner.nextInt();
                if (stl < 0 || stl > 2 || stl < 0 || stl > 2) {
                    System.out.println("Введите номер строки и столбца : ");
                    continue;
                }
                if (arr[str][stl] != ' ') {
                    System.out.println("Выберете другую ячейку");
                    continue;
                }
                break;
            }
            arr[str][stl] = player;          // игрок ходит

            gameOver = check(arr, str, stl, player);
            if (gameOver) {

                System.out.println("Победил игрок " + player);
                continue;
            }

            gameLose = nichia(arr);
            if (gameLose && !gameOver) {

                System.out.println("Ничья");
            }

            if (player == 'X') {                  // смена игрока
                player = 'O';
            } else {
                player = 'X';
            }  gameOver = check(arr, str, stl, player);
            if (gameOver) {
                gameOver = true;

                System.out.println("Победил игрок " + player);
                continue;
            }

            gameLose = nichia(arr);
            if (gameLose && !gameOver) {
                System.out.println("Ничья!");
            }

        }
       



        }
    }
