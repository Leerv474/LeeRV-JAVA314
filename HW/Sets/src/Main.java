import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(5);

        set2.add(1);
        set2.add(2);
        set2.add(8);
        set2.add(0);
        set2.add(13);

        System.out.println(combineSets(set1, set2));
        System.out.println(intersectionSet(set1, set2));
        System.out.println(differenceSet(set1, set2));
    }

    //TODO: Задача 1: Проверка на уникальность
    // Напишите метод, который принимает на вход строку и проверяет, содержит ли она все уникальные символы. Метод должен вернуть true, если все символы в строке уникальны, и false в противном случае.
    public static boolean isUnique(String str) {
        HashSet<Character> hashedString = new HashSet<>();
        for (char ch : str.toCharArray()) {
            hashedString.add(ch);
        }

        return hashedString.size() == str.length();
    }

    //TODO: Задача 2: Объединение множеств
    // Напишите метод, который принимает на вход два множества Set и возвращает новое множество, содержащее все элементы из обоих исходных множеств.

    public static HashSet<Integer> combineSets(HashSet<Integer> set1, HashSet<Integer> set2) {
        HashSet<Integer> newSet = new HashSet<>();
        newSet.addAll(set1);
        newSet.addAll(set2);

        return newSet;
    }

    //TODO: Задача 3: Пересечение множеств
    // Напишите метод, который принимает на вход два множества Set и возвращает новое множество, содержащее только те элементы, которые присутствуют в обоих исходных множествах.
    
    public static HashSet<Integer> intersectionSet(HashSet<Integer> set1, HashSet<Integer> set2) {
        HashSet<Integer> newSet = new HashSet<>();
        int i = 0;
        int j;
        for (int value1 : set1) {
            j = 0;
            for (int value2 : set2) {
                if (value1 == value2 && i != j) { 
                    newSet.add(value1);
                }
                j++;
            }
            i++;
        }
        return newSet;
    }

    //TODO: Задача 4: Разность множеств
    // Напишите метод, который принимает на вход два множества Set и возвращает новое множество, содержащее только те элементы, которые присутствуют только в одном из исходных множеств.
    
    public static HashSet<Integer> differenceSet(HashSet<Integer> set1, HashSet<Integer> set2) {
        HashSet<Integer> newSet = new HashSet<>();
        int i = 0;
        int j;
        newSet.addAll(set1);
        newSet.addAll(set2);
        for (int value1 : set1) {
            j = 0;
            for (int value2 : set2) {
                if (value1 == value2 && i != j) {
                    newSet.remove(value1);
                }
                j++;
            }
            i++;
        }
        return newSet;
    }
}





