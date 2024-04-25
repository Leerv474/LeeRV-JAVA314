public class Main {
    public static void main(String[] args) {
        System.out.println("Factorial of 5 is " + factorial(5));
        System.out.println(intLine(5));
        System.out.println(sumDigits(123));
    }

    private static int factorial(int value) {
        if (value == 1 || value == 0) {
            return 1;
        }
        return value * factorial(value - 1);
    }

    // собрать строку целых чисел от 0 до n, разделенных запятой
    private static String intLine(int n) {
        if (n == 0) {
            return "0";
        }
        return intLine(n - 1) + ", " + n;
    }

    private static int sumDigits(int n) {
        if (n < 10) {
            return n;
        }
        return n%10 + sumDigits(n/10);
    }
}