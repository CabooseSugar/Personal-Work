package exercise3;

public class Rectangle implements Shape{
    // INSTANCE DATA
    double length;
    double width;

    // CONSTRUCTOR
    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    // GETTERS
    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    // SETTERS
    public void setLength(double length) {
        this.length = length;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    // RETURNS AREA OF RECTANGLE
    public double area() {
        return this.length * this.width;
    }
}
