package inheritance;

public class CarTest {
    public static void main(String[] args) {

        // base class/parent class
        Car subaru = new Car("ABC123", "Subaru", "Legacy", 1995, true, 3000.00, "Blue");

        // print out the car
        System.out.print(subaru);

        // new paint
        subaru.setColor("Red");

        System.out.println("\nAfter paint job:\n" + subaru);
        subaru.honkHorn();

        Truck hino = new Truck("DGE654", "Hino", "B-Series", 2000, true, 54320.2, 6, 19.4, 10000.0, true);

        System.out.print("\n"+ hino);

        // Truck delivers goods
        hino.setWeight(8000.0);

        System.out.println("\nAfter unload:\n" + hino);
        hino.honkHorn();

    }
}
