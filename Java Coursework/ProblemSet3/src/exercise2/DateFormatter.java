package exercise2;

import java.time.Month;
import java.util.Scanner;

enum months {January, February, March, April, May, June, July, August, September, November, October, December}

public class DateFormatter {
    public static void main(String[] args) {
        int month = 0, day = 0, year = 0; // have to give initial values for final sout. Otherwise java thinks the values can
                                        // get through try-catches without being assigned a value
        Scanner keyboard = new Scanner(System.in).useDelimiter("[/\n]"); // also use newline /n as a delimiter since user hits enter

        while(true) {
            try {                                                                // after entering full date
                System.out.print("Enter a date in the format MM/DD/YYYY: ");
                month = keyboard.nextInt();
                if (month < 1 || month > 12)    // if month outside viable range, throw MonthException
                    throw new MonthException();
                day = keyboard.nextInt();
                if (day < 1 || day > 31)        // if day outside viable range, throw DayException
                    throw new DayException();
                year = keyboard.nextInt();
                if (year < 1000 || year > 3000) // if year outside viable range, throw YearException
                    throw new YearException();
                break;
            } catch (MonthException me) {       // catching exceptions
                System.err.println(me.getMessage());
                keyboard.next(); // skips entered day
                keyboard.next(); // skips entered year
            } catch (DayException de) {
                System.err.println(de.getMessage());
                keyboard.next(); // skips entered year
            } catch (YearException ye) {
                System.err.println(ye.getMessage());
            }
        }

        // Print results
        System.out.println("\n" + months.values()[month-1] + " " + day + " " + year); // get values of enum months as an array
    }
}

/*
Enter a date in the format MM/DD/YYYY: 1/22/1999

January 22 1999

Process finished with exit code 0
 */

/*
Enter a date in the format MM/DD/YYYY: 13/22/1999
Invalid month, please re-enter.
Enter a date in the format MM/DD/YYYY: 0/22/1999
Enter a date in the format MM/DD/YYYY: Invalid month, please re-enter.
3/0/2018
Enter a date in the format MM/DD/YYYY: Invalid day, please re-enter.
3/32/2018
Enter a date in the format MM/DD/YYYY: Invalid day, please re-enter.
3/15/999
Enter a date in the format MM/DD/YYYY: Invalid year, please re-enter.
3/15/3001
Invalid year, please re-enter.
Enter a date in the format MM/DD/YYYY: 3/15/2018

March 15 2018

Process finished with exit code 0
 */