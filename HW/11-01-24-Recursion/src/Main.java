import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        System.out.println("\n\nTask1:");
//        Task1(5, 1);
//
//        System.out.println("\n\nTask2:");
//        Task2(512);
//
//        System.out.println("\n\nTask3:");
//        System.out.println(Task3(12345));
//
//        System.out.println("\n\nTask4:");
//        Task4(12345);
//
//        System.out.println("\n\nTask5:");
//        Task5(12345);
//
//        System.out.println("\n\nTask6:");
//        System.out.println(Task6(12345));
//
//        System.out.println("\n\nTask7:");
//        Task7("Hello world radar");
//
//        System.out.println("\n\nTask8:");
//        System.out.println(Task8(2, 7));
//
//        System.out.println("\n\nTask9:");
//        System.out.println(Task9(1, 5));
//
//        System.out.println("\n\nTask10:");
//        System.out.println(Task10(10, 15));
        System.out.println(euclid(25, 100));
        System.out.println(euclid(140, 96));
    }

    //TODO: Даны два целых числа A и В. Выведите все числа от A до
    //      B включительно, в порядке возрастания, если A < B, или в
    //      порядке убывания – в противном случае.
    //          Ввод: 5 1
    //          Вывод: 5 4 3 2 1
    public static void Task1(int A, int B) {
        System.out.print(A + " ");
        if (A == B) {
            return;
        }
        if (A < B) {
            Task1(A + 1, B);
        } else {
            Task1(A - 1, B);
        }
    }

    //TODO: Дано натуральное число N. Выведите слово YES, если число
    //      N является точной степенью двойки, или слово NO – в противном случае.
    public static void Task2(int N) {
        if (N == 2) {
            System.out.println("Yes");
            return;
        }
        if (N % 2 == 0) {
            Task2(N / 2);
        } else {
            System.out.println("No");
            return;
        }
    }

    //TODO: Дано натуральное число N. Вычислите сумму его цифр.
    public static int Task3(int N) {
        if (N == 0) {
            return 0;
        }
        return (N % 10) + Task3(N / 10);
    }

    //TODO: Дано натуральное число N. Выведите все его цифры по од-
    //      ной, в обратном порядке, разделяя их пробелами. Разрешена
    //      только рекурсия и целочисленная арифметика.

    public static void Task4(int N) {
        if (N == 0) {
            return;
        }
        System.out.print(N % 10 + " ");
        Task4(N / 10);
    }

    //TODO: Дано натуральное число N. Выведите все его цифры по
    //      одной, в обычном порядке, разделяя их пробелами или новы-
    //      ми строками. При решении этой задачи нельзя использовать
    //      строки, списки, массивы, циклы. Разрешена только рекурсия
    //      и целочисленная арифметика.
    public static void Task5(int N) {
        if (N == 0) {
            return;
        }
        int decimals = (int) Math.pow(10, (int)Math.log10(N));
        System.out.print(N / decimals + " ");
        Task5(N % decimals);
    }

    //TODO: С клавиатуры вводится число n, десятичная запись кото-
    //      рого не содержит нулей. Получите число, записанное теми
    //      же цифрами, но в противоположном порядке. При решении
    //      этой задачи разрешается только рекурсия и целочисленная
    //      арифметика. Метод должен возвращать целое число, явля-
    //      ющееся результатом работы программы, выводить число по
    //      одной нельзя.
    public static int Task6(int N) {
        if (N == 0) {
            return 0;
        }
        int decimals = (int) Math.pow(10, (int)Math.log10(N));
        return ((N % 10) * decimals) + Task6(N / 10);
    }

    //TODO: Дано предложение, состоящее только из строчных ла-
    //      тинских букв. Проверьте, являются ли слова в предложении
    //      палиндромом. Выведите YES или NO.
    public static void Task7(String sentence) {
        sentence += ' ';
        StringBuilder word = new StringBuilder();
        for(int i = 0; i < sentence.length(); i ++) {
            if (sentence.charAt(i) == ' ') {
                System.out.print(palindrome(word) ? "yes " : "no ");
                word.delete(0, word.length());
                continue;
            }
            word.append(sentence.charAt(i));
        }
    }

    static boolean palindrome(StringBuilder word) {
        if (word.length() <= 1) {
            return true;
        }
        if (word.charAt(0) != word.charAt(word.length() - 1)) {
            return false;
        }
        word.deleteCharAt(word.length() - 1);
        word.deleteCharAt(0);
        return palindrome(word);
    }

    //TODO: Вычислить результат возведения числа m в степень n, ис-
    //      пользуя рекурсию. В статический метод передается 2 параме-
    //      тра – число и степень
    public static int Task8(int num, int power) {
        if (power == 0) {
            return 1;
        }
        return num * Task8(num, power - 1);
    }

    //TODO: Вычислить сумму чисел в определенном диапазоне. Начало
    //      и конец диапазона задается параметрами.

    public static int Task9(int start, int end) {
        if (start == end) {
            return start;
        }
        return start + end + (start < end ? Task9(start + 1, end - 1) : Task9(start - 1, end + 1));
    }

    //TODO: Написать рекурсивный статический метод нахождения
    //      наибольшего общего делителя двух целых чисел.
    public static int Task10(int num1, int num2) {
        if (num1 == num2) {
            return num1;
        }
        if (num1 > num2) {
            return Task10(num1, num2, num2);
        }
        return Task10(num1, num2, num1);
    }

    static int Task10(int num1, int num2, int divisor) {
        if (num1 % divisor == 0 && num2 % divisor == 0) {
            return divisor;
        }
        return Task10(num1, num2, divisor - 1);
    }

    //TODO: Агоритм Евклида

    /* Алгоритм Евклида
        * 1) Из двух данных чисел большее число делят на меньшее.
        * 2) Затем, меньшее число делят на остаток, получившийся от
        *      деления большего числа на меньшее.
        * 3) Далее, первый остаток делят на второй остаток, который получился
        *      от деления меньшего числа на первый остаток.
        * 4) Второй остаток делят на третий, который получился от деления
        *      первого остатка на второй и т. д.
        * 5) Таким образом деление продолжается до тех пор, пока в остатке не получится нуль.
        *      Последний делитель как раз и будет наибольшим общим делителем.
    */
    static int euclid(int num1, int num2) {
        if (num1 < num2) {
            int temp = num2;
            num2 = num1;
            num1 = temp;
        }
        if (num2 == 0) {
            return num1;
        }
        return euclid(num2, num1 % num2);
    }
}