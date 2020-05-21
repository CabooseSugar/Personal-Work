package exercise3;

public class ShapeTest {
    public static void main(String[] args)
    {
        Circle c = new Circle(4); // Radius of 4
        Rectangle r = new Rectangle(4,3); // Height = 4, Width = 3
        ShowArea(c);
        ShowArea(r);
    }

    public static void ShowArea(Shape s)
    {
        double area = s.area();
        System.out.println("The area of the shape is " + area);
    }
}

/*
The area of the shape is 50.26548245743669
The area of the shape is 12.0

Process finished with exit code 0
 */


