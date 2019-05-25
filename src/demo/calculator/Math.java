package demo.calculator;

public class Math {

    public static final String DIVISION_EXCEPTION = "Divide by zero!";

    /**
     * Add b to a
     *
     * @param a double
     * @param b double
     * @return double
     */
    public double sum(double a, double b)
    {
        return a + b;
    }

    /**
     * Substract b from a
     *
     * @param a double
     * @param b double
     * @return double
     */
    public double subst(double a, double b)
    {
        return a - b;
    }

    /**
     * Multiply a by b
     *
     * @param a double
     * @param b double
     * @return double
     */
    public double mult(double a, double b)
    {
        return a * b;
    }

    /**
     * Divide a by b
     *
     * @param a double
     * @param b double
     * @return double
     */
    public double div(double a, double b)
    {
        if (b == 0) {
            throw new IllegalArgumentException(DIVISION_EXCEPTION);
        }

        return a / b;
    }
}
