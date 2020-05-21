package exercise1;

public class CreditCardPayment extends Payment {
    // INSTANCE DATA
    private String name;
    private String expirationDate;
    private String number;

    // CONSTRUCTOR
    public CreditCardPayment(double amount, String name, String expirationDate, String number) {
        super(amount);
        this.name = name;
        this.expirationDate = expirationDate;
        this.number = number;
    }

    // MUTATOR METHODS
        // Specifies payment is with a credit card - prints with card details
    public void paymentDetails() {
        super.paymentDetails();
        System.out.println("Payment was made with a credit card.");
        System.out.println("Cardholder Name: " + this.name);
        System.out.println("Expiration Date: " + this.expirationDate);
        System.out.println("Card Number: " + this.number);
    }
}
