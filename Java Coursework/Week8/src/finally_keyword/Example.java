package finally_keyword;

import java.util.Scanner;

public class Example {
    public static void main(String[] args) {

        Integer n, d;
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter numerator: ");
        n = keyboard.nextInt();
        System.out.println("Enter denominator: ");
        d = keyboard.nextInt();
        try {
            Double div = divide(n, d);
            System.out.println(div);
        } catch (IllegalArgumentException ex) { // only relevant catch
            System.err.println("Illegal Arg Exception caught: " + ex.getMessage());
        } catch (NullPointerException ex) {
            System.err.println("NullPointer caught: " + ex.getMessage());
        } catch (Exception ex) {
            System.err.println("Generic exception caught: " + ex.getMessage());
        } finally { // always executed whether exception is caught or not
            System.out.println("this code will always execute regardless of whether an exception was caught or not.");
        }
    }

    private static Double divide(Integer n, Integer d) {
        if (d == 0)
            throw new IllegalArgumentException("Can't divide by zero"); // unchecked exception, don't need try/catch block
        return (double) n/d;

    }
}
