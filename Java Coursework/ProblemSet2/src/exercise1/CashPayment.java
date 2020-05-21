package exercise1;

public class CashPayment extends Payment{
    // CONSTRUCTOR
    public CashPayment(double amount) {
        super(amount);
    }

    // MUTATOR METHODS
        // Specifies payment is in cash - prints
    public void paymentDetails() {
        super.paymentDetails(); // super used to call parent methods and variables, super() used for parent constructors
        System.out.println("Payment is in cash.");
    }
}
