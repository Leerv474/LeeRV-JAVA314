public class Task12 {
    //TODO: На квадратной доске размером NхN расставлены случайные
    //      целые положительные числа. Черепашка, находящаяся в
    //      левом верхнем углу, мечтает попасть в правый нижний. При
    //      этом, она может переползать только в клетку справа или в
    //      клетку снизу (не наискосок) и хочет, чтобы сумма всех чисел,
    //      оказавшихся у нее на пути, была максимально возможной.
    //      Показать на экране консоли эту сумму. Показать путь следо-
    //      вания черепашки. Показать исходный массив в виде таблицы.

    public static void main(String[] args) {
        int[][] matrix = {
                {7, 12, 25, 18, 14, 9, 3, 21, 30, 5},
                {11, 28, 16, 8, 20, 6, 17, 22, 13, 27},
                {15, 23, 4, 29, 10, 19, 26, 2, 1, 24},
                {31, 33, 35, 37, 39, 41, 43, 45, 47, 49},
                {50, 48, 46, 44, 42, 40, 38, 36, 34, 32},
                {1, 3, 5, 7, 9, 11, 13, 15, 17, 19},
                {20, 18, 16, 14, 12, 10, 8, 6, 4, 2},
                {25, 27, 29, 31, 33, 35, 37, 39, 41, 43},
                {46, 44, 42, 40, 38, 36, 34, 32, 30, 28},
                {49, 47, 45, 43, 41, 39, 37, 35, 33, 31}
        };
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }

        Task12(matrix);
    }

    public static void Task12(int[][] board) {
        int boardSize = board[0].length;
        int[][] path = new int[boardSize][boardSize];
        path[0][0] = board[0][0];

        int result = sum(0, 0, board, path);

        System.out.println("\nResulting path:");
        for (int[] ints : path) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }

        System.out.println("The resulting sum is " + result);
    }

    static int sum(int iCoord, int jCoord, int[][] board, int[][] path) {
        if (iCoord == board[0].length - 1 && jCoord == board[0].length - 1) {
            return 0;
        }
        if (iCoord < board.length - 1 && jCoord < board.length - 1) {
            if (board[iCoord + 1][jCoord] < board[iCoord][jCoord + 1]) {
                path[iCoord + 1][jCoord] = board[iCoord + 1][jCoord];
                return board[iCoord][jCoord] + sum(iCoord + 1, jCoord, board, path);
            } else {
                path[iCoord][jCoord + 1] = board[iCoord][jCoord + 1];
                return board[iCoord][jCoord] + sum(iCoord, jCoord + 1, board, path);
            }
        } else {
            if (iCoord == board.length - 1) {
                path[iCoord][jCoord + 1] = board[iCoord][jCoord + 1];
                return board[iCoord][jCoord] + sum(iCoord, jCoord + 1, board, path);
            } else if (jCoord == board.length - 1) {
                path[iCoord + 1][jCoord] = board[iCoord + 1][jCoord];
                return board[iCoord][jCoord] + sum(iCoord + 1, jCoord, board, path);
            }
        }
        return 0;
    }
}
