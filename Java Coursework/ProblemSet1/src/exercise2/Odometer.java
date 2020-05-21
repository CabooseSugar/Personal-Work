package exercise2;

import java.util.Scanner;

public class Odometer {
    public static void main(String[] args) {

        // Declaring objects
        Odometer testOdom = new Odometer();

        Scanner keyboard = new Scanner(System.in);

        // Setting mpg
        System.out.print("Enter MPG of vehicle: ");
        testOdom.setMpg(keyboard.nextInt());

        // Testing adding miles to odometer
        System.out.println("\nMiles driven: " + testOdom.getMilesDriven());
        System.out.print("\nEnter amount of miles to add to odometer: ");
        testOdom.addMiles(keyboard.nextInt());
        System.out.println("New odometer value: " + testOdom.getMilesDriven());

        // Testing reset of odometer
        System.out.println("\nResetting odometer...");
        testOdom.resetOdometer();
        System.out.println("Miles driven: " + testOdom.getMilesDriven());

        // Adding more miles
        System.out.print("\nEnter amount of miles to add to odometer: ");
        testOdom.addMiles(keyboard.nextInt());
        System.out.print("Enter amount of miles to add to odometer: ");
        testOdom.addMiles(keyboard.nextInt());
        System.out.println("New odometer value: " + testOdom.getMilesDriven());

        // Calculating gallons consumed
        System.out.printf("\nGallons consumed since last reset: %.3f", testOdom.gallonsConsumed());

        // Testing to make sure gallonsConsumed method works as intended on reset of odometer
        testOdom.resetOdometer();
        System.out.println("\n\nResetting odometer...");
        System.out.printf("\nGallons consumed since last reset: %.3f", testOdom.gallonsConsumed());

    }

    // INSTANCE DATA
    private int milesDriven;
    private int mpg;

    // CONSTRUCTOR
    public Odometer() {
        this.milesDriven = 0;
    }

    // ACCESSOR METHODS
    public int getMilesDriven() {
        return milesDriven;
    }

    // MUTATOR METHODS
    // sets miles per gallon
    public void setMpg(int mpg) {
        this.mpg = mpg;
    }

    // Add miles to odometer
    public void addMiles(int miles) {
        this.milesDriven += miles;
    }

    // Reset odometer to 0 miles driven
    public void resetOdometer() {
        this.milesDriven = 0;
    }

    // Calculate and return gallons of gas consumed
    public double gallonsConsumed () {
        double gallons, dMiles = this.milesDriven, dMPG = this.mpg;

        gallons = dMiles / dMPG;

        return gallons;
    }
}

/*
Enter MPG of vehicle: 30

Miles driven: 0

Enter amount of miles to add to odometer: 50
New odometer value: 50

Resetting odometer...
Miles driven: 0

Enter amount of miles to add to odometer: 100
Enter amount of miles to add to odometer: 34
New odometer value: 134

Gallons consumed since last reset: 4.467

Resetting odometer...

Gallons consumed since last reset: 0.000
Process finished with exit code 0
 */
