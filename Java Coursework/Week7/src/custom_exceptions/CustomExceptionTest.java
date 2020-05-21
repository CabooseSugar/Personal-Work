package custom_exceptions;

import java.util.Scanner;

public class CustomExceptionTest {

    public static void main(String[] args) {

        try {
            doProgram();
        } catch(DivideByZeroException dex) {
            System.err.println("ERRORS: " + dex.getMessage());
        }

    }

    private static void doProgram() throws DivideByZeroException { // "throwS" goes on method
        Integer num, den;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("NUM: ");
        num = keyboard.nextInt();
        System.out.println("DENOM: ");
        den = keyboard.nextInt();
        if (den == 0)
            throw new DivideByZeroException(); // "throw" (no S) inside method
        Integer divide = num/den;
        System.out.println("RESULT OF INTEGER DIVISION: " + divide);
    }
}
