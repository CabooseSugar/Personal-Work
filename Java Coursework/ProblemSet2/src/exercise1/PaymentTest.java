package exercise1;

public class PaymentTest {
    public static void main(String[] args) {
        CashPayment cashTest1 = new CashPayment(5.00);
        CashPayment cashTest2 = new CashPayment(10.30);
        CreditCardPayment creditTest1 = new CreditCardPayment(6.00, "Bob Jenkins",
                "8/6/22", "1234-5678-9123-4567");
        CreditCardPayment creditTest2 = new CreditCardPayment(15.90, "Cindy Ross",
                "1/1/25", "9453-3443-2001-4999");

        cashTest1.paymentDetails();
        System.out.println();
        cashTest2.paymentDetails();
        System.out.println();
        creditTest1.paymentDetails();
        System.out.println();
        creditTest2.paymentDetails();
    }
}

/*
Payment amount: $5.00
Payment is in cash.

Payment amount: $10.30
Payment is in cash.

Payment amount: $6.00
Payment was made with a credit card.
Cardholder Name: Bob Jenkins
Expiration Date: 8/6/22
Card Number: 1234-5678-9123-4567

Payment amount: $15.90
Payment was made with a credit card.
Cardholder Name: Cindy Ross
Expiration Date: 1/1/25
Card Number: 9453-3443-2001-4999

Process finished with exit code 0
 */
