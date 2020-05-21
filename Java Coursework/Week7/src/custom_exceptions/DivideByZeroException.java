package custom_exceptions;

public class DivideByZeroException extends Exception { // want it to be a checked exception - throwable is overkill


    public DivideByZeroException() {
        super("You can't divide by zero!"); // constructs exception w/ message "You can't divide by zero" (calls constructor of superclass Exception)
    }
}
