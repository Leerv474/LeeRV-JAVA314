import java.util.Arrays;
import java.util.stream.*;
public class Main {
    public static void main(String[] args) {
        task2();
    }

    //TODO: Задача 1. Параллельный поиск в массиве:
    //    • Создайте массив целых чисел.
    //    • Разделите его на две части.
    //    • Создайте два потока для поиска максимального и минимального элементов в этих частях.
    //    • Верните результаты поиска.
    public static void task1() {
        int[] numbers = {55, 72, 14, 39, 91, 27, 68, 5, 83, 20, 47, 3, 66, 98, 12, 76, 25, 59, 36, 80};
        int halfLength = numbers.length / 2;
        int[] half1 = new int[halfLength];
        int[] half2 = new int[halfLength];
        for (int i = 0; i < halfLength; i++) {
            half1[i] = numbers[i];
            half2[i] = numbers[numbers.length - i - 1];
        }
        ParallelSearch search1 = new ParallelSearch(half1);
        ParallelSearch search2 = new ParallelSearch(half2);
        search1.run();
        search2.run();
        System.out.println(Arrays.toString(search1.getResult()));
        System.out.println(Arrays.toString(search2.getResult()));
    }

    //TODO: Задача 2. Сумма элементов в массиве:
    //    • Создайте массив целых чисел.
    //    • Разделите его на несколько частей.
    //    • Создайте несколько потоков для вычисления суммы элементов в каждой части массива.
    //    • Суммируйте результаты вычислений каждого потока и верните общую сумму.
    public static void task2() {
        int[] numbers = {55, 72, 14, 39, 91, 27, 68, 5, 83, 20, 47, 3, 66, 98, 12, 76, 25, 59, 36, 80};
        int numberOfParts = 4;
        int partLength = numbers.length / numberOfParts;

        int[] part1 = new int[partLength];
        int[] part2 = new int[partLength];
        int[] part3 = new int[partLength];
        int[] part4 = new int[partLength];
        int cnt = 0;
        for (int i = 0; i < partLength; i++) {
            part1[cnt] = numbers[i];
            part2[cnt] = numbers[i + partLength];
            part3[cnt] = numbers[i + partLength * 2];
            part4[cnt] = numbers[i + partLength * 3];
            cnt++;
        }

        Sum sum1 = new Sum(part1);
        Sum sum2 = new Sum(part2);
        Sum sum3 = new Sum(part3);
        Sum sum4 = new Sum(part4);

        sum1.run();
        sum2.run();
        sum3.run();
        sum4.run();

        System.out.println(sum1.getResult());
        System.out.println(sum2.getResult());
        System.out.println(sum3.getResult());
        System.out.println(sum4.getResult());

    }
}