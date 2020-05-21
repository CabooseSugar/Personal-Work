package polymorphism;

import java.util.Scanner;

public class ShapeTest {

    public static void handleArea(Shape shape, String type) {
        System.out.println(String.format("AREA of %s: %s", type, shape.getArea()));
    }

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter square side length: ");
        Integer sideLength = keyboard.nextInt();
        Square s = new Square(sideLength);
        handleArea(s, "Square");

        System.out.print("\nEnter circle radius: ");
        Double radius = keyboard.nextDouble();
        Circle c = new Circle(radius);
        handleArea(c, "Circle");

    }
}
