import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        task1();
    }

    //TODO:     1. Параллельный поиск в коллекции:
    //        ◦ Создайте класс, который содержит синхронизированный список (например, ArrayList).
    //        ◦ Создайте несколько потоков, которые параллельно будут выполнять поиск рандомного элемента в этом списке. У каждого потока будет свой элемент.
    //        ◦ Используйте блокирующую синхронизацию (synchronized) при доступе к списку.
    public static void task1() {
        List<Thread> threads = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>(Arrays.asList(10, 25, 6, 33, 17, 42, 8, 19, 5, 28));
        for (int i = 0; i < 10; i++) {
            Random random = new Random();
            int randomNum = random.nextInt(100);
            ParallelCollectionSearch search = new ParallelCollectionSearch(numbers, randomNum);
            Thread thread = new Thread(search);
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //TODO:     2. Параллельная сортировка списка:
    //        ◦ Создайте класс, который содержит синхронизированный список (например, LinkedList).
    //        ◦ Создайте несколько потоков, каждый из которых будет сортировать свою часть списка.
    //        ◦ Используйте блокирующую синхронизацию (synchronized) при доступе к списку.
    public static void task2() {
        List<Integer> list = new ArrayList<>(Arrays.asList(15, 29, 7, 36, 42, 18, 5, 33, 27, 10, 21, 38, 14, 25, 8, 31, 20, 12, 40, 3));
        int numberOfSubLists = 4;
        int sublistSize = list.size() / numberOfSubLists;
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < numberOfSubLists; i++) {
            int start = sublistSize * i;
            int end = start + sublistSize;
            List<Integer> sublist = list.subList(start, end);
            Thread thread = new Thread(new SyncSortList(sublist));
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //TODO:    3. Сравнение времени работы:
    //        ◦ Сравните 3 разных вариантов работы с коллекциями на больших значениях
    //        ◦ 1. synchronized метод
    //        ◦ 2. synchronized блок кода внутри метода, работающий с коллекцией
    //        ◦ 3. Обернутая потокобезопасная коллекция
    public static void task3() {

    }
}