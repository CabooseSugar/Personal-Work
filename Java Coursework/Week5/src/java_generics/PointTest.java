package java_generics;

public class PointTest {
    public static void main(String[] args) {
        Point p1 = new Point (1, 2);
        Point p2 = new Point (4, 3);
        System.out.println("SLOPE: " + Point.slope(p1, p2));
    }
}
