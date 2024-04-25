import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Main {
    public static void main(String[] args) {
        factorial();
    }

    //TODO: Задача 1. Ввод данных: 
    //Напишите программу, которая запрашивает у пользователя ввод данных и пытается обработать этот ввод. Обработайте исключение InputMismatchException, которое возникает, если введенные данные не соответствуют ожидаемому формату.
    public static void validateEmail() {
        var scanner = new Scanner(System.in);
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        try {
            String email = scanner.next();
            Pattern pattern = Pattern.compile(emailRegex);
            Matcher matcher = pattern.matcher(email);

            if (matcher.matches()) {
                System.out.println("Valid email");
            } else {
                throw new InputMismatchException("Invalid email");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }

    //TODO: Задача 2. Парсинг даты:
    //Напишите программу, которая запрашивает у пользователя ввод даты в формате "год-месяц-день" (например, "2022-01-31"). Затем попробуйте преобразовать эту строку в объект типа LocalDate с помощью метода LocalDate.parse(). Обработайте возможное исключение DateTimeParseException, если введенная строка имеет неверный формат.

    public static void parseDate() {
        var scanner = new Scanner(System.in);

        String inputDate = scanner.next();

        try {
            LocalDate date = LocalDate.parse(inputDate);
            System.out.println("Entered date is valid: " + date);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
         
    }

    //TODO: Задача 3. Вычисление квадратного корня: 
    //Напишите программу, которая запрашивает у пользователя число и вычисляет его квадратный корень с помощью метода Math.sqrt(). Обработайте возможное исключение IllegalArgumentException, если пользователь вводит отрицательное число.

    public static void sqrt() {
        var scanner = new Scanner(System.in);
        double num = scanner.nextDouble();

        try {
            if (num < 0) {
                throw new IllegalArgumentException("sqrt of a negative value");
            }
            System.out.println(Math.sqrt(num));
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        
    }

    public static void factorial() {
        var scanner = new Scanner(System.in);
        int num = scanner.nextInt();

        try {
            System.out.println(factorial(num));
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
    public static int factorial(int num) throws NegativeNumberException {
        if (num < 0) {
            throw new NegativeNumberException("Negative numbers are not allowed");
        }
        if (num <= 1) {
            return 1;
        }
        return num * factorial(num - 1);
    }
}
