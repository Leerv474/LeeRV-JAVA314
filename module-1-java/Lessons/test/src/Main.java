import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Main{

    private static Map<BigInteger, BigInteger> memo = new HashMap<>();

    public static BigInteger factorial(BigInteger number) {
        if (number.equals(BigInteger.ZERO) || number.equals(BigInteger.ONE)) {
            return BigInteger.ONE;
        }

        if (memo.containsKey(number)) {
            return memo.get(number);
        }

        BigInteger result = number.multiply(factorial(number.subtract(BigInteger.ONE)));
        memo.put(number, result);
        return result;
    }

    public static void main(String[] args) {
        BigInteger number = new BigInteger("1000000");
        BigInteger result = factorial(number);
        System.out.println(result);
    }
}
