package date_class;

public class Date_Test {

    public static void main(String[] args) {
        Date today = new Date( 8, 27, 2018);
        Date christmas = new Date(12,25,2018);
        Date christmas_copy = new Date(12,25,2018);

        if (today == christmas) // unlike C++ which compares objects directly, in Java here the == compares two memory references
                                // as a side note, know Java doesn't do overloaded operators like ==
            System.out.println("It's Christmas");
        else
            System.out.println("Not Christmas");

        if (today == today) // comparing memory location of today to memory location of today
            System.out.println("Same memory location.");

        if (christmas == christmas_copy)
            System.out.println("This shouldn't work...");
        else
            System.out.println("Not same memory location, despite identical variable values.");

        if (today.equals(christmas))
            System.out.println("It's Christmas");
        else
            System.out.println("It's not Christmas");

        if (christmas.equals(christmas_copy)) // our equals function here is overwritting one default, so in Java, no
                                                // overloaded operators, but can override default functions
            System.out.println("Custom equals method success, the two have same values, different memory locations.");

        /*
        String test = "12/25/2018";
        if (christmas.equals(test)) {
            System.out.println("Success");
        }
        */

        /*
        System.out.println(christmas); // need custom ToString method to make this work
        */

    }
}
