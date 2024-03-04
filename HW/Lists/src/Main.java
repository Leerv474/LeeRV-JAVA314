import java.util.ArrayList;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(23);
        list.add(21);
        list.add(21);
        list.add(3);
        list.add(81);
        list.add(81);
        list.add(23);
        printSubList(list, 1, 3);
        printMaxMin(list);
        //deleteDups(list);
        System.out.println(list);
        System.out.println(findUnique(list));
    }
    //TODO: Задача 1: Извлечение подсписка
    // Создайте список строк типа ArrayList или LinkedList, содержащий несколько элементов. Напишите код, который извлекает подсписок из исходного списка и выводит его на экран.

    public static void printSubList(java.util.ArrayList<Integer> list, int start, int end) {
        try {
            System.out.println(list.subList(start, end));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("bad indexes");
        }
    }

    //TODO: Задача 2: Поиск минимума и максимума
    //      Создайте список чисел типа ArrayList или LinkedList, заполните его несколькими числами. Напишите код, который находит минимальный и максимальный элементы в списке и выводит их на экран.

    public static void printMaxMin(ArrayList<Integer> list) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int element : list) {
            if (max < element) {
                max = element;
            }
            if (min > element) {
                min = element;
            }
        }
        System.out.printf("Max value: %d\nMin value: %d\n", max, min);
    }

    //TODO: Задача 3: Удаление дубликатов
    // Создайте список строк типа ArrayList или LinkedList, который содержит несколько дубликатов. Напишите код, который удаляет все дубликаты из списка, оставляя только уникальные элементы. Выведите список после удаления дубликатов.

    public static void deleteDups(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) == list.get(i) && i != j) { 
                    list.remove(j);
                    i++;
                    j++;
                }
            }
        }
    }
    //TODO: Задача 4*: Поиск уникального элемента
    // Предположим, у вас есть список целых чисел. Некоторые из чисел встречаются в списке дважды, а одно число встречается только один раз. Ваша задача - найти это уникальное число.
    // Напишите метод, который принимает на вход список целых чисел и возвращает уникальное число из списка.

    public static int findUnique(ArrayList<Integer> list) {
        boolean isUnique;
        for (int i = 0; i < list.size(); i++) {
            isUnique = true;
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j) == list.get(i) && i != j) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                return list.get(i);
            }
        }
        return -1;
    }
}

