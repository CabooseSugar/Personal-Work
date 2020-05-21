package power_function_recursion;

public class MathPow {

    // x ^ y
    public static Double pow(Double x, Double y) {

        Double result = 1d;
        for (int i = 1; i <= y; i++) {
            result *= x;
        }

        return result;
    }

    public static Double powRec (Double x, Double y) {
        if (y==0) {
            return 1d; // base case
        }
        else {
            return x * powRec(x, y - 1); // recursive case
        }
    }
}
