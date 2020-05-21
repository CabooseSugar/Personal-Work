package inheritance;

// child of vehicle
// (1) car extends Vehicle
// (2) a car "is a" Vehicle

import java.util.Objects;

public class Car extends Vehicle{ // since Vehicle is abstract, must implement abstract method from Vehicle, honkHorn()

    //
    // INSTANCE DATA
    private String color;

    public Car(String vin, String make, String model, Integer year, Boolean is_manual, Double mileage, String color) { // alt inserted
        super(vin, make, model, year, is_manual, mileage); // super calls parent constructor
        this.color = color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    void honkHorn() {
        System.out.print("HONK");
    }
}
