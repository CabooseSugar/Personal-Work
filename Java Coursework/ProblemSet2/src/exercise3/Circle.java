package exercise3;

public class Circle implements Shape {
    // INSTANCE DATA
    double radius;

    // CONSTRUCTOR
    public Circle(double radius) {
        this.radius = radius;
    }

    // GETTER
    public double getRadius() {
        return radius;
    }

    // SETTER
    public void setRadius(double radius) {
        this.radius = radius;
    }

    // RETURNS AREA OF CIRCLE
    public double area() {
        return Math.PI * Math.pow(this.radius,2);
    }
}
