package power_function_recursion;

public class MathPowTest {
    public static void main(String[] args) {

        // 243
        System.out.println(MathPow.pow(3d, 5d));

        // 1
        System.out.println(MathPow.pow(3d, 0d));

        // 8
        System.out.println(MathPow.pow(2d, 3d));
        System.out.println();

        System.out.println(MathPow.powRec(3d, 5d));
        System.out.println(MathPow.powRec(3d, 0d));
        System.out.println(MathPow.powRec(2d, 3d));
    }
}
