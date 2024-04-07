/**
 *  Calculates simple operations
 * @author roman lee
 */
public class Calculator {
    /**
     *  Total count of operations, that this Calculator can perform
     */
    public static final int OPERATIONS_COUNT = 4;

    /**
     * Performs division of one number by another
     * @param a First value
     * @param b Second value
     * @return Division result
     * @throws ArithmeticException if an attempt to divide by zero if made
     */
    public double divide(double a, double b) {
        if (b == 0) {
            throw new ArithmeticException("Division by zero if impossible");
        }
        return a / b;
    }

}
