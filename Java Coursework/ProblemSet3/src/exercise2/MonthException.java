package exercise2;

public class MonthException extends Exception {

    public MonthException(){
        super("Invalid month, please re-enter.");
    }
}
