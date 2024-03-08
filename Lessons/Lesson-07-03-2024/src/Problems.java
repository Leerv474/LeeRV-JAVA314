import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Function;
import java.util.List;
import java.util.function.Predicate;

public class Problems {
    //TODO: Фильтрация и вывод имен, начинающихся с буквы 'A'
    public static void main(String[] args) {

        Task5();
    }

    public static void Task1() {
        List<String> names = new ArrayList<>();
        names.add("Sergey");
        names.add("Egor");
        names.add("Artem");
        names.add("Alina");
        names.add("Alexey");
        names.add("Roman");

        Predicate<String> filterNames = name -> name.startsWith("A");
        for (String name : names) {
            if (filterNames.test(name)) {
                System.out.println(name);
            }
        }
    }

    public static void Task2() {
        List<String> names = new ArrayList<>();
        names.add("Sergey");
        names.add("Egor");
        names.add("Artem");
        names.add("Alina");
        names.add("Alexey");
        names.add("Roman");

        Collections.sort(names, (name1, name2) -> name1.compareTo(name2));
        System.out.println(names);
    }

    public static void Task3() {
        String string = "Hello World!";
        String subString = "Hello";

        Predicate<String> containsSubString = (str) -> str.contains(subString);
        System.out.println(containsSubString.test(string) ? "contains" : "doesn't contain");
    }


    public static void Task5() {
        String text = "Java is a programming language";

        Function<String, List<Integer>> splitIntoWords = line -> {
            int length = 0;
            List<Integer> lengthes = new ArrayList<>();
            for (char ch : text.toCharArray()) {
                if (ch == ' ') {
                    lengthes.add(length);
                    length = 0;
                    continue;
                }
                length++;
            }
            lengthes.add(length);
            return lengthes;
        };
        System.out.println(splitIntoWords.apply(text));
    }
}
