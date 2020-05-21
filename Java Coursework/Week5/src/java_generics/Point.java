package java_generics;


// Java generics are like C++ templates - GET REST AND FINISH THIS CODE AT HOME
public class Point<T> {

    //
    // Instance data
    private T x;
    private T y;

    public Point(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public static Double slope(Point p1, Point p2) {
        return Double.valueOf((double)(p2.getY() - p1.getY()) / (p2.getX() - p1.getX()) / (double) );
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("(%s %s");
    }
}
