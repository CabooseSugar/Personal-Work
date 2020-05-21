package exercise1;

import java.util.Scanner;

public class Fraction {

    public static void main(String[] args) {
        // Declaring variables and objects
        int num, denom, goAgain;
        double decimalForm;
        Fraction test = new Fraction();
        Fraction simplest = new Fraction();

        Scanner keyboard = new Scanner(System.in);

        while(true) {
            // Setting the numerator
            System.out.print("Enter a numerator value: ");
            num = keyboard.nextInt();
            test.setNum(num);

            // Setting the denominator
            System.out.print("Enter a denominator value: ");
            denom = keyboard.nextInt();
            test.setDenom(denom);

            // Outputting results
            System.out.format("Fraction is: %d/%d", test.getNum(), test.getDenom());

            // Converting fraction to decimal form
            decimalForm = test.convertToDecimal();
            System.out.format("\nIn decimal form, this fraction = %.3f ", decimalForm);

            // Converting fraction to lowest terms
            simplest = test.lowestTerms();
            System.out.format("\nIn simplest form, this fraction is written as: %d/%d",
                    simplest.getNum(), simplest.getDenom());

            // Run through program again?
            System.out.print("\nContinue? 1 for Yes, 2 for No: ");
            goAgain = keyboard.nextInt();
            if (goAgain == 1) {
                System.out.print("\n");
                continue;
            }
            else
                break;
        }
    }

    // Instance data
    private int num, denom;

    // CONSTRUCTOR
    public Fraction() {

    }

    // ACCESSOR METHODS
    public int getNum() {
        return num;
    }

    public int getDenom() {
        return denom;
    }

    // MUTATOR METHODS
    // set numerator
    public void setNum(int num) {
        this.num = num;
    }

    // set denominator
    public void setDenom(int denom) {
        this.denom = denom;
    }

    // Method to convert fraction to double decimal
    public double convertToDecimal() {
        double dNum, dDenom, result;

        dNum = num; // could write as this.num
        dDenom = denom;

        result = dNum / dDenom;

        return result;
    }

    // Method to reduce fraction to lowest terms
    public Fraction lowestTerms() {
        int lowestCommon = 2;
        int newNum = Math.abs(num), newDenom = Math.abs(denom); // use absolute values for while loop
        Fraction newFraction = new Fraction();

        while (lowestCommon <= newNum || lowestCommon <= newDenom) {
            if (newNum % lowestCommon != 0 || newDenom % lowestCommon != 0)
                lowestCommon++;
            else {
                newNum /= lowestCommon;
                newDenom /= lowestCommon;
                lowestCommon = 2;
            }
        }

        if (num < 0 && denom < 0) // returning values to negative if abs() made them positive
            ;
        else if (num < 0 || denom < 0)
            newNum *= -1;

        newFraction.setNum(newNum);
        newFraction.setDenom(newDenom);

        return newFraction;
    }
}

//TEST CODE
/*
Enter a numerator value: 1
Enter a denominator value: 3
Fraction is: 1/3
In decimal form, this fraction = 0.333
In simplest form, this fraction is written as: 1/3
Continue? 1 for Yes, 2 for No: 1

Enter a numerator value: 3
Enter a denominator value: 1
Fraction is: 3/1
In decimal form, this fraction = 3.000
In simplest form, this fraction is written as: 3/1
Continue? 1 for Yes, 2 for No: 1

Enter a numerator value: 66
Enter a denominator value: 99
Fraction is: 66/99
In decimal form, this fraction = 0.667
In simplest form, this fraction is written as: 2/3
Continue? 1 for Yes, 2 for No: 1

Enter a numerator value: 100
Enter a denominator value: -25
Fraction is: 100/-25
In decimal form, this fraction = -4.000
In simplest form, this fraction is written as: -4/1
Continue? 1 for Yes, 2 for No: 1

Enter a numerator value: -9
Enter a denominator value: -7
Fraction is: -9/-7
In decimal form, this fraction = 1.286
In simplest form, this fraction is written as: 9/7
Continue? 1 for Yes, 2 for No: 2

Process finished with exit code 0
 */