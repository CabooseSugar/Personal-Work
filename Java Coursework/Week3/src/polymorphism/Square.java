package polymorphism;

//public class Square extends Shape {       // extends is for classes, implements if for interfaces
public class Square implements Shape {

    // INSTANCE DATA
    private Integer sideLength;

    public Square(Integer sideLength) {
        this.sideLength = sideLength;
    }

    public Integer getSideLength() {
        return sideLength;
    }

    public void setSideLength(Integer sideLength) {
        this.sideLength = sideLength;
    }

    @Override
    public double getArea() {
        return Math.pow(sideLength, 2);
    }
}
