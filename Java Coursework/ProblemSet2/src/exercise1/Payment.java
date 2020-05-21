package exercise1;

public class Payment {
    // INSTANCE DATA
    private double amount;

    // CONSTRUCTOR
    public Payment(double amount) {
        this.amount = amount;
    }

    // ACCESSOR METHODS
        // Getter
    public double getAmount() {
        return amount;
    }

    // MUTATOR METHODS
        // Setter
    public void setAmount(double amount) {
        this.amount = amount;
    }

        // Prints payment details
    public void paymentDetails(){
        System.out.printf("Payment amount: $%.2f \n", this.amount);
    }
}
