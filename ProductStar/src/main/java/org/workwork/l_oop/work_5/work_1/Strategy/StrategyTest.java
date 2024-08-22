package org.workwork.l_oop.work_5.work_1.Strategy;

public class StrategyTest {
    public static void main(String[] args) {
        PaymentStrategy creditCard = new CreditCardPayment("1234-5678-9012-3456");
        PaymentStrategy payPal = new PayPalPayment("user@example.com");

        ShoppingCart cart1 = new ShoppingCart(creditCard);
        cart1.checkout(100);

        ShoppingCart cart2 = new ShoppingCart(payPal);
        cart2.checkout(200);
    }
}
