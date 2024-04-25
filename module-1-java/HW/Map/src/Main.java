import com.sun.source.tree.Tree;

import java.util.*;


public class Main {
    public static void main(String[] args) {
//        System.out.println(findMaxSubstringWithoutDups("hello world without abcxz meaning"));
//        String[] anagrams = {"listen", "silent", "debit card", "bad credit", "astronomer", "moon starer", " schoolmaster", "the classroom"};
//        System.out.println(groupAnagrams(anagrams).toString());
//
//        HashMap<String, Integer> map = new HashMap<>();
//        for (String string : anagrams) {
//            map.put(string, string.length());
//        }
//        System.out.println(sumOfValues(map, "en"));
//
//        TreeMap<Integer, Integer> treemap = new TreeMap<>();
//        treemap.put(25, 1);
//        treemap.put(1, 2);
//        treemap.put(10, 3);
//        treemap.put(12, 4);
//        treemap.put(15, 5);
//        treemap.put(18, 6);
//        System.out.println(Arrays.toString(minMaxValue(treemap)));
//        System.out.println(findNearestKey(treemap, 11));
//        Iterator<Integer> iterator = getIterator(treemap, 11, 19);
//        while (iterator.hasNext()) {
//            System.out.println(treemap.get(iterator.next()));
//        }

        Dictionary rusEng = new Dictionary();
        rusEng.addWord("Заменить", "Replace");
        rusEng.addWord("Драться", "Fight");
        rusEng.addWord("Чемпион", "Champion");
        rusEng.addWord("Захватывающе", "Fascinating");
        rusEng.addWord("Привет", "Hello");
        rusEng.addWord("Мир", "World");
        rusEng.addWord("Кошка", "Cat");
        rusEng.addWord("Собака", "Dog");
        rusEng.addWord("Любовь", "Love");
        rusEng.addWord("Счастье", "Happiness");
        rusEng.addWord("Книга", "Book");
        rusEng.addWord("Стол", "Table");
        rusEng.addWord("Дом", "House");
        rusEng.addWord("Цветок", "Flower");


        System.out.println(rusEng.translateWord("Привет"));
        System.out.println(rusEng.translateWord("Привет"));
        System.out.println(rusEng.translateWord("Привет"));

        System.out.println(rusEng.translateWord("Мир"));
        System.out.println(rusEng.translateWord("Мир"));
        System.out.println(rusEng.translateWord("Мир"));

        System.out.println(rusEng.translateWord("Кошка"));
        System.out.println(rusEng.translateWord("Кошка"));

        System.out.println(rusEng.translateWord("Собака"));
        System.out.println(rusEng.translateWord("Любовь"));
        System.out.println(rusEng.translateWord("Любовь"));
        System.out.println(rusEng.translateWord("Счастье"));

        System.out.println(rusEng.translateWord("Книга"));
        System.out.println(rusEng.translateWord("Книга"));

        System.out.println(rusEng.translateWord("Стол"));

        System.out.println(rusEng.translateWord("Дом"));

        System.out.println(rusEng.translateWord("Цветок"));

        System.out.println(rusEng.translateWord("Заменить"));
        System.out.println(rusEng.translateWord("Заменить"));
        System.out.println(rusEng.translateWord("Заменить"));

        System.out.println(rusEng.translateWord("Драться"));
        System.out.println(rusEng.translateWord("Драться"));
        System.out.println(rusEng.translateWord("Драться"));

        System.out.println(rusEng.translateWord("Чемпион"));
        System.out.println(rusEng.translateWord("Чемпион"));

        System.out.println(rusEng.translateWord("Захватывающе"));
        System.out.println(rusEng.translateWord("Захватывающе"));

        System.out.println(rusEng.translateWord("Привет"));
        System.out.println(rusEng.translateWord("Привет"));
        System.out.println(rusEng.translateWord("Привет"));

        System.out.println(rusEng.translateWord("Мир"));
        System.out.println(rusEng.translateWord("Мир"));
        System.out.println(rusEng.translateWord("Мир"));

        System.out.println(rusEng.translateWord("Кошка"));
        System.out.println(rusEng.translateWord("Кошка"));

        System.out.println(rusEng.translateWord("Собака"));
        System.out.println(rusEng.translateWord("Собака"));

        System.out.println(rusEng.translateWord("Любовь"));

        System.out.println(rusEng.translateWord("Счастье"));
        System.out.println(rusEng.translateWord("Счастье"));

        System.out.println(rusEng.translateWord("Книга"));

        System.out.println(rusEng.translateWord("Стол"));

        System.out.println(rusEng.translateWord("Дом"));

        System.out.println(rusEng.translateWord("Цветок"));

        System.out.println(Arrays.toString(rusEng.topMostPopularWords()));
        System.out.println(Arrays.toString(rusEng.topLeastPopularWords()));


    }

    //TODO: Задача 1. Поиск подстроки с максимальной длиной без повторяющихся символов:
    //      Дана строка. Необходимо найти длину самой длинной подстроки без повторяющихся символов.
    //      Для решения этой задачи можно использовать HashMap, чтобы отслеживать индексы встречаемости каждого символа в строке.

    public static String findMaxSubstringWithoutDups(String string) {
        HashMap<Character, Integer> hashedString = new HashMap<>();
        for (char ch : string.toCharArray()) {
            int value = hashedString.getOrDefault(ch, 0);
            hashedString.put(ch, value + 1);
        }

        int length = 0;
        int maxLength = 0;
        String subString = "";
        String maxSubString = "";
        for (char ch : string.toCharArray()) {
            if (hashedString.get(ch) > 1) {
                if (length > maxLength) {
                    maxLength = length;
                    maxSubString = subString;
                }
                length = 0;
                subString = "";
            }
            subString += ch;
            length++;
        }
        return maxSubString;
    }

    //TODO: Задача 2. Группировка анаграмм слов:
    // Дан массив строк. Необходимо сгруппировать все анаграммы слов в массиве.
    // Для этого можно использовать HashMap, где ключами будут отсортированные версии слов,
    // а значениями - списки слов, которые являются анаграммами друг друга.

    public static HashMap<String, List<String>> groupAnagrams(String[] strings) {
        HashMap<String, List<String>> groupedAnagrams = new HashMap<>();
        for (String string : strings) {
            char[] charedString = string.toCharArray();
            Arrays.sort(charedString);
            String sortedString = new String(charedString);
            List<String> value = groupedAnagrams.getOrDefault(sortedString, new ArrayList<>());
            value.add(string);
            groupedAnagrams.put(sortedString, value);
        }
        return groupedAnagrams;
    }

    //TODO: Задача 3. Подсчет суммы значений всех ключей:
    // Дана HashMap, где ключи - это строки, а значения - целые числа.
    // Необходимо найти сумму всех чисел, значения которых соответствуют ключам, содержащим определенную подстроку.

    public static int sumOfValues(HashMap<String, Integer> map, String subString) {
        int sum = 0;
        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            if (pair.getKey().contains(subString)) {
                sum += pair.getValue();
            }
        }
        return sum;
    }

    //TODO: Задача 1. Нахождение наибольшего и наименьшего ключа:
    //      Дан TreeMap. Необходимо найти наибольший и наименьший ключи в нем.

    public static int[] minMaxValue(TreeMap<Integer, Integer> map) {
        return new int[] {map.firstKey(), map.lastKey()};
    }

    // TODO: Задача 2.  Нахождение ближайшего ключа:
    //  Дан TreeMap и ключ. Необходимо найти ключ, ближайший к заданному ключу.
    //  Это может быть как ключ, равный заданному, так и ключ, находящийся ближе всего к заданному снизу или сверху.

    public static int findNearestKey(TreeMap<Integer, Integer> map, int key) {
        if (map.containsKey(key)) {
            return map.get(key);
        }
        Integer ceilingKey = map.ceilingKey(key);
        Integer floorKey = map.floorKey(key);
        if (ceilingKey == null && floorKey == null) {
            return -1;
        }

        if (ceilingKey == null) {
            return floorKey;
        }
        if (floorKey == null) {
            return ceilingKey;
        }

        return (floorKey - key) > (ceilingKey - key) ? ceilingKey : floorKey;
    }

    //TODO: Задача 3.  Итерация по диапазону ключей:
    //  Дан TreeMap и два ключа. Необходимо найти итератор по всем элементам, ключи которых находятся в заданном диапазоне.

    public static Iterator<Integer> getIterator(TreeMap<Integer, Integer> map, int startKey, int endKey) {
        if (!map.containsKey(startKey)) {
            startKey = map.ceilingKey(startKey);
        }
        if (!map.containsKey(endKey)) {
            endKey = map.floorKey(endKey);
        }
        List<Integer> iterator = new ArrayList<>();
        while (startKey != endKey) {
            iterator.add(startKey);
            startKey = map.higherKey(startKey);
        }
        iterator.add(endKey);
        return iterator.iterator();
    }

}
