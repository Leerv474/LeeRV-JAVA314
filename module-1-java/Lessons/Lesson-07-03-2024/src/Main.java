import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        //Анонимные классы
        // Predicate is a functional interface, the interface which has only one method
        // it takes only one generic and returns boolean
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Predicate<Integer> isEven = new Predicate<>() {
            @Override
            public boolean test(Integer num) {
                return num % 2 == 0;
            }
        };


        //печатаем каждый элемент в коллекции с новой строки
        numbers.stream()
                .filter(isEven)
                .forEach(System.out::println);
    }
}