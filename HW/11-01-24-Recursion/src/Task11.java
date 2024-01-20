import javax.lang.model.type.ArrayType;
import java.util.*;

public class Task11 {
    //TODO: Дана шахматная доска размером 8х8, и шахматный конь.
    //      Программа должна запросить у пользователя координаты
    //      клетки поля и поставить туда коня. Задача программы – най-
    //      ти методом перебора путь коня, при котором он обойдет все
    //      клетки доски, становясь в каждую клетку только один раз.
    public static void main(String[] args) {
        knight(1, 1);
    }
    public static void knight(int x, int y) {
        if (x > 8 || x <= 0 || y > 8 || y <= 0) {
            System.out.println("No such coordinate");
            return;
        }
        boolean[][] passedSquares = new boolean[8][8];
        List<int[]> start = new ArrayList<>(List.of(new int[]{x, y}));
        List<int[]> result = move(x, y, start, passedSquares);
        if (result != null) {
            for (int[] pair : result) {
                System.out.println("RESULT: " + Arrays.toString(pair));
            }
        } else {
            System.out.println("RESULT: No route found");
        }
    }
    static List<int[]> move(int x, int y, List<int[]> madeMoves, boolean[][] passedSquares) {
        if (madeMoves.size() == 64) {
            return madeMoves;
        }

        List<int[]> savedMoves = new ArrayList<>(madeMoves);
        boolean[][] savedSquares = new boolean[8][8];
        for (int i = 0; i < passedSquares.length; i ++) {
            savedSquares[i] = Arrays.copyOf(passedSquares[i], 8);
        }

        int[][] possibleMoves = {{1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}, {-1, 2}};
        int[] cmove = new int[2];
        for (int[] posMove : possibleMoves) {
            cmove[0] = x + posMove[0];
            cmove[1] = y + posMove[1];
            if (possibleMove(cmove[0], cmove[1], passedSquares)) {
                madeMoves.add(cmove);
                passedSquares[cmove[0] - 1][cmove[1] - 1] = true;
                List<int[]> result = move(cmove[0], cmove[1], madeMoves, passedSquares);

                if (result != null) {
                    return result;
                }
            }
            madeMoves.clear();
            madeMoves.addAll(savedMoves);
            for (int i = 0; i < passedSquares.length; i++) {
                passedSquares[i] = Arrays.copyOf(savedSquares[i], 8);
            }
        }
        return null;
    }
    static boolean possibleMove(int newX, int newY, boolean[][] passedSquares) {
        boolean invalidSquare = newX > 8 || newX <= 0 || newY > 8 || newY <= 0;
        return !invalidSquare && !passedSquares[newX - 1][newY - 1];
    }
}
