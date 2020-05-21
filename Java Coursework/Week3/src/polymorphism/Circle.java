package polymorphism;

//public class Circle extends Shape {
public class Circle implements Shape {

    // INSTANCE DATA
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * Math.pow(radius, 2); // static import Math?
    }
}
