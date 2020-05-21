package wrapper_class;

public class WrapperTest {
    public static void main(String[] args) {

        //
        // primitive
        int answer = 42;

        //
        // Wrapper
        Integer anotherAnswer = 42;
        // called wrapped class because it represents Integer anotherAnswer = new Integer(42);

        Integer anotherOne = Integer.parseInt("55"); // takes string value and makes an int out of it for you

        String test = "3dso0454_43";
        if (Character.isDigit(test.charAt(0))) // makes first character on string into char for testing purposes
            System.out.println("starts with digit");
        else
            System.out.println("doesn't start with a digit");
        }
    }
