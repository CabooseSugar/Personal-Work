package exception_handling;

public class BasicExceptionTest {
    public static void main(String[] args) {


        //
        // Case 1 and 2 are called UNCHECKED exceptions - do not require try/catch block, can compile and run (with errors)
        //

        // Case 1:
        /*
        int numbers[] = {1,2,3,4,5};
        System.out.println("First Number: " + numbers[0]);
        System.out.println("Last Number: " + numbers[4]);
        try {
            System.out.println("Incorrect Number: " + numbers[6]); // Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 6
        } catch(ArrayIndexOutOfBoundsException ex) {
            System.err.println(ex.getMessage());

        }
        */
        // Case 2:
        String s1 = null;
        String s2 = "123"; // can compare s1 to s2 when s2 = null, but not if s1 = null (java.lang.NullPointerException)
        try {
            Boolean areEqual = (s1.equals(s2));
            System.out.println(areEqual);
        } catch (NullPointerException ex) {
            int e = 4;
            System.err.println(ex.getMessage());
            //ex.printStackTrace();
        }

    }
}

// JAVA EXCEPTION TREE
/*
        Object
          |
       Throwable (checked)
       |        |
     Error    Exception (checked)
               |                |
    IO Exception (checked)   Runtime Exception (unchecked)
                                   |
                             Null pointer (unchecked)

*/


/*
CHECKED EXCEPTIONS:
 - compile time exceptions
 - require try/catch block

 UNCHECKED EXCEPTIONS:
 - extend RuntimeException
 - don't need try/catch block
 */

