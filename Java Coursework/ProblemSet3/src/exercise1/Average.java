package exercise1;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        int n, entry;
        double sum = 0;
        Scanner keyboard = new Scanner(System.in);
        ArrayList<Integer> entriesList = new ArrayList<>();

        System.out.println("This program will calculate the average of N numbers.");

        // Getting input for N
        while(true) {
            try {
                System.out.print("Enter an integer value for N: ");
                n = keyboard.nextInt();
                if (n < 0)
                    throw new IllegalArgumentException("N must be positive!");
                break;
            } catch (IllegalArgumentException ill) {    // catches if n < 0
                System.err.println(ill.getMessage());   // prints message argument in IllegalArgumentException constructor above
            } catch (InputMismatchException ime) {      //InputMismatchException catches a non-int entry for n
                System.err.println("Entered value is not an integer!");
                keyboard.next();                        // clears wrong character (\n from hitting enter?) so there's no infinite loop
            }
        }
        System.out.println();

        // Getting input for N amount of entries
        for (int i = 0; i < n; i++) {
            while(true) {
                try {
                    System.out.print("Enter integer " + (i + 1) + " to average: ");
                    entry = keyboard.nextInt();
                    if (entry < 0)
                        throw new IllegalArgumentException("Entry must be positive! Try again."); // same exception as above being thrown
                    entriesList.add(entry);
                    break;
                } catch (IllegalArgumentException ill) { // catching < 0 entry exception above
                    System.err.println(ill.getMessage());
                } catch (InputMismatchException ime) { // catching if inputted entry is not an int
                    System.err.println("Entered value is not an integer!");
                    keyboard.next();
                }
            }
        }

        // Averaging entries
        for (int i = 0; i < n; i++) {
            sum += entriesList.get(i);
        }

        // Printing results
        System.out.printf("\nThe average of your entries is: %.2f", sum / n);
    }
}

// Note: System.err messages and normal System.out messages have a habit of printing out of order
// this is apparently largely unavoidable.
/*
This program will calculate the average of N numbers.
Enter an integer value for N: -8
N must be positive!
Enter an integer value for N: -5
N must be positive!
Enter an integer value for N: g
Entered value is not an integer!
Enter an integer value for N: 5

Enter integer 1 to average: 4
Enter integer 2 to average: 5
Enter integer 3 to average: -3
Entry must be positive! Try again.
Enter integer 3 to average: 3
Enter integer 4 to average: h
Entered value is not an integer!
Enter integer 4 to average: 6
Enter integer 5 to average: 10

The average of your entries is: 5.60
Process finished with exit code 0
 */


