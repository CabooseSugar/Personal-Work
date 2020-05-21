package exercise3;

import java.util.Scanner;

public class Bowling {
    public static void main(String[] args) {
        int numRows;
        Scanner keyboard = new Scanner(System.in);

        System.out.printf("Enter the number of rows of bowling pins you want for your bowling alley: ");
        numRows = keyboard.nextInt();

        printPins(numRows, 0); // offset in practice here just changes how far from the left edge of the console
                                    // the entire pyramid is, needed for similar, more important reason inside recursive
    }

    public static void printPins(int n, int offset){
        if (n == 0) // base case
            return;
        else { // recursive case
            printPins(n - 1,offset+ 1); // recursive call subtracts one from n and adds one to offset.
            for (int j = offset; j > 0 ; j--)    // Here the purpose of offset is shown to print more blank space from left
                                                // edge the higher up each row is. So, it's responsible for the pyramid shape of pins.
                System.out.print(" ");          // (start high, end low)
            for (int i = 0; i < n; i++)         // Printing the number of stars recursively (start low, end high)
                System.out.print("* ");
            System.out.println();
            // printPins(n - 1); here instead would flip the pyramid upside down

        }
    }
}

/*
Enter the number of rows of bowling pins you want for your bowling alley: 5
    *
   * *
  * * *
 * * * *
* * * * *

Process finished with exit code 0
 */

/*
Enter the number of rows of bowling pins you want for your bowling alley: 1
*

Process finished with exit code 0
 */

/*
Enter the number of rows of bowling pins you want for your bowling alley: 10
         *
        * *
       * * *
      * * * *
     * * * * *
    * * * * * *
   * * * * * * *
  * * * * * * * *
 * * * * * * * * *
* * * * * * * * * *

Process finished with exit code 0
 */