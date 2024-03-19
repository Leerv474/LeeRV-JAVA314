import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        task4();
    }

    //TODO:     1. Фильтрация и сборка:
    //        ◦ Создайте список объектов Person с полями name, age и gender.
    //        ◦ Используя Stream, отфильтруйте только женщин старше 18 лет.
    //        ◦ Соберите их имена в новый список.
    public static void task1() {
        List<Person> people = new ArrayList<>();
        people.add(new Person("James", 18, "male"));
        people.add(new Person("Alice", 30, "female"));
        people.add(new Person("Benjamin", 42, "male"));
        people.add(new Person("Lily", 12, "female"));
        people.add(new Person("Ethan", 21, "male"));
        people.add(new Person("Olivia", 35, "female"));
        people.add(new Person("William", 28, "male"));
        people.add(new Person("Sophia", 19, "female"));
        people.add(new Person("Jacob", 33, "male"));
        people.add(new Person("Ava", 27, "female"));
        people.add(new Person("Noah", 24, "male"));

        List<Person> adultWomen = new ArrayList<>();
        adultWomen = people.stream().filter(person -> person.getAge() >= 18 && person.getGender().equals("female")).toList();
        for (Person person : adultWomen) {
            System.out.println(person.getName());
        }
    }

    //TODO:     2. Трансформация данных:
    //        ◦ Создайте список строк, представляющих числа в виде строк.
    //        ◦ Преобразуйте этот список в список целых чисел.
    //        ◦ Отфильтруйте только четные числа.
    //        ◦ Преобразуйте их в строковое представление.
    //        ◦ Соберите их в строку, разделенную запятыми.
    public static void task2() {
        List<String> stringNumbers = new ArrayList<>();
        stringNumbers.add("123");
        stringNumbers.add("456");
        stringNumbers.add("789");
        stringNumbers.add("321");
        stringNumbers.add("654");
        stringNumbers.add("987");
        stringNumbers.add("234");
        stringNumbers.add("567");
        stringNumbers.add("890");
        stringNumbers.add("432");
        stringNumbers.add("765");

        List<Integer> intNumbers = stringNumbers.stream().map(Integer::parseInt).toList();
        List<Integer> evenNumbers = intNumbers.stream().filter(number -> number % 2 == 0).toList();
        List<String> stringEvenNumbers = evenNumbers.stream().map(String::valueOf).toList();
        String result = stringEvenNumbers.stream().collect(Collectors.joining(", "));
        System.out.println(result);
    }

    //TODO:     4. Сортировка и поиск:
    //        ◦ Создайте список целых чисел.
    //        ◦ Отсортируйте его по убыванию.
    //        ◦ Найдите первые 3 элемента после сортировки.
    public static void task4() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(123);
        numbers.add(789);
        numbers.add(321);
        numbers.add(654);
        numbers.add(987);
        numbers.add(234);
        numbers.add(567);
        numbers.add(890);
        numbers.add(432);
        numbers.add(765);

        List<Integer> sortedNumbers = numbers.stream().sorted(Comparator.reverseOrder()).toList();
        sortedNumbers.stream().limit(3).forEach(System.out::println);
    }
}